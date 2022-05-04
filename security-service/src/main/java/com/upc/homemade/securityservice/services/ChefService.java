package com.upc.homemade.securityservice.services;

import com.upc.homemade.securityservice.entities.Chef;

public interface ChefService extends  CrudService<Chef, Long>{
    Chef getChefById(Long aLong);
}
