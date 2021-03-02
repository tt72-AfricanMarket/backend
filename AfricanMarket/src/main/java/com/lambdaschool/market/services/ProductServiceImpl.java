package com.lambdaschool.market.services;

import com.lambdaschool.market.exceptions.ResourceNotFoundException;
import com.lambdaschool.market.models.Product;
import com.lambdaschool.market.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.oauth2.client.resource.OAuth2AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "productService")
public class ProductServiceImpl implements ProductService
{

    @Autowired
    private ProductRepository productRepos;

    @Autowired
    public HelperFunctions helperFunctions;

    @Override
    public List<Product> findAll()
    {
        List<Product> myList = new ArrayList<>();

        productRepos.findAll()
                .iterator()
                .forEachRemaining(myList::add);
        return myList;
    }

    @Override
    public List<Product> findByNameContaining(String productname)
    {
        return productRepos.findByNameContainingIgnoreCase(productname.toLowerCase());
    }

    @Override
    public Product findProductById(long id) throws ResourceNotFoundException
    {
        return productRepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product id " + id + " not found"));
    }

    @Override
    public Product findByName(String productname)
    {
        Product pp = productRepos.findByName(productname.toLowerCase());
        if (pp == null)
        {
            throw new ResourceNotFoundException("Product name " + productname + " not found!");
        }
        return pp;
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        productRepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product id " + id + " not found!"));
        productRepos.deleteById(id);
    }



    @Transactional
    @Override
    public Product save(Product product)
    {
        Product newProduct = new Product();

        if (product.getProductid() != 0)
        {
            productRepos.findById(product.getProductid())
                    .orElseThrow(() -> new ResourceNotFoundException("Product id " + product.getProductid() + " not found!"));
            newProduct.setProductid(product.getProductid());
        }

        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setImageUrl(product.getImageUrl());
        newProduct.setDescription(product.getDescription());
        newProduct.setQuantity(product.getQuantity());
        newProduct.setLocation(product.getLocation());
        newProduct.setCategory(product.getCategory());
        newProduct.setUser(product.getUser());

        return productRepos.save(newProduct);
    }

    @Transactional
    @Override
    public Product update(Product product, long id)
    {
        Product currentProduct = findProductById(id);

        if (helperFunctions.isAuthorizedToMakeChange(currentProduct.getName())) {
            if (product.getName() != null) {
                currentProduct.setName(product.getName());
            }
            if (product.getPrice() != 0) {
                currentProduct.setPrice(product.getPrice());
            }
            if (product.getImageUrl() != null) {
                currentProduct.setImageUrl(product.getImageUrl());
            }
            if (product.getDescription() != null) {
                currentProduct.setDescription(product.getDescription());
            }
            if (product.getCategory() != null) {
                currentProduct.setCategory(product.getCategory());
            }
            if (product.getLocation() != null) {
                currentProduct.setLocation(product.getLocation());
            }
            if (product.getUser() != null) {
                currentProduct.setUser(product.getUser());
            }

            return productRepos.save(currentProduct);
        } else
        {
            throw new OAuth2AccessDeniedException();
        }
    }
}
