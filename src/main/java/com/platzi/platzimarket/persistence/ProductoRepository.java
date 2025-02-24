package com.platzi.platzimarket.persistence;

import com.platzi.platzimarket.persistence.crud.ProductoCRUDRepository;
import com.platzi.platzimarket.persistence.entities.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
  private ProductoCRUDRepository productoCRUDRepository;

  public List<Producto> getAll() {
    return (List<Producto>) productoCRUDRepository.findAll();
  }

  public  List<Producto> getByCategoria(int idCategoria){
    return productoCRUDRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
  }

  public Optional<List<Producto>> getEscasos(int cantidadStock){
    return productoCRUDRepository.findByCantidadStockLessThanAndEstado(cantidadStock, true);
  }
}
