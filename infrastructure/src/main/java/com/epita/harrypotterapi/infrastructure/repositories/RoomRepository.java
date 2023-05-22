package com.epita.harrypotterapi.infrastructure.repositories;

import com.epita.harrypotterapi.domain.exceptions.RoomException;
import com.epita.harrypotterapi.domain.models.room.Room;
import com.epita.harrypotterapi.domain.repositories.IRoomRepository;
import com.epita.harrypotterapi.infrastructure.mappers.RoomsMapper;
import com.epita.harrypotterapi.infrastructure.repositories.jpa.IRoomRepositoryJPA;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomRepository implements IRoomRepository {
    private final IRoomRepositoryJPA roomRepository;
    private final RoomsMapper mapper;

    @Autowired
    public RoomRepository(IRoomRepositoryJPA roomRepository, @Qualifier("Infrastructure.RoomsMapper") RoomsMapper mapper) {
        this.roomRepository = roomRepository;
        this.mapper = mapper;
    }

    public List<Room> getAllRooms() {
        var roomsEntities = this.roomRepository.findAll();
        return roomsEntities.stream().map(mapper::mapToDomain).toList();
    }

    @Transactional
    public Room CreateRoom(Room room) {
        var entity = mapper.mapToEntity(room);
        var savedEntity = this.roomRepository.save(entity);
        return mapper.mapToDomain(savedEntity);
    }

    @Transactional
    public List<Room> CreateRooms(List<Room> rooms) {
        var entities = rooms.stream().map(mapper::mapToEntity).toList();
        var entitiesSaved = this.roomRepository.saveAll(entities);
        return entitiesSaved.stream().map(mapper::mapToDomain).toList();
    }

    public Room getRoomByName(String roomName) throws RoomException {
        var roomEntity = this.roomRepository.getRoomEntityByName(roomName);
        if (roomEntity == null)
            throw new RoomException("Room '" + roomName + "' not found");

        return mapper.mapToDomain(roomEntity);
    }
}
