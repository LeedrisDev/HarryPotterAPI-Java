package com.epita.harrypotterapi.application.services.room;

import com.epita.harrypotterapi.domain.models.room.Room;

import java.util.List;

public interface IRoomService {
    List<Room> getAllRooms();
    Room CreateRoom(Room room);
    List<Room> CreateRooms(List<Room> rooms);
}
