package com.HistoryUserOne.UserHistory.repository;

import com.HistoryUserOne.UserHistory.entity.Event;
import com.HistoryUserOne.UserHistory.entity.Venue;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class VenueRepository {
    private final List<Venue> venues = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public Venue save(Venue venue){
        if(venue.getVenueId() == null){
            venue.setVenueId(idGenerator.getAndIncrement());
        }
        venues.add(venue);
        return venue;
    }

    public List<Venue> findAll(){
        return venues;
    }

    public Optional<Venue> findById(Integer id){
        return venues.stream()
                .filter(venue -> venue.getVenueId().equals(id))
                .findFirst();
    }

    public boolean deleteById(Integer id){
        return venues.removeIf(venue -> venue.getVenueId().equals(id));
    }

    public Venue update(Venue venue){
        deleteById(venue.getVenueId());
        venues.add(venue);
        return venue;
    }
}
