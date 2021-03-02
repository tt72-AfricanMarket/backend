package com.lambdaschool.market.repository;

import com.lambdaschool.market.models.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long>
{
}
