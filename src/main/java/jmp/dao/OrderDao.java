package jmp.dao;

import jmp.domain.Order;

public interface OrderDao extends DomainOjectDao<Order> {

    Order getOrderByNumber(String number);
}
