package com.platzi.platzimarket.persistence;

import com.platzi.platzimarket.persistence.crud.ProductoCRUDRepository;
import com.platzi.platzimarket.persistence.entities.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
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

    public Optional<Producto> getProducto(int idProducto){
        return productoCRUDRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCRUDRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCRUDRepository.deleteById(idProducto);
    }
}
