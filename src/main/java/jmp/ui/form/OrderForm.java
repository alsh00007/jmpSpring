package jmp.ui.form;

import java.util.Map;

public class OrderForm {
    private Integer userId;

    private Map<Integer, String> users;

    private Integer eventId;

    private Map<Integer, String> events;

    private Map<Integer, Integer> freePlaces;

    private Integer place;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Map<Integer, String> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, String> users) {
        this.users = users;
    }

    public Map<Integer, String> getEvents() {
        return events;
    }

    public void setEvents(Map<Integer, String> events) {
        this.events = events;
    }

    public Map<Integer, Integer> getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(Map<Integer, Integer> freePlaces) {
        this.freePlaces = freePlaces;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }
}
