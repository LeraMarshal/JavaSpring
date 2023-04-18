package de.marshal.javaspring.payment.gateway;

import org.springframework.beans.factory.annotation.Autowired;

public class PaymentGateway {
    @Autowired
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "ordering " + this.order.getItem() + " | price: " + this.order.getPrice();
    }
}
