package com.lambdaschool.market.controllers;

import com.lambdaschool.market.models.Product;
import com.lambdaschool.market.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController
{
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> listAllProducts()
    {
        List<Product> myProducts = productService.findAll();
        return new ResponseEntity<>(myProducts, HttpStatus.OK);
    }

    @GetMapping(value = "/product/{productid}", produces = "application/json")
    public ResponseEntity<?> getProductById(@PathVariable Long productid)
    {
        Product p = productService.findProductById(productid);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping(value = "/product/name/{productName}", produces = "application/json")
    public ResponseEntity<?> getProductByName(@PathVariable String productName)
    {
        Product p = productService.findByName(productName);
        return new ResponseEntity<>(p, HttpStatus.OK);
    } //not working

    @GetMapping(value = "product/name/like/{productName}", produces = "application/json")
    public ResponseEntity<?> getProductLikeName(@PathVariable String productName)
    {
        List<Product> p = productService.findByNameContaining(productName);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

}
