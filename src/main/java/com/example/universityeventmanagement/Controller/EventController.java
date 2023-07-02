package com.example.universityeventmanagement.Controller;

import com.example.universityeventmanagement.Model.Department;
import com.example.universityeventmanagement.Model.Event;
import com.example.universityeventmanagement.Service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("event")
public class EventController {

    @Autowired
    EventService eventService;
    @PostMapping("addEvent")
    public String addEvent(@RequestBody @Valid Event event){
        return eventService.addEvent(event);
    }

    @GetMapping("getAllEvents")
    public Iterable<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    @GetMapping("getAllEventsByDate/{date}")
    public Iterable<Event> getAllEventsByDate(@PathVariable String date){
        return eventService.getAllEventsByDate(date);
    }

    @PutMapping("updateEvent/{id}/{locationOfEvent}")
    public String updateEvent(@PathVariable int id, @PathVariable String locationOfEvent){
        return eventService.updateEvent(id,locationOfEvent);
    }

    @DeleteMapping("deleteEvent/{id}")
    public String deleteEventById(@PathVariable int id){
        return eventService.deleteEventById(id);
    }








}
