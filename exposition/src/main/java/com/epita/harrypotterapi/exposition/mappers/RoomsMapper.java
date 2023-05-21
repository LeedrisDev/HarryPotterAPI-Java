package com.epita.harrypotterapi.exposition.mappers;

import com.epita.harrypotterapi.domain.exceptions.RoomException;
import com.epita.harrypotterapi.domain.models.room.Room;
import com.epita.harrypotterapi.domain.models.room.RoomType;
import com.epita.harrypotterapi.exposition.request.RoomRequest;
import com.epita.harrypotterapi.exposition.response.RoomResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component("Exposition.RoomsMapper")
public class RoomsMapper {
    public RoomResponse mapToResponse(Room room) {
        var response = new RoomResponse();
        response.setName(room.getName());
        response.setArea(room.getArea());
        response.setCreationDate(room.getCreationDate());
        response.setCreatorName(room.getCreatorName());

        switch (room.getType()) {
            case Potion -> response.setType("Potion");
            case Spell -> response.setType("Spell");
            case Herbology -> response.setType("Herbology");
            case Quidditch -> response.setType("Quidditch");
            case Office -> response.setType("Office");
            case CommonRoom -> response.setType("CommonRoom");
        }

        return response;
    }

    public Room mapToDomain(RoomRequest request, String creatorName) throws RoomException {
        var room = new Room.Builder()
                .name(request.getName())
                .area(request.getArea())
                .creationDate(LocalDate.now())
                .creatorName(creatorName);

        switch (request.getType()) {
            case "Potion" -> room.type(RoomType.Potion);
            case "Spell" -> room.type(RoomType.Spell);
            case "Herbology" -> room.type(RoomType.Herbology);
            case "Quidditch" -> room.type(RoomType.Quidditch);
            case "Office" -> room.type(RoomType.Office);
            case "CommonRoom" -> room.type(RoomType.CommonRoom);
            default -> throw new RoomException("Invalid room type, please choose between Potion, Spell, Herbology, Quidditch, Office or CommonRoom.");
        }

        return room.build();
    }
}
