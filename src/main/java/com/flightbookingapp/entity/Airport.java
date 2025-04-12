package com.flightbookingapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "airports")
public class Airport {

    @Id
    private String skyId;

    private String entityId;
    private String title;
    private String subtitle;


    public Airport() {
    }

    public Airport(String skyId, String entityId, String title, String subtitle) {
        this.skyId = skyId;
        this.entityId = entityId;
        this.title = title;
        this.subtitle = subtitle;
    }



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



    @Override
    public String toString() {
        return "Airport{" +
                "skyId='" + skyId + '\'' +
                ", entityId='" + entityId + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                '}';
    }
}
