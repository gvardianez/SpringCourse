package ru.alov.lesson_3_mvc.services;

import ru.alov.lesson_3_mvc.entities.Category;
import ru.alov.lesson_3_mvc.entities.Client;

import ru.alov.lesson_3_mvc.entities.Order;
import ru.alov.lesson_3_mvc.entities.Product;

import java.util.List;

public interface IClientService {

    Client getClient(Long id);

    List<Order> getClientOrders(Long id);

    List<Product> getClientProducts(Long id);

}
