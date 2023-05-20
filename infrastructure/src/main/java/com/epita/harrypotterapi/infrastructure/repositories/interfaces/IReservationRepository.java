package com.epita.harrypotterapi.infrastructure.repositories.interfaces;

import com.epita.harrypotterapi.infrastructure.entities.ReservationEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IReservationRepository extends PagingAndSortingRepository<ReservationEntity, Long> {
}
