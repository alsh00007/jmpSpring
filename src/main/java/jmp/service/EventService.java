package jmp.service;

import jmp.domain.Event;
import jmp.domain.User;

import java.time.LocalDate;
import java.util.List;

public interface EventService {
    List<Event> findEvents(LocalDate date);

    void buyTicket(Event event, Integer place, User user);

    Event getEventById(Integer eventId);

    Event save(Event event);
}
