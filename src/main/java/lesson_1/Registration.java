package lesson_1;

import lesson_1.doctors.Doctor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Registration {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Registry registry = context.getBean("registry", Registry.class);
        Client client = context.getBean("client", Client.class);
        Client clientOne = context.getBean("clientOne",Client.class);
        Client clientTwo = context.getBean("clientTwo",Client.class);
        Client clientThree = context.getBean("clientThree",Client.class);
        System.out.println(registry.getDirection(client));
        System.out.println(registry.getDirection(clientOne));
        System.out.println(registry.getDirection(clientTwo));
        System.out.println(registry.getDirection(clientThree));
    }

}
