package com.HistoryUserOne.UserHistory.repository;

import com.HistoryUserOne.UserHistory.entity.Event;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EventRepository {
    private final List<Event> events = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public Event save(Event event){
        if(event.getEventId() == null){
            event.setEventId(idGenerator.getAndIncrement());
        }
        events.add(event);
        return event;
    }

    public List<Event> findAll(){
        return events;
    }

    public Optional<Event> findById(Integer id){
        return events.stream()
                .filter(e -> e.getEventId().equals(id))
                .findFirst();
    }

    public boolean deleteById(Integer id){
        return events.removeIf(event -> event.getEventId().equals(id));
    }

    public Event update(Event event){
        deleteById(event.getEventId());
        events.add(event);
        return event;
    }
}
