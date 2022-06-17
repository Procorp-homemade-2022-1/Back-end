package com.upc.homemade.businessservice.services;

import com.upc.homemade.businessservice.entities.Menu;

public interface MenuService extends CrudService<Menu, Long>{
    Menu getMenuById(Long menuId);
}
