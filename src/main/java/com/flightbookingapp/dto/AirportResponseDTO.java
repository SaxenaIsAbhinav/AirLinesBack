package com.flightbookingapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AirportResponseDTO {

    private List<AirportDTO> data;

    public List<AirportDTO> getData() {
        return data;
    }

    public void setData(List<AirportDTO> data) {
        this.data = data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AirportDTO {
        private String skyId;
        private String entityId;
        private Presentation presentation;

        public String getSkyId() {
            return skyId;
        }

        public void setSkyId(String skyId) {
            this.skyId = skyId;
        }

        public String getEntityId() {
            return entityId;
        }

        public void setEntityId(String entityId) {
            this.entityId = entityId;
        }

        public Presentation getPresentation() {
            return presentation;
        }

        public void setPresentation(Presentation presentation) {
            this.presentation = presentation;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Presentation {
        private String title;
        private String subtitle;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }
    }
}
