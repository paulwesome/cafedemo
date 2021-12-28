package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.integration.annotation.Gateway;

public class CafeDemo {

    public static void main(String[] args) {
        AbstractApplicationContext context = null;
       if(args.length > 0) {
            context = new FileSystemXmlApplicationContext(args);
        }
        else {
            context = new ClassPathXmlApplicationContext("cafeDemo.xml", CafeDemo.class);
        }
        Cafe cafe = (Cafe) context.getBean("cafe");
        for (int i = 1; i <= 100; i++) {
            Order order = new Order(i);
            order.addItem(DrinkType.LATTE, 2, false);
            order.addItem(DrinkType.AMERICANO, 3, true);
            cafe.placeOrder(order);
        }
    }
	public interface Cafe {

    @Gateway(requestChannel="orders")
    void placeOrder(Order order);
	}
 }