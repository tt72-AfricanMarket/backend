package com.lambdaschool.market.services;

import com.lambdaschool.market.models.Product;

import java.util.List;

public interface ProductService
{
    List <Product> findAll();

    List <Product> findByNameContaining(String productname);

    Product findProductById(long id);

    Product findByName(String productname);

    Product save(Product product);
}
