package com.epita.harrypotterapi.infrastructure.repositories.jpa;

import com.epita.harrypotterapi.infrastructure.entities.ReservationEntity;
import com.epita.harrypotterapi.infrastructure.entities.RoomEntity;
import com.epita.harrypotterapi.infrastructure.entities.WizardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReservationRepositoryJPA extends JpaRepository<ReservationEntity, Long> {
    List<ReservationEntity> getReservationEntitiesByRoom(RoomEntity room);
    List<ReservationEntity> getReservationEntitiesByWizardId(long wizardId);
}
