package jmp.ui;

import jmp.domain.Event;
import jmp.domain.Order;
import jmp.domain.User;
import jmp.service.EventService;
import jmp.service.OrderService;
import jmp.service.UserService;
import jmp.ui.form.DeleteOrderForm;
import jmp.ui.form.OrderForm;
import jmp.ui.form.SearchEventForm;
import jmp.ui.form.SearchOrderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class TicketController {

    @Autowired
    private EventService eventService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    private SimpleDateFormat dateFormat;

    @Value("yyyy-MM-dd")
    private String dateFormatPattern;


    @RequestMapping(value = "/showAddOrder")
    public String showAddOrder(HttpSession session, Map<String, Object> map) {
        Map<Integer, String> users = new HashMap<>();
        for (User user : userService.getAllUsers()) {
            users.put(user.getUserId(), user.getFirstName() + " " + user.getSecondName());
        }
        OrderForm orderForm = new OrderForm();
        orderForm.setUsers(users);
        map.put("orderForm", orderForm);

        return "event-select";
    }

    @RequestMapping(value = "/start")
    public String start(Map<String, Object> map) {
        SearchEventForm searchEventForm = new SearchEventForm();
        searchEventForm.setDay(new Date());
        map.put("searchEventForm", searchEventForm);
        return "start";
    }

    @RequestMapping(value = "/searchEvent", method = RequestMethod.POST)
    public String searchEvent(@ModelAttribute("searchEventForm") SearchEventForm searchEventForm,
                              BindingResult result, ModelMap model, Map<String, Object> map) {
        Date input = new Date();
        LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Map<Integer, String> eventMap = new HashMap<>();
        List<Event> events = eventService.findEvents(date);
        for (Event event : events) {
            eventMap.put(event.getId(), event.getMovieName() + " " + event.getStartTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        }

        Map<Integer, String> users = new HashMap<>();
        for (User user : userService.getAllUsers()) {
            users.put(user.getUserId(), user.getFirstName() + " " + user.getSecondName());
        }

        OrderForm eventForm = new OrderForm();
        eventForm.setEvents(eventMap);
        eventForm.setUsers(users);
        map.put("orderForm", eventForm);


        return "event-select";
    }

    @RequestMapping(value = "/showSelectPlace")
    public String selectPlace(@ModelAttribute("orderForm") OrderForm orderForm) {
        return "selectPlace";


    }

    @RequestMapping(value = "/submitOrder")
    public String submitOrder(@ModelAttribute("orderForm") OrderForm orderForm, HttpSession session, Map<String, Object> map) {
        Order order = new Order();
        order.setPlace(orderForm.getPlace());
        Event event = eventService.getEventById(orderForm.getEventId());
        order.setStartTime(event.getStartTime());
        User user = userService.getUserById(orderForm.getUserId());
        order.setUser(user);
        order.setPrice(event.getPrice());
        order.setMovieName(event.getMovieName());
        orderService.addOrder(order);
        event.getFreePlaces().remove(orderForm.getPlace());
        eventService.save(event);
        map.put("orders", Collections.singletonList(order));
        return "order-details";
    }


    @RequestMapping(value = "/addOrder")
    public String addOrder(@ModelAttribute("orderForm") OrderForm orderForm, HttpSession session, Map<String, Object> map) {
        Map<Integer, String> users = new HashMap<>();
        for (User user : userService.getAllUsers()) {
            users.put(user.getUserId(), user.getFirstName() + " " + user.getSecondName());
        }
        orderForm.setUsers(users);
        Event event = eventService.getEventById(orderForm.getEventId());
        Map<Integer, Integer> freePlacesEvents = new HashMap<>();
        for (Integer place : event.getFreePlaces()) {
            freePlacesEvents.put(place, place);
        }

        orderForm.setFreePlaces(freePlacesEvents);
        map.put("orderForm", orderForm);

        return "place-select";
    }

    @RequestMapping(value = "/searchOrder")
    public String searchOrder(@ModelAttribute("searchOrderForm") SearchOrderForm searchOrderForm, HttpSession session, Map<String, Object> map) {

        Order order = orderService.getOrderByNumber(searchOrderForm.getOrderId());
        Collection<Order> orders = new ArrayList<>();
        if (order != null) {
            orders.add(order);
        }
        map.put("orders", orders);
        return "order-details";
    }


    @RequestMapping(value = "/showOrder")
    public String searchOrder(Map<String, Object> map) {
        map.put("searchOrderForm", new SearchOrderForm());
        return "search-order";
    }

    @RequestMapping(value = "/selectDeletionOrder")
    public String showDeleteOrder(Map<String, Object> map) {
        map.put("deleteOrderForm", new DeleteOrderForm());
        return "order-delete";
    }

    @RequestMapping(value = "/deleteOrder")
    public String deleteOrder(@ModelAttribute("deleteOrderForm") DeleteOrderForm deleteOrderForm, Map<String, Object> map) {
        Order order = orderService.getOrderByNumber(deleteOrderForm.getOrderId());
        orderService.removeOrder(order);
        return "redirect:/start.do";
    }


    @RequestMapping(value = "/showOrders")
    public String searchOrders(Map<String, Object> map) {
        map.put("orders", orderService.getAllOrders());
        return "order-details";
    }


    @InitBinder
    protected void initBinder(ServletRequestDataBinder binder) throws Exception {
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @PostConstruct
    public void init() {
        this.dateFormat = new SimpleDateFormat(dateFormatPattern);
    }
}
