package com.HistoryUserOne.UserHistory.service;

import com.HistoryUserOne.UserHistory.dto.EventDTO;
import com.HistoryUserOne.UserHistory.dto.VenueDTO;
import com.HistoryUserOne.UserHistory.entity.Event;
import com.HistoryUserOne.UserHistory.entity.Venue;
import com.HistoryUserOne.UserHistory.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VenueService {

    private final VenueRepository repository;

    public VenueService(VenueRepository repository) {
        this.repository = repository;
    }


    //CREATE
    public VenueDTO create(VenueDTO dto){
        if(dto.getVenueName().isBlank()){
            throw new IllegalArgumentException("The name can't be null");
        }
        if(dto.getVenueDescription().isBlank()){
            throw new IllegalArgumentException("The description can't be null");
        }
        if(dto.getVenueAddress().isBlank()){
            throw new IllegalArgumentException("The address can't be null");
        }

        // Setters to create
        Venue venue= new Venue();
        venue.setVenueName(dto.getVenueName());
        venue.setVenueDescription(dto.getVenueDescription());
        venue.setVenueAddress(dto.getVenueAddress());

        Venue saved = repository.save(venue);

        return VenueDTO.builder()
                .venueId(saved.getVenueId())
                .venueName(saved.getVenueName())
                .build();
    }

    public List<VenueDTO> findAll(){
        return repository.findAll().stream()
                .map(venue -> VenueDTO.builder()
                .venueId(venue.getVenueId())
                .venueName(venue.getVenueName())
                .venueAddress(venue.getVenueAddress())
                .venueDescription(venue.getVenueDescription())
                .build())
                .toList();
    }

    public VenueDTO findById(Integer id){
        Venue v = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Event not founded"));
        return VenueDTO.builder()
                .venueName(v.getVenueName())
                .venueDescription(v.getVenueDescription())
                .venueAddress(v.getVenueAddress())
                .build();
    }

    public VenueDTO update(Integer id, VenueDTO dto){
        Venue v = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Venue not found"));

        v.setVenueName(dto.getVenueName());
        v.setVenueDescription(dto.getVenueDescription());
        v.setVenueAddress(dto.getVenueAddress());

        Venue updated = repository.update(v);

        return VenueDTO.builder()
                .venueId(updated.getVenueId())
                .venueName(updated.getVenueName())
                .venueDescription(updated.getVenueDescription())
                .venueAddress(updated.getVenueAddress())
                .build();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
