package com.lambdaschool.market.controllers;

import com.lambdaschool.market.models.Category;
import com.lambdaschool.market.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> listAllCategories()
    {
        List<Category> myCategories = categoryService.findAll();
        return new ResponseEntity<>(myCategories, HttpStatus.OK);
    }
}
