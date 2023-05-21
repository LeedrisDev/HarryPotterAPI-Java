package com.epita.harrypotterapi.exposition.controllers;


import com.epita.harrypotterapi.application.RoomService;
import com.epita.harrypotterapi.exposition.mappers.RoomsMapper;
import com.epita.harrypotterapi.exposition.response.BookingRoomResponse;
import com.epita.harrypotterapi.exposition.response.RoomResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Reservations")
public class ReservationsController {
    private final RoomService roomService;
    private final RoomsMapper roomsMapper;

    @Autowired
    public ReservationsController(RoomService roomService, @Qualifier("Exposition.RoomsMapper") RoomsMapper roomsMapper) {
        this.roomService = roomService;
        this.roomsMapper = roomsMapper;
    }

    @GetMapping(value = "/reservations/rooms/bookable", produces = "application/json")
    @Operation(summary = "Get all rooms with bookable status")
    @ApiResponse(
            responseCode = "200",
            description = "List of all rooms in the school, with bookable status",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = BookingRoomResponse.class)))
    )
    public ResponseEntity<?> getBookableRoomsWithBookableStatus() {
        var rooms = roomService.getAllRooms();
        var response = rooms.stream().map(roomsMapper::mapToBookingRoomResponse).toList();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/reservations/room/availabilities", produces = "application/json")
    @Operation(summary = "Get availabilities for a given room")
    public ResponseEntity<?> getAvailabilitiesForAGivenRoom(@RequestParam("roomName") String roomName) {
        // TODO: Call ReservationService

        var response = new ArrayList<>();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/reservations", produces = "application/json")
    @Operation(summary = "Get all reservations the user has made")
    public ResponseEntity<?> getUserReservations(Principal principal) {
        // TODO: Call ReservationService

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(value = "/reservation", produces = "application/json")
    @Operation(summary = "Create a new reservation for a room")
    public ResponseEntity<?> createReservation(@RequestBody String roomName, Principal principal) {
        // TODO: Call ReservationService

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping(value = "/reservation/{id}", produces = "application/json")
    @Operation(summary = "Delete a reservation")
    public ResponseEntity<?> deleteReservation(@PathVariable("id") Long id) {
        // TODO: Call ReservationService

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}