package com.lambdaschool.market.services;


import com.lambdaschool.market.models.Category;
import com.lambdaschool.market.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    CategoryRepository categoryRepos;

    @Transactional
    @Override
    public Category save(Category category)
    {
        return categoryRepos.save(category);
    }
}
