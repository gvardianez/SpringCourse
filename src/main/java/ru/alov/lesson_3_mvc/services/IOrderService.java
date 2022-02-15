package ru.alov.lesson_3_mvc.services;

import ru.alov.lesson_3_mvc.entities.Order;

public interface IOrderService {

    Order getOrder(Long id);

}
