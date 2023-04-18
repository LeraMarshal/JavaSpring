package de.marshal.javaspring.payment.gateway;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AnnotationAppConfig.class);

        Order order = context.getBean(Order.class);
        PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);

        System.out.println(order);
        System.out.println(paymentGateway);
    }
}
