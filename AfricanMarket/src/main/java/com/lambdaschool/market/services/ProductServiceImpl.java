package com.lambdaschool.market.services;

import com.lambdaschool.market.exceptions.ResourceNotFoundException;
import com.lambdaschool.market.models.Product;
import com.lambdaschool.market.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
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
    public Product save(Product product)
    {
        return productRepos.save(product);
    }
}
