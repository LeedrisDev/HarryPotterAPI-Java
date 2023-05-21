package com.epita.harrypotterapi.exposition.controllers;

import com.epita.harrypotterapi.application.IRoomService;
import com.epita.harrypotterapi.domain.exceptions.RoomException;
import com.epita.harrypotterapi.exposition.request.RoomRequest;
import com.epita.harrypotterapi.exposition.response.ErrorResponse;
import com.epita.harrypotterapi.exposition.response.RoomResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.epita.harrypotterapi.exposition.mappers.RoomsMapper;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name = "Rooms")
public class RoomsController {

    private final IRoomService roomService;

    @Autowired
    public RoomsController(IRoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(value = "/rooms", produces = "application/json")
    public ResponseEntity<List<RoomResponse>> getRooms() {
        var rooms  = roomService.getAllRooms();
        var response = rooms.stream().map(RoomsMapper::mapToResponse).toList();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/room", produces = "application/json")
    public ResponseEntity<?> createRoom(@RequestBody RoomRequest request, Principal principal) {

        String username = "Dumbledore";

        try {
            var room = RoomsMapper.mapToDomain(request, username);
            System.out.println(room.toString());
            var roomCreated = roomService.CreateRoom(room);
            var response = RoomsMapper.mapToResponse(roomCreated);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (RoomException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/rooms/csv", produces = "application/json")
    public ResponseEntity<List<RoomResponse>> createRoomsFromCsv(@RequestParam("file")MultipartFile file) {
        // TODO: Call RoomService
        var response = new ArrayList<RoomResponse>();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // TODO: Add update and delete endpoints (maybe)
}