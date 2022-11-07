package com.educaweb.projetow.model.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="tb_category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    /*@JsonIgnore= faz exibir apenas a categoria sem o produto que ela esta*/
    /*e assim faz aparecer os produtos com suas categorias na classe Product*/
    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products= new HashSet<>();
    /*Uma categoria esta em vários produtos*/


    public Category() {}
    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Set<Product> getProducts() {return products;}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (!id.equals(category.id)) return false;
        return name != null ? name.equals(category.name) : category.name == null;
    }




}
