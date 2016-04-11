package jmp.service;

import jmp.domain.Order;

import java.util.Collection;

public interface OrderService {

    Order getOrderByNumber(String number);

    void removeOrder(Order order);

    Order addOrder(Order order);

    Collection<Order> getAllOrders();
}
