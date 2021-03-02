package com.lambdaschool.market.services;

import com.lambdaschool.market.exceptions.ResourceNotFoundException;
import com.lambdaschool.market.models.Location;
import com.lambdaschool.market.models.Product;
import com.lambdaschool.market.models.User;
import com.lambdaschool.market.repository.LocationRepository;
import com.lambdaschool.market.repository.ProductRepository;
import com.lambdaschool.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "locationService")
public class LocationServiceImpl implements LocationService
{
    @Autowired
    LocationRepository locationRepos;

    @Autowired
    ProductRepository productRepos;

    @Autowired
    UserRepository userRepos;

    @Transactional
    @Override
    public Location save(Location location)
    {
//        Location newLocation = new Location();

//        if (location.getLocationid() != 0)
//        {
//            locationRepos.findById(location.getLocationid())
//                    .orElseThrow(() -> new ResourceNotFoundException("Location not found"));
//            newLocation.setLocationid(location.getLocationid());
//        }
//
//        newLocation.setCountry(location.getCountry());
//
//        newLocation.getProducts().clear();
//        for (Product p : location.getProducts())
//        {
//            Product newProduct = productRepos.findById(p.getProductid())
//                    .orElseThrow(() -> new ResourceNotFoundException("Product id " + p.getProductid() + " not found!"));
//
//            newLocation.getProducts().add(new Product(p.getName(), p.getPrice(), p.getDescription(), p.getImageUrl(), p.getQuantity(), User, newLocation));
//        }
        return locationRepos.save(location);
    }
}
