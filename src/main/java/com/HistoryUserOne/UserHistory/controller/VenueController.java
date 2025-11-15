package com.HistoryUserOne.UserHistory.controller;

import com.HistoryUserOne.UserHistory.dto.VenueDTO;
import com.HistoryUserOne.UserHistory.service.VenueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Venues", description = "CRUD operations for Venues")
@RestController
@RequestMapping("/venues")
public class VenueController {

    private final VenueService service;

    public VenueController(VenueService service) {
        this.service = service;
    }

    // CREATE
    @Operation(summary = "Create a new venue")
    @PostMapping
    public ResponseEntity<VenueDTO> createVenue(@Valid @RequestBody VenueDTO dto) {
        VenueDTO created = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // READ ALL
    @Operation(summary = "Get all venues")
    @GetMapping
    public ResponseEntity<List<VenueDTO>> getAllVenues() {
        return ResponseEntity.ok(service.findAll());
    }

    // READ ONE
    @Operation(summary = "Get venue by ID")
    @GetMapping("/{id}")
    public ResponseEntity<VenueDTO> getVenueById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // UPDATE
    @Operation(summary = "Update a venue")
    @PutMapping("/{id}")
    public ResponseEntity<VenueDTO> updateVenue(
            @PathVariable Integer id,
            @Valid @RequestBody VenueDTO dto
    ) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a venue")
    public ResponseEntity<Void> deleteVenue(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
