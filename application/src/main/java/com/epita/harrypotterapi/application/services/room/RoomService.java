package com.epita.harrypotterapi.application.services.room;

import com.epita.harrypotterapi.domain.models.room.Room;
import com.epita.harrypotterapi.infrastructure.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.getAllRooms();
    }

    public Room CreateRoom(Room room) {
        return roomRepository.CreateRoom(room);
    }

    public List<Room> CreateRooms(List<Room> rooms) {
        return roomRepository.CreateRooms(rooms);
    }
}
