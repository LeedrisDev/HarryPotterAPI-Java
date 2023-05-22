package com.epita.harrypotterapi.exposition.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

@JsonPropertyOrder({"name", "type", "area", "creationDate", "creatorName"})
public class RoomResponse {
    private String name;
    private String type;
    private double area;
    private LocalDate creationDate;
    private String creatorName;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getArea() {
        return area;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
}
