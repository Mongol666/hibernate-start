package com.gpisarev.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "printed_products")
public class PrintedProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "type_id")
    private Type type;

    public PrintedProduct withName(String name) {
        setName(name);
        return this;
    }

    public PrintedProduct withAuthor(Author author) {
        setAuthor(author);
        return this;
    }

    public PrintedProduct withType(Type type) {
        setType(type);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrintedProduct product = (PrintedProduct) o;
        return id == product.id && author == product.author && type == product.type && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, type);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Название: " + name + ", Автор: " + author + ", Тип: " + type;
    }
}
