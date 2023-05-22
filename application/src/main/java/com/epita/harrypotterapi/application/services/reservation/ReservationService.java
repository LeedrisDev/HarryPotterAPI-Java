package com.epita.harrypotterapi.application.services.reservation;

import com.epita.harrypotterapi.domain.exceptions.ReservationException;
import com.epita.harrypotterapi.domain.exceptions.RoomException;
import com.epita.harrypotterapi.domain.models.Reservation;
import com.epita.harrypotterapi.infrastructure.repositories.ReservationRepository;
import com.epita.harrypotterapi.infrastructure.repositories.RoomRepository;
import com.epita.harrypotterapi.infrastructure.repositories.WizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService implements IReservationService {
    private final WizardRepository wizardRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(WizardRepository wizardRepository, RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.wizardRepository = wizardRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservationsForAGivenRoom(String roomName) throws RoomException {
        var room = roomRepository.getRoomByName(roomName);
        if (room == null)
            throw new RoomException("Room with name " + roomName + " does not exist");

        return reservationRepository.getReservationsByRoom(room);
    }

    public List<Reservation> getAvailabilitiesForAGivenRoom(String roomName) {
        return null;
    }

    public Reservation createReservation(String roomName, String wizardUsername, LocalDate beginDate, LocalDate endDate) throws ReservationException {
        var room = roomRepository.getRoomByName(roomName);
        if (room == null)
            throw new ReservationException("Room with name " + roomName + " does not exist.");

        var wizard = wizardRepository.getWizardByUsername(wizardUsername);

        var reservation = new Reservation.Builder()
                .room(room, true)
                .reservedBy(wizard)
                .beginDate(beginDate, true)
                .endDate(endDate, true)
                .build();

        var reservations = reservationRepository.getReservationsByRoom(room);
        for (var r : reservations) {
            if (isDatesOverlaping(r.getBeginDate(), r.getEndDate(), reservation.getBeginDate(), reservation.getEndDate()))
                throw new ReservationException("Reservation dates are overlapping with another reservation, please choose another date.");
        }

        return reservationRepository.createReservation(reservation);
    }

    private boolean isDatesOverlaping(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return start1.isBefore(end2) && start2.isBefore(end1);
    }
}
