package com.epita.harrypotterapi.infrastructure.mappers;

import com.epita.harrypotterapi.domain.models.Reservation;
import com.epita.harrypotterapi.infrastructure.entities.ReservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("Infrastructure.ReservationMapper")
public class ReservationMapper {
    private final WizardsMapper wizardMapper;
    private final RoomsMapper roomMapper;

    @Autowired
    public ReservationMapper(WizardsMapper wizardMapper, @Qualifier("Infrastructure.RoomsMapper") RoomsMapper roomMapper) {
        this.wizardMapper = wizardMapper;
        this.roomMapper = roomMapper;
    }

    public ReservationEntity mapToEntity(Reservation reservation) {
        var reservationEntity = new ReservationEntity();
        reservationEntity.setWizard(wizardMapper.mapToEntity(reservation.getReservedBy()));
        reservationEntity.setRoom(roomMapper.mapToEntity(reservation.getRoom()));
        reservationEntity.setBeginDate(reservation.getBeginDate());
        reservationEntity.setEndDate(reservation.getEndDate());

        return reservationEntity;
    }

    public Reservation mapToDomain(ReservationEntity reservationEntity) {
        var reservation = new Reservation.Builder()
                .id(reservationEntity.getId())
                .reservedBy(wizardMapper.mapToDomain(reservationEntity.getWizard()))
                .room(roomMapper.mapToDomain(reservationEntity.getRoom()))
                .beginDate(reservationEntity.getBeginDate())
                .endDate(reservationEntity.getEndDate());

        return reservation.build();
    }
}
