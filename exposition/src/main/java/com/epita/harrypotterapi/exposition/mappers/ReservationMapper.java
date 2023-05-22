package com.epita.harrypotterapi.exposition.mappers;

import com.epita.harrypotterapi.domain.models.Reservation;
import com.epita.harrypotterapi.exposition.response.ReservationResponse;
import org.springframework.stereotype.Component;

@Component("Exposition.ReservationMapper")
public class ReservationMapper {
    public ReservationResponse mapToResponse(Reservation reservation) {
        var response = new ReservationResponse();
        response.setReservationId(reservation.getId());
        response.setBeginDate(reservation.getBeginDate());
        response.setEndDate(reservation.getEndDate());
        response.setRoomName(reservation.getRoom().getName());
        response.setReservedBy(reservation.getReservedBy().getName());

        return response;
    }
}
