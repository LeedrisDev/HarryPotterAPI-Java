package com.epita.harrypotterapi.exposition.controllers;

import com.epita.harrypotterapi.exposition.request.RoomReservationRequest;
import com.epita.harrypotterapi.exposition.response.RoomAvailabilityResponse;
import com.epita.harrypotterapi.exposition.response.RoomReservationResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

@RestController
public class ReservationsController {

    @GetMapping("/reservations/rooms/availabilities")
    public ResponseEntity<Collection<RoomAvailabilityResponse>> getRoomsAvailabilities() {
        // TODO: Call ReservationService
        var response = new ArrayList<RoomAvailabilityResponse>();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/reservations/room/{roomName}")
    public ResponseEntity<Collection<RoomReservationResponse>> getRoomReservations(@PathParam("roomName") String roomName) {
        // TODO: Call ReservationService
        var response = new ArrayList<RoomReservationResponse>();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/reservations")
    public ResponseEntity<Collection<RoomReservationResponse>> getUserReservations(Principal principal) {
        // TODO: Call ReservationService
        var username = principal.getName();
        var response = new ArrayList<RoomReservationResponse>();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/reservations/room")
    public ResponseEntity<RoomReservationResponse> reserveRoom(@RequestBody RoomReservationRequest request) {
        // TODO: Call ReservationService
        var response = new RoomReservationResponse();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/reservations/room")
    public ResponseEntity<RoomReservationResponse> cancelRoomReservation(@RequestBody RoomReservationRequest request) {
        // TODO: Call ReservationService
        var response = new RoomReservationResponse();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
