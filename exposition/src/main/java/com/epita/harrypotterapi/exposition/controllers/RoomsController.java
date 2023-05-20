package com.epita.harrypotterapi.exposition.controllers;

import com.epita.harrypotterapi.exposition.response.RoomResponse;
import com.epita.harrypotterapi.exposition.request.RoomRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@Tag(name = "Rooms")
public class RoomsController {

    @GetMapping(value = "/rooms", produces = "application/json")
    public ResponseEntity<Collection<RoomResponse>> getRooms() {
        // TODO: Call RoomService
        var response = new ArrayList<RoomResponse>();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/rooms", produces = "application/json")
    public ResponseEntity<RoomResponse> createRoom(@RequestBody RoomRequest request) {
        // TODO: Call RoomService
        var response = new RoomResponse();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping(value = "/rooms/csv", produces = "application/json")
    public ResponseEntity<Collection<RoomResponse>> createRoomsFromCsv(@RequestParam("file")MultipartFile file) {
        // TODO: Call RoomService
        var response = new ArrayList<RoomResponse>();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // TODO: Add update and delete endpoints (maybe)
}