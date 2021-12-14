package com.gpisarev;

import com.gpisarev.models.Author;
import com.gpisarev.models.PrintedProduct;
import com.gpisarev.models.Type;
import com.gpisarev.singleton.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerHelper.getInstance().getEntityManager();

        EntityTransaction transaction1 = entityManager.getTransaction();
        transaction1.begin();

        // На момент этой строки в таблицах ещё ничего нет

        // создание типов
        //Type book = new Type()
        //        .withName("Книга");
        //Type magazine = new Type()
        //        .withName("Журнал");

        // создание авторов
        //Author pushkin = new Author()
        //        .withName("Александр Сергеевич Пушкин");
        //Author lermontov = new Author()
        //        .withName("Михаил Юрьевич Лермонтов");

        // сохранение в таблицу PrintedProducts, Authors, Types
        //PrintedProduct firstPushkinBook = new PrintedProduct()
        //        .withAuthor(pushkin)
        //        .withName("Руслан и Людмила")
        //        .withType(book);
        //entityManager.persist(firstPushkinBook);
//
        //PrintedProduct firstLermontovMagazine = new PrintedProduct()
        //        .withAuthor(lermontov)
        //        .withName("Какой-то журнал")
        //        .withType(magazine);
        //entityManager.persist(firstLermontovMagazine);

        // select через TypedQuery
        //TypedQuery<PrintedProduct> allPrintedProductsQuery = entityManager.createQuery("from PrintedProduct ", PrintedProduct.class);
        //allPrintedProductsQuery.getResultList().forEach(System.out::println);

        // select через CriteriaBuilder
        //CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        //CriteriaQuery<PrintedProduct> query = criteriaBuilder.createQuery(PrintedProduct.class);
        //query.from(PrintedProduct.class);
        //entityManager.createQuery(query).getResultList().forEach(System.out::println);

        // update через TypedQuery
        //PrintedProduct firstLermontovMagazine = entityManager.find(PrintedProduct.class, 8);
        //firstLermontovMagazine.setName("Записки Лермотнова");
        //entityManager.merge(firstLermontovMagazine);

        // update через CriteriaBuilder и поиск автора через JPQL
        //CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        //CriteriaUpdate<PrintedProduct> query = criteriaBuilder.createCriteriaUpdate(PrintedProduct.class);
        //Root<PrintedProduct> root = query.from(PrintedProduct.class);
        //query.set("name", "Записки Лермонтова");
        //Author lermontov = entityManager.createQuery("from Author where name = 'Михаил Юрьевич Лермонтов' ", Author.class).getSingleResult();
        //query.where(criteriaBuilder.equal(root.get("author"), lermontov));
        //entityManager.createQuery(query).executeUpdate();

        // delete через TypedQuery
        //TypedQuery<PrintedProduct> query = entityManager.createQuery("from PrintedProduct where name = :name", PrintedProduct.class);
        //query.setParameter("name", "Записки Лермонтова");
        //PrintedProduct firstLermontovMagazine = query.getSingleResult();
        //entityManager.remove(firstLermontovMagazine);

        // delete через CriteriaBuilder
        //CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        //CriteriaDelete<PrintedProduct> query = criteriaBuilder.createCriteriaDelete(PrintedProduct.class);
        //Root<PrintedProduct> root = query.from(PrintedProduct.class);
        //Type magazine = entityManager.createQuery("from Type where name = 'Журнал'", Type.class).getSingleResult();
        //query.where(criteriaBuilder.equal(root.get("type"), magazine));
        //entityManager.createQuery(query).executeUpdate();

        // select типов печатного изделия через таблицу печатного изделия
        //TypedQuery<Type> query = entityManager.createQuery("select pp.type from PrintedProduct pp ", Type.class);
        //query.getResultList().forEach(System.out::println);

        // select печатной продукции через join fetch
        //TypedQuery<PrintedProduct> query = entityManager.createQuery("select pp from PrintedProduct pp join fetch pp.type", PrintedProduct.class);
        //query.getResultList().forEach(System.out::println);



        transaction1.commit();
        entityManager.close();

        //Session session = sessionFactory.openSession();
        //Transaction transaction = session.beginTransaction();
        //PrintedProduct product = session.find(PrintedProduct.class, 1);
        //System.out.println(product);
        //transaction.commit();
        //session.close();
    }
}
