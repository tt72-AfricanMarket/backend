package com.lambdaschool.market.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryid;

    private String categoryname;

    @OneToMany(mappedBy = "category",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "category",
            allowSetters = true)
    private List<Product> products = new ArrayList<>();

    public Category() { }

    public Category(String categoryname) {
        this.categoryname = categoryname;
    }

    public long getCategoryid() { return categoryid; }

    public void setCategoryid(long categoryid) { this.categoryid = categoryid; }

    public String getCategoryname() { return categoryname; }

    public void setCategoryname(String categoryname) { this.categoryname = categoryname; }

    public List<Product> getProducts() { return products; }

    public void setProducts(List<Product> products) { this.products = products; }
}
