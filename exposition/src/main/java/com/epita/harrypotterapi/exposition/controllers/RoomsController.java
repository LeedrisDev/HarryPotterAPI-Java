package com.epita.harrypotterapi.exposition.controllers;

import com.epita.harrypotterapi.application.services.room.IRoomService;
import com.epita.harrypotterapi.domain.exceptions.RoomException;
import com.epita.harrypotterapi.exposition.mappers.RoomsMapper;
import com.epita.harrypotterapi.exposition.request.RoomRequest;
import com.epita.harrypotterapi.exposition.response.ErrorResponse;
import com.epita.harrypotterapi.exposition.response.RoomResponse;
import com.epita.harrypotterapi.exposition.utils.CsvParser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Rooms")
public class RoomsController {

    private final IRoomService roomService;
    private final CsvParser csvParser;
    private final RoomsMapper mapper;

    @Autowired
    public RoomsController(IRoomService roomService, CsvParser csvParser, @Qualifier("Exposition.RoomsMapper") RoomsMapper mapper) {
        this.roomService = roomService;
        this.csvParser = csvParser;
        this.mapper = mapper;
    }

    @PostMapping(value = "/room", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a single room")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Room created",
                    content = @Content(schema = @Schema(implementation = RoomResponse.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid input",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Room already exists",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    public ResponseEntity<?> createRoom(@RequestBody RoomRequest request, Principal user) {
        try {
            var room = mapper.mapToDomain(request, user.getName());
            var roomCreated = roomService.CreateRoom(room);
            var response = mapper.mapToResponse(roomCreated);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (RoomException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get all rooms")
    @ApiResponse(
            responseCode = "200", description = "A list of all rooms",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = RoomResponse.class)))
    )
    public ResponseEntity<List<RoomResponse>> getRooms() {
        var rooms  = roomService.getAllRooms();
        var response = rooms.stream().map(mapper::mapToResponse).toList();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/rooms/csv", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Create rooms from a csv file")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Rooms created",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = RoomResponse.class)))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid input",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(responseCode = "409",
                    description = "Room already exists",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    public ResponseEntity<?> createRoomsFromCsv(@RequestParam("file")MultipartFile file, Principal user) {
        try {
            var rooms = csvParser.parseCsv(file, user.getName());
            var roomsCreated = roomService.CreateRooms(rooms);
            var response = roomsCreated.stream().map(mapper::mapToResponse).toList();
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (RoomException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        catch (IOException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(new ErrorResponse("One of the room already exist."), HttpStatus.CONFLICT);
        }
    }
}