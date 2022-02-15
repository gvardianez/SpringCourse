package ru.alov.lesson_3_mvc.services;

import ru.alov.lesson_3_mvc.entities.Client;
import ru.alov.lesson_3_mvc.entities.Product;

import java.util.List;

public interface IProductService {
    Product getProduct(Long id);

    List<Product> getAllProducts();

    void update(Product product, Long id);

    void delete(Long id);

    void addProduct(Product product);

    List<Product> getProductsByCategory(Long id);

//    List<Client> getClientsByProductId(Long id);
}
