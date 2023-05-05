package com.epita.harrypotterapi.exposition.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomReservationRequest {
    private String roomName;
    private String startDate;
    private String endDate;
    private String reservedBy;
}
