package com.epita.harrypotterapi.exposition.controllers;


import com.epita.harrypotterapi.application.services.reservation.ReservationService;
import com.epita.harrypotterapi.application.services.room.RoomService;
import com.epita.harrypotterapi.domain.exceptions.ReservationException;
import com.epita.harrypotterapi.domain.exceptions.RoomException;
import com.epita.harrypotterapi.exposition.mappers.ReservationMapper;
import com.epita.harrypotterapi.exposition.mappers.RoomsMapper;
import com.epita.harrypotterapi.exposition.request.ReservationRequest;
import com.epita.harrypotterapi.exposition.response.BookingRoomResponse;
import com.epita.harrypotterapi.exposition.response.ErrorResponse;
import com.epita.harrypotterapi.exposition.response.ReservationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
@Tag(name = "Reservations")
public class ReservationsController {
    private final RoomService roomService;
    private final ReservationService reservationService;
    private final RoomsMapper roomsMapper;
    private final ReservationMapper reservationMapper;

    @Autowired
    public ReservationsController(RoomService roomService, @Qualifier("Exposition.RoomsMapper") RoomsMapper roomsMapper, @Qualifier("Exposition.ReservationMapper") ReservationMapper reservationMapper, ReservationService reservationService) {
        this.roomService = roomService;
        this.roomsMapper = roomsMapper;
        this.reservationMapper = reservationMapper;
        this.reservationService = reservationService;
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
    @ApiResponse(
            responseCode = "200",
            description = "List of all reservations the user has made",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ReservationResponse.class)))
    )
    public ResponseEntity<?> getUserReservations(Principal user) {
        var reservations = reservationService.getReservationsForAGivenWizard(user.getName());
        var response = reservations.stream().map(reservationMapper::mapToResponse).toList();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/reservation", produces = "application/json")
    @Operation(summary = "Create a new reservation for a room")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Reservation created",
                    content = @Content(schema = @Schema(implementation = BookingRoomResponse.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request body",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    public ResponseEntity<?> createReservation(@RequestBody ReservationRequest request, Principal user) {
        try {
            var reservation = reservationService.createReservation(request.getRoomName(), user.getName(), request.getBeginDate(), request.getEndDate());
            var response = reservationMapper.mapToResponse(reservation);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (ReservationException | RoomException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/reservation/{id}", produces = "application/json")
    @Operation(summary = "Delete a reservation")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Reservation deleted",
                    content = @Content(schema = @Schema(implementation = ReservationResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Reservation not found",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    public ResponseEntity<?> deleteReservation(@PathVariable("id") Long id) {
        try {
            var reservationDeleted = reservationService.deleteReservationById(id);
            var response = reservationMapper.mapToResponse(reservationDeleted);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (ReservationException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}