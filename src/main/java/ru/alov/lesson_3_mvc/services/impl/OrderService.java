package ru.alov.lesson_3_mvc.services.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.alov.lesson_3_mvc.entities.Client;
import ru.alov.lesson_3_mvc.entities.Order;
import ru.alov.lesson_3_mvc.repositories.OrderRepository;
import ru.alov.lesson_3_mvc.services.IOrderService;

public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrder(Long id) {
        SessionFactory sessionFactory = orderRepository.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            Order order = session.find(Order.class, id);
            session.getTransaction().commit();
            return order;
        }
    }


}
