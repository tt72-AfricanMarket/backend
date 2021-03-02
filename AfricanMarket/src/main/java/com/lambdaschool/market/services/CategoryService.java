package com.lambdaschool.market.services;

import com.lambdaschool.market.models.Category;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface CategoryService
{
    List <Category> findAll();

    Category save(Category category);
}
