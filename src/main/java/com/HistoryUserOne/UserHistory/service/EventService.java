package com.HistoryUserOne.UserHistory.service;

import com.HistoryUserOne.UserHistory.dto.EventDTO;
import com.HistoryUserOne.UserHistory.entity.Event;
import com.HistoryUserOne.UserHistory.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EventService {

    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    //CREATE
    public EventDTO create(EventDTO dto){
        if(dto.getEventName().isBlank()){
            throw new IllegalArgumentException("The name can't be null");
        }
        if(dto.getEventDescription().isBlank()){
            throw new IllegalArgumentException("The description can't be null");
        }

        // Setters to create
        Event event = new Event();
        event.setEventName(dto.getEventName());
        event.setEventDescription(dto.getEventDescription());
        event.setDate(dto.getDate());

        Event saved = repository.save(event);

        return EventDTO.builder()
                .eventId(saved.getEventId())
                .eventName(saved.getEventName())
                .build();
    }

    public List<EventDTO> findAll(){
        return repository.findAll().stream()
                .map(event -> EventDTO.builder()
                        .eventId(event.getEventId())
                        .eventName(event.getEventName())
                        .eventDescription(event.getEventDescription())
                        .date(event.getDate())
                        .build()
                )
                .toList();
    }


    public EventDTO findById(Integer id){
        Event e = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Event not founded"));
        return EventDTO.builder()
                .eventId(e.getEventId())
                .eventName(e.getEventName())
                .eventDescription(e.getEventDescription())
                .date(e.getDate())
                .build();
    }

    public EventDTO update(Integer id, EventDTO dto){
        Event e = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Venue not found"));

        e.setEventName(dto.getEventName());
        e.setEventDescription(dto.getEventDescription());
        e.setDate(dto.getDate());

        Event updated = repository.update(e);

        return EventDTO.builder()
                .eventId(updated.getEventId())
                .eventName(updated.getEventName())
                .eventDescription(updated.getEventDescription())
                .date(updated.getDate())
                .build();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
