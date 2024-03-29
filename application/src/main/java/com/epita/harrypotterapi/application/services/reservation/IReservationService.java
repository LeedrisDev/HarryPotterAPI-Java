package com.epita.harrypotterapi.application.services.reservation;

import com.epita.harrypotterapi.domain.exceptions.ReservationException;
import com.epita.harrypotterapi.domain.exceptions.RoomException;
import com.epita.harrypotterapi.domain.models.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface IReservationService {
    List<LocalDate> getAvailabilitiesForAGivenRoom(String roomName) throws RoomException;
    Reservation createReservation(String roomName, String wizardUsername, LocalDate beginDate, LocalDate endDate) throws RoomException, ReservationException;
    List<Reservation> getReservationsForAGivenWizard(String wizardUsername);
    Reservation deleteReservationById(long reservationId) throws ReservationException;
}
