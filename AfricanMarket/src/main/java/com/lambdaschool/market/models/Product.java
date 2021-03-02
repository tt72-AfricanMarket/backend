package com.lambdaschool.market.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productid;

    @Column(nullable = false)
    private String name;

    private double price;
    private String description;
    private String imageUrl;
    private double quantity;

    @ManyToOne
    @JoinColumn(name = "userid",
            nullable = false)
    @JsonIgnoreProperties(value = "products",
            allowSetters = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "locationid",
            nullable = false)
    @JsonIgnoreProperties(value = "products",
            allowSetters = true)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "categoryid",
            nullable = false)
    @JsonIgnoreProperties(value = "products",
            allowSetters = true)
    private Category category;

    public Product() { }

    public Product(String name, double price, String description, String imageUrl, double quantity, User user, Location location, Category category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
        this.user = user;
        this.location = location;
        this.category = category;
    }

    public long getProductid() { return productid; }

    public void setProductid(long productid) { this.productid = productid; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public double getQuantity() { return quantity; }

    public void setQuantity(double quantity) { this.quantity = quantity; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Location getLocation() { return location; }

    public void setLocation(Location location) { this.location = location; }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }
}
