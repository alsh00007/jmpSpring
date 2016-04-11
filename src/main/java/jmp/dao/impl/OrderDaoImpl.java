package jmp.dao.impl;

import jmp.dao.OrderDao;
import jmp.domain.Order;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class OrderDaoImpl extends DomainObjectDaoImpl<Order> implements OrderDao {

    private static final HashSet<Order> STORAGE = new HashSet<>();


    private static class NumberGenerator {
        private int id = 0;

        String calculateNextNumber() {
            return StringUtils.leftPad(String.valueOf(++id), 7, "0");
        }
    }

    private NumberGenerator numberGenerator = new NumberGenerator();

    public OrderDaoImpl() {
        super(STORAGE);
    }


    @Override
    public Order save(Order order) {
        order.setNumber(numberGenerator.calculateNextNumber());
        super.save(order);
        return order;
    }

    @Override
    public Order getOrderByNumber(String number) {
        for (Order order : STORAGE) {
            if (order.getNumber().equals(number)) {
                return order;
            }
        }
        return null;
    }
}

