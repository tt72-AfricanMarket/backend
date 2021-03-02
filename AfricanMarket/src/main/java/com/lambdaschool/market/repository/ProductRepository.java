package com.lambdaschool.market.repository;

import com.lambdaschool.market.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long>
{

    Product findByName(String productname);

    List<Product> findByNameContainingIgnoreCase(String name);

}
