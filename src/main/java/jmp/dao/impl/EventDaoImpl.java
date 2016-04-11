package jmp.dao.impl;

import jmp.dao.EventDao;
import jmp.domain.Event;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EventDaoImpl extends DomainObjectDaoImpl<Event> implements EventDao {

    private static final Set<Event> STORAGE = new HashSet<>();

    static {
        Event event1 = new Event();
        event1.setMovieName("Star war");
        Set<Integer> freePlaces1 = new HashSet<>();
        freePlaces1.add(1);
        freePlaces1.add(2);
        freePlaces1.add(3);
        freePlaces1.add(4);
        event1.setFreePlaces(freePlaces1);
        event1.setPrice(10);
        event1.setId(1);
        event1.setStartTime(LocalDateTime.of(2016, 4, 11, 15, 0));
        STORAGE.add(event1);

        Event event2 = new Event();
        event2.setMovieName("Terminator");
        Set<Integer> freePlaces2 = new HashSet<>();
        freePlaces2.add(1);
        freePlaces2.add(2);
        freePlaces2.add(3);
        freePlaces2.add(4);
        event2.setFreePlaces(freePlaces2);
        event2.setPrice(10);
        event2.setId(2);
        event2.setStartTime(LocalDateTime.of(2016, 4, 11, 19, 0));
        STORAGE.add(event2);

        Event event3 = new Event();
        event3.setMovieName("Batman");
        Set<Integer> freePlaces3 = new HashSet<>();
        freePlaces3.add(1);
        freePlaces3.add(2);
        freePlaces3.add(3);
        freePlaces3.add(4);
        event3.setFreePlaces(freePlaces3);
        event3.setPrice(10);
        event3.setId(3);
        event3.setStartTime(LocalDateTime.of(2016, 4, 11, 21, 0));
        STORAGE.add(event3);

    }

    public EventDaoImpl() {
        super(STORAGE);
    }

    @Override
    public List<Event> findEvents(LocalDate date) {
        return STORAGE.stream().filter(event -> event.getStartTime().toLocalDate().equals(date)).
                collect(Collectors.toList());

    }

    @Override
    public Event getEventById(Integer eventId) {
        for (Event event : STORAGE) {
            if (event.getId().equals(eventId)) {
                return event;
            }
        }
        return null;
    }
}
