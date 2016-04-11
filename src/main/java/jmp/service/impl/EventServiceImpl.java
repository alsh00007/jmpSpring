package jmp.service.impl;

import jmp.dao.EventDao;
import jmp.dao.OrderDao;
import jmp.domain.Event;
import jmp.domain.Order;
import jmp.domain.User;
import jmp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao eventDao;

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Event> findEvents(LocalDate date) {
        return eventDao.findEvents(date);
    }

    @Override
    public void buyTicket(Event event, Integer place, User user) {
        Order order = new Order();
        order.setMovieName(event.getMovieName());
        order.setPlace(place);
        order.setStartTime(event.getStartTime());
        order.setUser(user);

        event.getFreePlaces().remove(place);
        eventDao.save(event);
        orderDao.save(order);

    }

    @Override
    public Event getEventById(Integer eventId) {

        return eventDao.getEventById(eventId);
    }

    @Override
    public Event save(Event event) {
        return  eventDao.save(event);
    }
}
