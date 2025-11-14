package com.HistoryUserOne.UserHistory.controller;

import com.HistoryUserOne.UserHistory.dto.VenueDTO;
import com.HistoryUserOne.UserHistory.service.VenueService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venues")
public class VenueController {

    private final VenueService service;

    public VenueController(VenueService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<VenueDTO> createVenue(@Valid @RequestBody VenueDTO dto) {
        VenueDTO created = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<VenueDTO>> getAllVenues() {
        return ResponseEntity.ok(service.findAll());
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<VenueDTO> getVenueById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<VenueDTO> updateVenue(
            @PathVariable Integer id,
            @Valid @RequestBody VenueDTO dto
    ) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenue(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
