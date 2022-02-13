package ru.alov.lesson_3_mvc.repositories;

import ru.alov.lesson_3_mvc.models.IProduct;

import java.util.List;

public interface Repository {
    IProduct getProduct(int id);

    List<IProduct> getAllProducts();

    void update(IProduct product, int id);

    void delete(int id);

    void addProduct(IProduct product);
}
