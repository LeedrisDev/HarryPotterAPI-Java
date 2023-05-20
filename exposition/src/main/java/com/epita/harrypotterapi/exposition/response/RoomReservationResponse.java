package com.epita.harrypotterapi.exposition.response;

import java.util.Date;

public class RoomReservationResponse {
    private String roomName;
    private Date startDate;
    private Date endDate;
    private String reservedBy;

    public String getRoomName() {
        return roomName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getReservedBy() {
        return reservedBy;
    }
}
