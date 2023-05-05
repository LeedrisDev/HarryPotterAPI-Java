package com.epita.harrypotterapi.exposition.controllers;

import com.epita.harrypotterapi.domain.service.IRoomService;
import com.epita.harrypotterapi.exposition.request.RoomRequest;
import com.epita.harrypotterapi.exposition.response.RoomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class RoomsController {
    private final IRoomService roomService;

    public RoomsController(IRoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public ResponseEntity<Collection<RoomResponse>> getRooms() {
        // TODO: Call RoomService
        var response = new ArrayList<RoomResponse>();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/rooms")
    public ResponseEntity<RoomResponse> createRoom(@RequestBody RoomRequest request) {
        // TODO: Call RoomService
        var response = new RoomResponse();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/rooms/csv")
    public ResponseEntity<Collection<RoomResponse>> createRoomsFromCsv(@RequestParam("file")MultipartFile file) {
        // TODO: Call RoomService
        var response = new ArrayList<RoomResponse>();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // TODO: Add update and delete endpoints
}
