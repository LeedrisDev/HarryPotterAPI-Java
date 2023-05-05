package com.epita.harrypotterapi.exposition.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomsController {

    @GetMapping("/rooms")
    public String getRooms() {
        return "Hello World";
    }
}
