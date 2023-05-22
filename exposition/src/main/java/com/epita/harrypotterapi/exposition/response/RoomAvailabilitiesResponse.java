package com.epita.harrypotterapi.exposition.response;

import java.time.LocalDate;
import java.util.List;

public class RoomAvailabilitiesResponse {
    private String roomName;
    private List<LocalDate> availableDates;

    public RoomAvailabilitiesResponse() { }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<LocalDate> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(List<LocalDate> availableDates) {
        this.availableDates = availableDates;
    }
}
