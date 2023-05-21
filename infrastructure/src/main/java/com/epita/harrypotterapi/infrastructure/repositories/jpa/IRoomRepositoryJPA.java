package com.epita.harrypotterapi.infrastructure.repositories.jpa;

import com.epita.harrypotterapi.infrastructure.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomRepositoryJPA extends JpaRepository<RoomEntity, Long> {
}
