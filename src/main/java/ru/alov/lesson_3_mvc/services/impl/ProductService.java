package ru.alov.lesson_3_mvc.services.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import ru.alov.lesson_3_mvc.entities.Product;
import ru.alov.lesson_3_mvc.repositories.ProductRepository;
import ru.alov.lesson_3_mvc.services.IProductService;

import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        SessionFactory sessionFactory = productRepository.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            List<Product> productList = session.createNamedQuery("Product.findAll", Product.class).getResultList();
            session.getTransaction().commit();
            return productList;
        }
    }

    @Override
    public List<Product> getProductsByCategory(Long id) {
        SessionFactory sessionFactory = productRepository.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            List<Product> productList = session.createNamedQuery("Product.findProductsByCategoryId", Product.class).setParameter("id", id).getResultList();
            session.getTransaction().commit();
            return productList;
        }
    }


    @Override
    public void update(Product product, Long id) {
        SessionFactory sessionFactory = productRepository.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            session.merge(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Long id) {
        SessionFactory sessionFactory = productRepository.getSessionFactory();
        Product product = getProduct(id);
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public Product getProduct(Long id) {
        SessionFactory sessionFactory = productRepository.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            Product product = session.find(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public void addProduct(Product product) {
        SessionFactory sessionFactory = productRepository.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
//            product.getCategory()
            session.persist(product);
            session.getTransaction().commit();
        }
    }

    @PreDestroy
    public void preDestroy() {
        productRepository.getSessionFactory().close();
    }

}
