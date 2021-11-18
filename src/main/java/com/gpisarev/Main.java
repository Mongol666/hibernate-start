package com.gpisarev;

import com.gpisarev.models.Author;
import com.gpisarev.models.PrintedProduct;
import com.gpisarev.models.Type;
import com.gpisarev.singleton.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerHelper.getInstance().getEntityManager();

        EntityTransaction transaction1 = entityManager.getTransaction();
        transaction1.begin();

//        Author author2 = new Author().withName("Александр Пушкин");
//        entityManager.persist(author2);

//        TypedQuery<Author> query = entityManager.createQuery("from Author where name = 'Александр Пушкин'", Author.class);
//        Author singleResult = query.getSingleResult();
//        System.out.println(singleResult);

//        transaction1.commit();

        PrintedProduct product = entityManager.find(PrintedProduct.class, 2);
        System.out.println(product);

        transaction1.commit();
//        Author author = new Author().withName("Александр Пушкин");
//        entityManager.persist(author);
//
//        Type type = new Type().withType("Книга");
//        entityManager.persist(type);
//
//        PrintedProduct product = new PrintedProduct()
//                .withName("Капитанская дочка")
//                .withAuthor(author)
//                .withType(type);
//        entityManager.persist(product);
//
//        transaction1.commit();

        //EntityTransaction transaction2 = entityManager.getTransaction();
        //transaction2.begin();
//
        //PrintedProduct product1 = entityManager.find(PrintedProduct.class, 1);
        //System.out.println(product1);
//
        //transaction2.commit();

        entityManager.close();
        //Session session = sessionFactory.openSession();
        //Transaction transaction = session.beginTransaction();
        //PrintedProduct product = session.find(PrintedProduct.class, 1);
        //System.out.println(product);
        //transaction.commit();
        //session.close();
    }
}
