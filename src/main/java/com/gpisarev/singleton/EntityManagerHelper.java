package com.gpisarev.singleton;

import com.gpisarev.models.Author;
import com.gpisarev.models.PrintedProduct;
import com.gpisarev.models.Type;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class EntityManagerHelper {
    private final SessionFactory sessionFactory;
    private EntityManagerHelper() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(PrintedProduct.class);
        configuration.addAnnotatedClass(Type.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    private static class EntityManagerHelperHolder {
        private static final EntityManagerHelper holderEntityManagerHelper = new EntityManagerHelper();
    }

    public static EntityManagerHelper getInstance() {
        return EntityManagerHelper.EntityManagerHelperHolder.holderEntityManagerHelper;
    }

    public EntityManager getEntityManager() {
        return sessionFactory.createEntityManager();
    }
}
