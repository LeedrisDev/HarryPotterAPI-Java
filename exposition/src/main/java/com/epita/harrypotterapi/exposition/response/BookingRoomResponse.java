package com.epita.harrypotterapi.exposition.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

@JsonPropertyOrder({"name", "type", "area", "creationDate", "creatorName", "isBookable"})
public class BookingRoomResponse {
    private String name;
    private String type;
    private double area;
    private LocalDate creationDate;
    private String creatorName;
    private Boolean isBookable;

    public BookingRoomResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Boolean getBookable() {
        return isBookable;
    }

    public void setBookable(Boolean bookable) {
        isBookable = bookable;
    }
}
