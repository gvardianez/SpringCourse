package ru.alov.lesson_3_mvc.services;

import ru.alov.lesson_3_mvc.entities.Category;
import ru.alov.lesson_3_mvc.entities.Product;

import java.util.List;

public interface ICategoryService {

    List<Category> getCategoriesList();

    Category getCategory(Long id);

    List<Product> getProductsByCategory(Long id);

}
