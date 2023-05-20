package com.epita.harrypotterapi.infrastructure.repositories;

import com.epita.harrypotterapi.infrastructure.entities.RoomEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRoomRepository extends PagingAndSortingRepository<RoomEntity, Long> {
}
