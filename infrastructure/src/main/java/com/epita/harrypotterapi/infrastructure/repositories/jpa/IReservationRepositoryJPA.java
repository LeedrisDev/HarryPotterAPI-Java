package com.epita.harrypotterapi.infrastructure.repositories;

import com.epita.harrypotterapi.infrastructure.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepositoryJPA extends JpaRepository<ReservationEntity, Long> {
}
