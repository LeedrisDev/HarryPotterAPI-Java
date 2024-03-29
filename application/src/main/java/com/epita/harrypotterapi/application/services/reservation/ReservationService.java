package com.epita.harrypotterapi.application.services.reservation;

import com.epita.harrypotterapi.domain.exceptions.ReservationException;
import com.epita.harrypotterapi.domain.exceptions.RoomException;
import com.epita.harrypotterapi.domain.models.Reservation;
import com.epita.harrypotterapi.domain.repositories.IReservationRepository;
import com.epita.harrypotterapi.domain.repositories.IRoomRepository;
import com.epita.harrypotterapi.domain.repositories.IWizardRepository;
import com.epita.harrypotterapi.domain.services.IMailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService implements IReservationService {
    private final IWizardRepository wizardRepository;
    private final IRoomRepository roomRepository;
    private final IReservationRepository reservationRepository;
    private final IMailingService mailingService;

    @Autowired
    public ReservationService(IWizardRepository wizardRepository, IRoomRepository roomRepository, IReservationRepository reservationRepository, IMailingService mailingService) {
        this.wizardRepository = wizardRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
        this.mailingService = mailingService;
    }

    public List<LocalDate> getAvailabilitiesForAGivenRoom(String roomName) throws RoomException {
        var room = roomRepository.getRoomByName(roomName);

        var reservations = reservationRepository.getReservationsByRoom(room);

        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusDays(30);

        return calculateFreeDaysInRange(reservations, today, endDate);
    }

    public Reservation createReservation(String roomName, String wizardUsername, LocalDate beginDate, LocalDate endDate) throws ReservationException, RoomException {
        var room = roomRepository.getRoomByName(roomName);

        var wizard = wizardRepository.getWizardByUsername(wizardUsername);

        var reservation = new Reservation.Builder()
                .room(room, true)
                .reservedBy(wizard)
                .beginDate(beginDate, true)
                .endDate(endDate, true)
                .build();

        var reservations = reservationRepository.getReservationsByRoom(room);
        for (var r : reservations) {
            if (isDatesOverlapping(r.getBeginDate(), r.getEndDate(), reservation.getBeginDate(), reservation.getEndDate()))
                throw new ReservationException("Reservation dates are overlapping with another reservation, please choose another date.");
        }

        var createdReservation = reservationRepository.createReservation(reservation);
        mailingService.sendMailReservationCreated(createdReservation.getReservedBy(), reservation);

        return createdReservation;
    }

    public List<Reservation> getReservationsForAGivenWizard(String wizardUsername) {
        var wizard = wizardRepository.getWizardByUsername(wizardUsername);

        return reservationRepository.getReservationsByWizard(wizard);
    }

    public Reservation deleteReservationById(long reservationId) throws ReservationException {
        var reservationDeleted = reservationRepository.deleteReservationById(reservationId);
        mailingService.sendMailReservationDeleted(reservationDeleted.getReservedBy(), reservationDeleted);

        return reservationDeleted;
    }

    private boolean isDatesOverlapping(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return start1.isBefore(end2.plusDays(1)) && start2.isBefore(end1.plusDays(1));
    }

    private List<LocalDate> calculateFreeDaysInRange(List<Reservation> reservations, LocalDate startDate, LocalDate endDate) {
        List<LocalDate> freeDays = new ArrayList<>();

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            boolean isFree = true;

            for (Reservation reservation : reservations) {
                if (isDatesOverlapping(currentDate, currentDate, reservation.getBeginDate(), reservation.getEndDate())) {
                    isFree = false;
                    break;
                }
            }

            if (isFree)
                freeDays.add(currentDate);

            currentDate = currentDate.plusDays(1);
        }

        return freeDays;
    }
}
