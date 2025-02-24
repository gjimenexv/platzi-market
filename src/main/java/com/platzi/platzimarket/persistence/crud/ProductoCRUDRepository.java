package com.platzi.platzimarket.persistence.crud;

import com.platzi.platzimarket.persistence.entities.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCRUDRepository extends CrudRepository<Producto, Integer> {

}
