package com.epita.harrypotterapi.exposition.response;

public class RoomAvailabilityResponse {
    private String name;
    public boolean isAvailable;

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
