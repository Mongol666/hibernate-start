package com.gpisarev.singleton;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class EntityManagerHelper {
    private final SessionFactory sessionFactory;
    private EntityManagerHelper() {
        Configuration configuration = new Configuration().configure();
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
