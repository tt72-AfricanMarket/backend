package com.lambdaschool.market.controllers;

import com.lambdaschool.market.models.Product;
import com.lambdaschool.market.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping(value = "/product", consumes = "application/json")
    public ResponseEntity<?> addNewProduct(
            @Valid
            @RequestBody
                Product newproduct) throws URISyntaxException
    {
        newproduct.setProductid(0);
        newproduct = productService.save(newproduct);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{productid}")
                .buildAndExpand(newproduct.getProductid())
                .toUri();
        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/product/{productid}", consumes = "application/json")
    public ResponseEntity<?> updateFullProduct(
            @Valid
            @RequestBody Product updateProduct,
            @PathVariable long productid)
    {
        updateProduct.setProductid(productid);
        productService.save(updateProduct);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/product/{id}", consumes = "application/json")
    public ResponseEntity<?> updateProduct(
            @RequestBody Product updateProduct,
            @PathVariable long id)
    {
        productService.update(updateProduct, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<?> deleteProductById(
            @PathVariable long id
    )
    {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
