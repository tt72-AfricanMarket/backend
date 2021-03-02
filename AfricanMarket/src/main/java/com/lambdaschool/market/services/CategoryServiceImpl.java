package com.lambdaschool.market.services;


import com.lambdaschool.market.models.Category;
import com.lambdaschool.market.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    CategoryRepository categoryRepos;

    @Override
    public List<Category> findAll()
    {
        List<Category> myList = new ArrayList<>();

        categoryRepos.findAll()
                .iterator()
                .forEachRemaining(myList::add);
        return myList;
    }

    @Transactional
    @Override
    public Category save(Category category)
    {
        return categoryRepos.save(category);
    }
}
