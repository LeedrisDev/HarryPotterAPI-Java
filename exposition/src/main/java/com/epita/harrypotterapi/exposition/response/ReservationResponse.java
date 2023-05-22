package com.epita.harrypotterapi.exposition.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

@JsonPropertyOrder({"reservationId", "roomName", "reservedBy", "beginDate", "endDate"})
public class ReservationResponse {
    private long ReservationId;
    private String roomName;
    private String reservedBy;
    private LocalDate beginDate;
    private LocalDate endDate;

    public ReservationResponse() {
    }

    public Long getReservationId() {
        return ReservationId;
    }

    public void setReservationId(Long reservationId) {
        ReservationId = reservationId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
