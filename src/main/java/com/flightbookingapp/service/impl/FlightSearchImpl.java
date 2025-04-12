package com.flightbookingapp.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightbookingapp.dto.*;
import com.flightbookingapp.entity.Flight;
import com.flightbookingapp.service.FlightSearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class FlightSearchImpl implements FlightSearchService {
    @Value("${rapidapi.key}")
    private String RAPIDAPI_KEY;

    @Value("${rapidapi.url}")
    private String RAPIDAPI_URL;

    private final boolean testing_api = false;
//	private final Map<String, List<FlightDTO>> cache = new ConcurrentHashMap<>();

    private final Map<String, FlightResponseDTO> cache = new ConcurrentHashMap<>();

    private final String dummyResponse = "{}"; // """ { "status": true, "timestamp": 1732864255785, "data": [...] } """;
    //	public List<FlightDTO>
//	public Object
    public FlightResponseDTO searchFlights(String fromSkyId, String fromEntityId, String toSkyId, String toEntityId,
                                           String departureDate, String returnDate, int adults, int children, int infants, String tripType) {
        String currency = "INR";
        int limit = 50;
        String sortBy = "best";
        String cabinClass = "economy";

// Update the cache key to include all parameters that influence the search results
        String cacheKey = fromSkyId + "-" + fromEntityId + "-" + toSkyId + "-" + toEntityId + "-" + departureDate + "-"
                + returnDate + "-" + adults + "-" + children + "-" + infants + "-" + tripType;

//		if (cache.containsKey(cacheKey)) {
//			System.out.println("Cache hit for query: " + cacheKey);
//			return cache.get(cacheKey);
//		}
        // Check if the cache already contains this key
        // Check if the cache already contains this key
        if (cache.containsKey(cacheKey)) {
            System.out.println("Cache hit for query: " + cacheKey);
            return cache.get(cacheKey);  // Return cached response which includes both flights and filters
        }
        System.out.println("Cache miss for query: FlightSearch CALL " + cacheKey);
        List<FlightDTO> flights = new ArrayList<>();
        FlightFilterDTO flightFilters = null;

        try {
            if (testing_api) {
                System.out.println("Using dummy data for query: FlightSearch CALL " + cacheKey);
                flights = parseResponse(dummyResponse);
            } else {
                StringBuilder endpoint = new StringBuilder(RAPIDAPI_URL + "/api/v2/flights/searchFlights?");
                endpoint.append("originSkyId=").append(fromSkyId).append("&destinationSkyId=").append(toSkyId)
                        .append("&originEntityId=").append(fromEntityId) // Add originEntityId
                        .append("&destinationEntityId=").append(toEntityId) // Add destinationEntityId
                        .append("&date=").append(departureDate).append("&cabinClass=").append(cabinClass)
                        .append("&adults=").append(adults).append("&childrens=").append(children).append("&infants=")
                        .append(infants).append("&sortBy=").append(sortBy).append("&limit=").append(limit) // Set limit to 1
                        .append("&currency=").append(currency).append("&market=en-GB") // Add market
                        .append("&countryCode=IN"); // Add countryCode

                if ("round-trip".equalsIgnoreCase(tripType)) {
                    endpoint.append("&returnDate=").append(returnDate);
                }

// Print the final URL for debugging
                System.out.println("\n Generated URL: " + endpoint.toString());

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
//						.uri(URI.create("https://sky-scrapper.p.rapidapi.com/api/v2/flights/searchFlights?originSkyId=LOND&destinationSkyId=NYCA&originEntityId=27544008&destinationEntityId=27537542&date=2024-12-30&cabinClass=economy&adults=1&childrens=0&infants=0&sortBy=best&limit=2&currency=INR&market=en-GB&countryCode=IN"))
                        .uri(URI.create(endpoint.toString()))
                        .header("X-RapidAPI-Host", "sky-scrapper.p.rapidapi.com").header("X-RapidAPI-Key", RAPIDAPI_KEY)
                        .GET().build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() == 200) {

                    System.out.println("i am gettign this flihgths servicc" );
                    System.out.println(response.body());

                    flights = parseResponse(response.body());
                    flightFilters = parseResponseForFilter(response.body());


                } else {
// Log detailed error message including status code and response body
                    System.err.println("Error: Received HTTP response code " + response.statusCode());
                    System.err.println("Response body: " + response.body());

// Log more descriptive messages based on common status codes
                    switch (response.statusCode()) {
                        case 400:
                            System.err.println("Bad Request: The request was invalid or cannot be otherwise served.");
                            break;
                        case 404:
                            System.err.println("Not Found: The endpoint or resource could not be found.");
                            break;
                        case 500:
                            System.err.println(
                                    "Internal Server Error: There was an error processing the request on the server.");
                            break;
                        case 503:
                            System.err.println(
                                    "Service Unavailable: The service is temporarily unavailable. Please try again later.");
                            break;
                        default:
                            System.err.println("Unexpected error occurred: " + response.statusCode());
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

// Cache the results for this query if there are any results
//		if (!flights.isEmpty()) {
//			cache.put(cacheKey, flights);
//		}
        // Cache the results for this query if there are any flights and filters
        if (!flights.isEmpty() && flightFilters != null) {
            // Cache both flights and filters together
            cache.put(cacheKey, new FlightResponseDTO(flights, flightFilters));
        }

        System.out.println("i am gettign this flihgths servicc" );
        System.out.println(flights);
        // Return both flight data and filter data in the required format
        return new FlightResponseDTO(flights, flightFilters);

//        return new Object() {
//            public final List<FlightDTO> flightsData = flights;
//            public final FlightFilterDTO filtersData = flightFilters;
//        };
//		return flights;
    }
    // Parse response for filters
    private FlightFilterDTO parseResponseForFilter(String jsonResponse) {
        FlightFilterDTO filterDTO = new FlightFilterDTO();
        try {
            JsonNode rootNode = new ObjectMapper().readTree(jsonResponse);

            JsonNode filters = rootNode.path("data").path("filterStats");
//            JsonNode filters = rootNode.path("filterStats");
            System.out.println(" parseResponseForFilter filters: " + filters);
            // Parse the filter data from the JSON response
            JsonNode durationNode = filters.path("duration");
            DurationFilterDTO durationFilter = new DurationFilterDTO();
            durationFilter.setMin(durationNode.path("min").asInt());
            durationFilter.setMax(durationNode.path("max").asInt());
            durationFilter.setMultiCityMin(durationNode.path("multiCityMin").asInt());
            durationFilter.setMultiCityMax(durationNode.path("multiCityMax").asInt());
            filterDTO.setDuration(durationFilter);

            // Parse airports
            List<AirportFilterDTO> airportList = new ArrayList<>();
            for (JsonNode airportNode : filters.path("airports")) {
                AirportFilterDTO airportFilter = new AirportFilterDTO();
                airportFilter.setCity(airportNode.path("city").asText());
                List<AirportDetailFilterDTO> airportDetails = new ArrayList<>();
                for (JsonNode airportDetail : airportNode.path("airports")) {
                    AirportDetailFilterDTO airportDetailDTO = new AirportDetailFilterDTO();
                    airportDetailDTO.setId(airportDetail.path("id").asText());
                    airportDetailDTO.setEntityId(airportDetail.path("entityId").asText());
                    airportDetailDTO.setName(airportDetail.path("name").asText());
                    airportDetails.add(airportDetailDTO);
                }
                airportFilter.setAirports(airportDetails);
                airportList.add(airportFilter);
            }
            filterDTO.setAirports(airportList);

            // Parse carriers
            List<CarrierFilterDTO> carrierList = new ArrayList<>();
            for (JsonNode carrierNode : filters.path("carriers")) {
                CarrierFilterDTO carrierFilter = new CarrierFilterDTO();
                carrierFilter.setId(carrierNode.path("id").asInt());
                carrierFilter.setAlternateId(carrierNode.path("alternateId").asText());
                carrierFilter.setLogoUrl(carrierNode.path("logoUrl").asText());
                carrierFilter.setName(carrierNode.path("name").asText());
                carrierList.add(carrierFilter);
            }
            filterDTO.setCarriers(carrierList);

            // Parse stop prices
            StopPriceFilterDTO stopPrices = new StopPriceFilterDTO();
            JsonNode stopPriceNode = filters.path("stopPrices");
            StopPriceDTO directStopPrice = new StopPriceDTO();
            directStopPrice.setPresent(stopPriceNode.path("direct").path("isPresent").asBoolean());
            directStopPrice.setFormattedPrice(stopPriceNode.path("direct").path("formattedPrice").asText());
            stopPrices.setDirect(directStopPrice);

            StopPriceDTO oneStopPrice = new StopPriceDTO();
            oneStopPrice.setPresent(stopPriceNode.path("one").path("isPresent").asBoolean());
            oneStopPrice.setFormattedPrice(stopPriceNode.path("one").path("formattedPrice").asText());
            stopPrices.setOne(oneStopPrice);

            filterDTO.setStopPrices(stopPrices);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filterDTO;
    }

    private List<FlightDTO> parseResponse(String jsonResponse) {
        List<FlightDTO> flightDTOList = new ArrayList<>();

        try {
            JsonNode rootNode = new ObjectMapper().readTree(jsonResponse);
            JsonNode itineraries = rootNode.path("data").path("itineraries");

            for (JsonNode itinerary : itineraries) {
                String airline = itinerary.path("legs").get(0).path("carriers").path("marketing").get(0).path("name")
                        .asText();
                String airlineLogo = itinerary.path("legs").get(0).path("carriers").path("marketing").get(0)
                        .path("logoUrl").asText();
                int totalDuration = itinerary.path("legs").get(0).path("durationInMinutes").asInt();
                String departureTime = itinerary.path("legs").get(0).path("departure").asText();
                int stops = itinerary.path("legs").get(0).path("stopCount").asInt();
                String price = itinerary.path("price").path("formatted").asText();

                // Extract additional details for the Flight model
                List<Flight.Leg> legs = new ArrayList<>();
                for (JsonNode legNode : itinerary.path("legs").get(0).path("segments")) {
                    Flight.Leg leg = new Flight.Leg(legNode.path("origin").path("displayCode").asText(),
                            legNode.path("destination").path("displayCode").asText(),
                            legNode.path("departure").asText(), legNode.path("arrival").asText(),
                            legNode.path("durationInMinutes").asInt(), legNode.path("stopCount").asInt());
                    legs.add(leg);
                }

                Flight flight = new Flight();
                flight.setLegs(legs);
                flight.setPrice(itinerary.path("price").path("raw").asDouble());

                FlightDTO flightDTO = new FlightDTO(airline, airlineLogo, totalDuration, departureTime, stops, price,
                        legs);
                flightDTOList.add(flightDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flightDTOList;
    }
}
