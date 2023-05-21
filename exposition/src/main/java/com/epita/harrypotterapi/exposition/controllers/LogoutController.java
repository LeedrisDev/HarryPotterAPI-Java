package com.epita.harrypotterapi.exposition.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Tag(name = "Logout")
public class LogoutController {

    @GetMapping(value = "/logout")
    @Operation(summary = "Logout")
    public String logout() {
        return "redirect:/login";
    }
}
