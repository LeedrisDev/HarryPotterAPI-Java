package com.epita.harrypotterapi.application;

import com.epita.harrypotterapi.domain.models.room.Room;

import java.util.List;

public interface IRoomService {
    List<Room> getAllRooms();
    Room CreateRoom(Room room);
    void CreateRooms(List<Room> rooms);
}
