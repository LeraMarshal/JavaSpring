package de.marshal.javaspring.payment.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationAppConfig {
    @Bean
    public Order order() {
        Order order = new Order();
        order.setItem("Order-1");
        order.setPrice(100);
        return order;
    }

    @Bean
    public PaymentGateway paymentGateway(Order order) {
        PaymentGateway paymentGateway = new PaymentGateway();
        paymentGateway.setOrder(order);
        return paymentGateway;
    }
}