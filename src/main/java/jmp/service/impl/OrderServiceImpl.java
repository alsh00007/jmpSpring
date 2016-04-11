package jmp.service.impl;

import jmp.dao.OrderDao;
import jmp.domain.Order;
import jmp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public Order getOrderByNumber(String number) {
        return orderDao.getOrderByNumber(number);
    }

    @Override
    public void removeOrder(Order order) {
        orderDao.remove(order);
    }

    @Override
    public Order addOrder(Order order) {
        return orderDao.save(order);
    }

    @Override
    public Collection<Order> getAllOrders() {
        return orderDao.getAll();
    }
}
