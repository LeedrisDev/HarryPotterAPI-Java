package com.epita.harrypotterapi.exposition.controllers;

import com.epita.harrypotterapi.exposition.response.RoomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class RoomsController {

    @GetMapping("/rooms")
    public ResponseEntity<Collection<RoomResponse>> getRooms() {
        var response = new ArrayList<RoomResponse>();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/rooms")
    public ResponseEntity<RoomResponse> createRoom() {
        var response = new RoomResponse();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/rooms/csv")
    public ResponseEntity<Collection<RoomResponse>> createRoomsFromCsv() {
        var response = new ArrayList<RoomResponse>();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // TODO: Add update and delete endpoints
}
