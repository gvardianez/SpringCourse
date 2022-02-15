package ru.alov.lesson_3_mvc.services.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import ru.alov.lesson_3_mvc.entities.Client;

import ru.alov.lesson_3_mvc.entities.Order;
import ru.alov.lesson_3_mvc.entities.Product;
import ru.alov.lesson_3_mvc.repositories.ClientRepository;
import ru.alov.lesson_3_mvc.services.IClientService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getClient(Long id) {
        SessionFactory sessionFactory = clientRepository.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            Client client = session.find(Client.class, id);
            session.getTransaction().commit();
            return client;
        }
    }

    @Override
    public List<Order> getClientOrders(Long id) {
        SessionFactory sessionFactory = clientRepository.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            Client client = session.get(Client.class, id);
            List<Order> orderList = client.getOrderList();
            orderList.isEmpty();
            session.getTransaction().commit();
            return orderList;
        }
    }

    @Override
    public List<Product> getClientProducts(Long id) {
        SessionFactory sessionFactory = clientRepository.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            Client client = session.get(Client.class, id);
            List<Order> orderList = client.getOrderList();
            List<Product> productList = orderList.stream().map(Order::getProduct).collect(Collectors.toList());
            session.getTransaction().commit();
            return productList;
        }
    }


}
