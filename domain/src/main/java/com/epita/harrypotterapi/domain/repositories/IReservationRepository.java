package com.epita.harrypotterapi.domain.repositories;

import com.epita.harrypotterapi.domain.exceptions.ReservationException;
import com.epita.harrypotterapi.domain.models.Reservation;
import com.epita.harrypotterapi.domain.models.room.Room;
import com.epita.harrypotterapi.domain.models.wizard.Wizard;

import java.util.List;

public interface IReservationRepository {
    Reservation createReservation(Reservation reservation);
    List<Reservation> getReservationsByWizard(Wizard wizard);
    List<Reservation> getReservationsByRoom(Room room);
    Reservation deleteReservationById(Long id) throws ReservationException;
}
