package com.lambdaschool.market.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long locationid;

    private String country;

    @OneToMany(mappedBy = "location",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "location",
            allowSetters = true)
    private List<Product> products = new ArrayList<>();

    public Location() { }

    public Location(String country) {
        this.country = country;
    }

    public long getLocationid() { return locationid; }

    public void setLocationid(long locationid) { this.locationid = locationid; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public List<Product> getProducts() { return products; }

    public void setProducts(List<Product> products) { this.products = products; }
}
