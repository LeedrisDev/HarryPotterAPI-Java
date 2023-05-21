package com.epita.harrypotterapi.infrastructure.repositories;

import com.epita.harrypotterapi.domain.models.room.Room;
import com.epita.harrypotterapi.domain.repositories.IRoomRepository;
import com.epita.harrypotterapi.infrastructure.mappers.RoomsMapper;
import com.epita.harrypotterapi.infrastructure.repositories.jpa.IRoomRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomRepository implements IRoomRepository {
    private final IRoomRepositoryJPA roomRepository;

    @Autowired
    public RoomRepository(IRoomRepositoryJPA roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        var roomsEntities = this.roomRepository.findAll();
        return roomsEntities.stream().map(RoomsMapper::mapToDomain).toList();
    }

    public Room CreateRoom(Room room) {
        var entity = RoomsMapper.mapToEntity(room);
        var savedEntity = this.roomRepository.save(entity);
        return RoomsMapper.mapToDomain(savedEntity);
    }

    public List<Room> CreateRooms(List<Room> rooms) {
        var entities = rooms.stream().map(RoomsMapper::mapToEntity).toList();
        var entitiesSaved = this.roomRepository.saveAll(entities);
        return entitiesSaved.stream().map(RoomsMapper::mapToDomain).toList();
    }
}
