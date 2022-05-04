package com.upc.homemade.securityservice.services;

import com.upc.homemade.securityservice.entities.Homie;

public interface HomieService extends CrudService<Homie, Long>{
    Homie getHomieById(Long aLong);
}
