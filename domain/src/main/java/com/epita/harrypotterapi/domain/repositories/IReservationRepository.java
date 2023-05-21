package com.epita.harrypotterapi.domain.repositories;

import com.epita.harrypotterapi.domain.models.Reservation;

import java.util.List;

public interface IReservationRepository {
    Reservation CreateReservation(Reservation reservation);
    Reservation GetReservationById(Long id);
    List<Reservation> GetReservationsByWizardId(Long wizardId);
    List<Reservation> GetReservationsByRoomId(Long roomId);
    void DeleteReservationById(Long id);
}
