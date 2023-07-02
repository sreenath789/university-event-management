package com.example.universityeventmanagement.Repository;

import com.example.universityeventmanagement.Model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends CrudRepository<Event,Integer> {
    @Query("select al from Event al where al.date=?1")
    Iterable<Event> findAllEventsByDate(String date);
}
