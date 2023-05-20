package com.epita.harrypotterapi.exposition.request;

import java.util.Date;

public class RoomReservationRequest {
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
