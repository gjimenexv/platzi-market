package com.platzi.platzimarket.persistence;

import com.platzi.platzimarket.persistence.crud.ProductoCRUDRepository;
import com.platzi.platzimarket.persistence.entities.Producto;

import java.util.List;

public class ProductoRepository {
  private ProductoCRUDRepository productoCRUDRepository;

  public List<Producto> getAll() {
    return (List<Producto>) productoCRUDRepository.findAll();
  }
}
