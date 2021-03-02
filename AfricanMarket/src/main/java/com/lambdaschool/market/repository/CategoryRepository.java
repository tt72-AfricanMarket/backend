package com.lambdaschool.market.repository;

import com.lambdaschool.market.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>
{
}
