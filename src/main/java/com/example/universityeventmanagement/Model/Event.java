package com.example.universityeventmanagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="event")
public class Event {
    @Id
    private int eventId;
    private String eventName;
    private String locationOfEvent;
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "Date of Birth must be in the format dd-mm-yyyy")
    private String date;
    @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d$")
    private String startTime;
    @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d$")
    private String endTime;
}
