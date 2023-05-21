package com.epita.harrypotterapi.infrastructure.mappers;

import com.epita.harrypotterapi.domain.models.room.Room;
import com.epita.harrypotterapi.infrastructure.entities.RoomEntity;

public class RoomsMapper {
    public static RoomEntity mapToEntity(Room room) {
        var entity = new RoomEntity();
        entity.setName(room.getName());
        entity.setType(room.getType());
        entity.setArea(room.getArea());
        entity.setCreationDate(room.getCreationDate());
        entity.setCreatorName(room.getCreatorName());
        return entity;
    }

    public static Room mapToDomain(RoomEntity entity) {
        return new Room.Builder()
                .name(entity.getName())
                .type(entity.getType())
                .area(entity.getArea())
                .creationDate(entity.getCreationDate())
                .creatorName(entity.getCreatorName())
                .build();
    }
}
