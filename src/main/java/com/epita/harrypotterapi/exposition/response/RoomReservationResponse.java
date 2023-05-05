package com.epita.harrypotterapi.exposition.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomReservationResponse {
    private String roomName;
    private String startDate;
    private String endDate;
    private String reservedBy;
}
