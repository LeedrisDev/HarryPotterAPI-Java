package com.epita.harrypotterapi.infrastructure.repositories;

import com.epita.harrypotterapi.domain.exceptions.ReservationException;
import com.epita.harrypotterapi.domain.models.Reservation;
import com.epita.harrypotterapi.domain.models.room.Room;
import com.epita.harrypotterapi.domain.models.wizard.Wizard;
import com.epita.harrypotterapi.domain.repositories.IReservationRepository;
import com.epita.harrypotterapi.infrastructure.mappers.ReservationMapper;
import com.epita.harrypotterapi.infrastructure.mappers.RoomsMapper;
import com.epita.harrypotterapi.infrastructure.repositories.jpa.IReservationRepositoryJPA;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationRepository implements IReservationRepository {
    private final IReservationRepositoryJPA reservationRepositoryJPA;
    private final RoomsMapper roomsMapper;
    private final ReservationMapper reservationMapper;

    @Autowired
    public ReservationRepository(IReservationRepositoryJPA reservationRepositoryJPA,
                                 @Qualifier("Infrastructure.RoomsMapper") RoomsMapper roomsMapper,
                                 @Qualifier("Infrastructure.ReservationMapper") ReservationMapper reservationMapper) {
        this.reservationRepositoryJPA = reservationRepositoryJPA;
        this.roomsMapper = roomsMapper;
        this.reservationMapper = reservationMapper;
    }

    @Transactional
    public Reservation createReservation(Reservation reservation) {
        var reservationEntity = reservationMapper.mapToEntity(reservation);
        System.out.println(reservationEntity.getWizard());
        System.out.println(reservationEntity.getRoom());
        var reservationSaved = reservationRepositoryJPA.save(reservationEntity);
        return reservationMapper.mapToDomain(reservationSaved);
    }

    public Reservation getReservationById(Long id) {
        return null;
    }

    public List<Reservation> getReservationsByWizard(Wizard wizard) {
        var reservationEntities = reservationRepositoryJPA.getReservationEntitiesByWizardId(wizard.getId());

        return reservationEntities.stream().map(reservationMapper::mapToDomain).toList();
    }

    public List<Reservation> getReservationsByRoom(Room room) {
        var roomEntity = roomsMapper.mapToEntity(room);

        var reservationsEntities = reservationRepositoryJPA.getReservationEntitiesByRoomOrderByBeginDate(roomEntity);

        return reservationsEntities.stream().map(reservationMapper::mapToDomain).toList();
    }

    @Transactional
    public Reservation deleteReservationById(Long id) throws ReservationException {
        var reservationToDelete = reservationRepositoryJPA.findById(id);
        if (reservationToDelete.isEmpty())
            throw new ReservationException("Reservation with id " + id + " not found");

        reservationRepositoryJPA.deleteById(id);

        return reservationMapper.mapToDomain(reservationToDelete.get());
    }
}
