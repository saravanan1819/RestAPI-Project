package com.example.digitalart.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="event")

public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String eventName;
    private String tasks;
    private String guests;
    public EventEntity() {
    }
    public EventEntity(int id, String eventName, String tasks, String guests) {
        this.id = id;
        this.eventName = eventName;
        this.tasks = tasks;
        this.guests = guests;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public String getTasks() {
        return tasks;
    }
    public void setTasks(String tasks) {
        this.tasks = tasks;
    }
    public String getGuests() {
        return guests;
    }
    public void setGuests(String guests) {
        this.guests = guests;
    }
    
    
}
