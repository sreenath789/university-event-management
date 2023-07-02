package com.example.universityeventmanagement.Service;

import com.example.universityeventmanagement.Model.Event;
import com.example.universityeventmanagement.Repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    EventRepo eventRepo;
    public String addEvent(Event event) {
        eventRepo.save(event);
        return "Event Added";
    }

    public Iterable<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public Iterable<Event> getAllEventsByDate(String date) {
        return eventRepo.findAllEventsByDate(date);
    }

    public String updateEvent(int id, String locationOfEvent) {
        Iterable<Event> events = eventRepo.findAll();
        for(Event event : events){
            if(event.getEventId()==id) {
                event.setLocationOfEvent(locationOfEvent);
                eventRepo.save(event);
                return "Event Updated with id : "+id;
            }
        }
        return "Event Not found by id : "+id;
    }

    public String deleteEventById(int id) {
        Iterable<Event> events = eventRepo.findAll();
        for(Event event : events){
            if(event.getEventId()==id) {
                eventRepo.deleteById(id);
                return "Event deleted with id : "+id;
            }
        }
        return "Event Not found by id : "+id;
    }
}
