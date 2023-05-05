package com.epita.harrypotterapi.exposition.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomAvailabilityResponse {
    private String name;
    public boolean isAvailable;
}
