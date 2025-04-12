package com.flightbookingapp.service.impl;

import com.flightbookingapp.dto.AirportResponseDTO;
import com.flightbookingapp.entity.Airport;
import com.flightbookingapp.exception.ApiException;
import com.flightbookingapp.repository.AirportRepository;
import com.flightbookingapp.service.AirportService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class AirportServiceImpl implements AirportService {

    @Value("${rapidapi.key}")
    private String apiKey;

    @Value("${rapidapi.url}")
    private String apiUrl;

    private final AirportRepository airportRepository;

    private final Map<String, List<Airport>> cache = new ConcurrentHashMap<>();

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public List<Airport> searchAirports(String query) {
        if (cache.containsKey(query)) {
            System.out.println("Cache hit for query : "+ query );
            return cache.get(query);
        }

        List<Airport> airportList = new ArrayList<>();

        try {
            String endpoint = apiUrl + "?query=" + query + "&locale=en-US";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .header("X-RapidAPI-Host", "sky-scrapper.p.rapidapi.com")
                    .header("X-RapidAPI-Key", apiKey)
                    .GET()
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                airportList = parseResponse(response.body());
                cache.put(query, airportList);
                airportRepository.saveAll(airportList);
            } else {
                throw new ApiException("Failed to fetch airports. Status: " + response.statusCode());
            }

        } catch (Exception e) {
            throw new ApiException("API error: " + e.getMessage());
        }

        return airportList;
    }

    private List<Airport> parseResponse(String jsonResponse) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            AirportResponseDTO response = mapper.readValue(jsonResponse, AirportResponseDTO.class);

            return response.getData().stream()
                    .map(dto -> new Airport(
                            dto.getSkyId(),
                            dto.getEntityId(),
                            dto.getPresentation().getTitle(),
                            dto.getPresentation().getSubtitle()
                    ))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new ApiException("Failed to parse airport data. "+ e.getMessage());
        }
    }

//    private List<Airport> parseResponse(String jsonResponse) {
//        List<Airport> list = new ArrayList<>();
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode root = mapper.readTree(jsonResponse);
//            JsonNode dataNode = root.path("data");
//
//            if (dataNode.isArray()) {
//                for (JsonNode node : dataNode) {
//                    String skyId = node.path("skyId").asText();
//                    String entityId = node.path("entityId").asText();
//                    String title = node.path("presentation").path("title").asText();
//                    String subtitle = node.path("presentation").path("subtitle").asText();
//
//                    list.add(new Airport(skyId, entityId, title, subtitle));
//                }
//            }
//        } catch (Exception e) {
//            throw new ApiException("Failed to parse airport data.");
//        }
//        return list;
//    }
}
