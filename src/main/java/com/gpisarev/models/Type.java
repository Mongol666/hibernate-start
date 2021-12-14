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
@Table(name = "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(table = "types", name = "id")
    private int id;

    @Column(table = "types", name = "name")
    private String name;

    public Type withName(String name) {
        setName(name);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type1 = (Type) o;
        return id == type1.id && name.equals(type1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return name;
    }
}
