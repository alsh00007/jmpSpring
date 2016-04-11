package jmp.dao;

import jmp.domain.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventDao extends DomainOjectDao<Event> {

    List<Event> findEvents(LocalDate date);

    Event getEventById(Integer eventId);
}
