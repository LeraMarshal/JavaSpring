package de.marshal.javaspring.payment.gateway;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlApp {
    public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Order order = context.getBean(Order.class);
		PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);

        System.out.println(order);
		System.out.println(paymentGateway);
    }
}
