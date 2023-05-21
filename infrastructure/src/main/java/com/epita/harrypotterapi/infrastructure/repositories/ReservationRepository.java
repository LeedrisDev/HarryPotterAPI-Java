package com.epita.harrypotterapi.infrastructure.repositories;

import com.epita.harrypotterapi.domain.models.Reservation;
import com.epita.harrypotterapi.domain.repositories.IReservationRepository;
import com.epita.harrypotterapi.infrastructure.repositories.jpa.IReservationRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationRepository implements IReservationRepository {
    private final IReservationRepositoryJPA reservationRepositoryJPA;

    @Autowired
    public ReservationRepository(IReservationRepositoryJPA reservationRepositoryJPA) {
        this.reservationRepositoryJPA = reservationRepositoryJPA;
    }

    public Reservation CreateReservation(Reservation reservation) {
        return null;
    }

    public Reservation GetReservationById(Long id) {
        return null;
    }

    public List<Reservation> GetReservationsByWizardId(Long wizardId) {
        return null;
    }

    public List<Reservation> GetReservationsByRoomId(Long roomId) {
        return null;
    }

    public void DeleteReservationById(Long id) {

    }
}
