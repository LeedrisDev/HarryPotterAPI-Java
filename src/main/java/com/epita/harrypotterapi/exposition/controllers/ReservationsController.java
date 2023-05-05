package com.epita.harrypotterapi.exposition.controllers;

import com.epita.harrypotterapi.exposition.request.RoomReservationRequest;
import com.epita.harrypotterapi.exposition.response.RoomAvailabilityResponse;
import com.epita.harrypotterapi.exposition.response.RoomReservationResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@Tag(name = "Reservations")
public class ReservationsController {

    @GetMapping(value = "/reservations/rooms/availabilities", produces = "application/json")
    public ResponseEntity<Collection<RoomAvailabilityResponse>> getRoomsAvailabilities() {
        // TODO: Call ReservationService
        var response = new ArrayList<RoomAvailabilityResponse>();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/reservations/roomReservations/", produces = "application/json")
    public ResponseEntity<Collection<RoomReservationResponse>> getRoomReservations(@RequestParam("roomName") String roomName) {
        // TODO: Call ReservationService
        var response = new ArrayList<RoomReservationResponse>();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/reservations", produces = "application/json")
    public ResponseEntity<Collection<RoomReservationResponse>> getUserReservations(Principal principal) {
        // TODO: Call ReservationService
        var username = principal.getName();
        var response = new ArrayList<RoomReservationResponse>();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/reservations/room", produces = "application/json")
    public ResponseEntity<RoomReservationResponse> reserveRoom(@RequestBody RoomReservationRequest request) {
        // TODO: Call ReservationService
        var response = new RoomReservationResponse();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/reservations/room", produces = "application/json")
    public ResponseEntity<RoomReservationResponse> cancelRoomReservation(@RequestBody RoomReservationRequest request) {
        // TODO: Call ReservationService
        var response = new RoomReservationResponse();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
