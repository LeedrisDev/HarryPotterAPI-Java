package com.epita.harrypotterapi.domain.repositories;

import com.epita.harrypotterapi.domain.models.room.Room;

import java.util.List;

public interface IRoomRepository {
    List<Room> getAllRooms();
    Room CreateRoom(Room room);
    List<Room> CreateRooms(List<Room> rooms);
}
