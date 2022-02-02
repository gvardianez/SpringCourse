package lesson_1_manual;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CartApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Cart cart = context.getBean("cart", Cart.class);
        ConsoleCartHandler.cartHandler(cart);
    }
}
