package com.platzi.platzimarket.persistence.crud;

import com.platzi.platzimarket.persistence.entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCRUDRepository extends CrudRepository<Producto, Integer> {

  List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

  //se puede hacer una consulta nativa
  @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
  List<Producto> getProductosById(int idCategoria);

  //Usando Optional
  Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
