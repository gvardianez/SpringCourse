package ru.alov.lesson_3_mvc.services.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import ru.alov.lesson_3_mvc.entities.Category;
import ru.alov.lesson_3_mvc.entities.Product;
import ru.alov.lesson_3_mvc.repositories.CategoryRepository;
import ru.alov.lesson_3_mvc.services.ICategoryService;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategoriesList() {
        SessionFactory sessionFactory = categoryRepository.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            List<Category> categories = session.createNamedQuery("Category.findAll", Category.class).getResultList();
            session.getTransaction().commit();
            return categories;
        }
    }

    @Override
    public Category getCategory(Long id) {
        SessionFactory sessionFactory = categoryRepository.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            Category category = session.find(Category.class, id);
            session.getTransaction().commit();
            return category;
        }
    }

    @Override
    public List<Product> getProductsByCategory(Long id) {
        SessionFactory sessionFactory = categoryRepository.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            Category category = session.get(Category.class, id);
            List<Product> productList = category.getProductList();
            productList.isEmpty();
            session.getTransaction().commit();
            return productList;
        }
    }

}
