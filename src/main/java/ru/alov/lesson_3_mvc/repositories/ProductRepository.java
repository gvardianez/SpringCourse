package ru.alov.lesson_3_mvc.repositories;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository  {

  private SessionFactory sessionFactory;

    public ProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
