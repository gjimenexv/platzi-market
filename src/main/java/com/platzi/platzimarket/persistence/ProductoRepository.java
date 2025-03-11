package com.platzi.platzimarket.persistence;

import com.platzi.platzimarket.domain.Product;
import com.platzi.platzimarket.domain.repository.ProductRepository;
import com.platzi.platzimarket.persistence.crud.ProductoCRUDRepository;
import com.platzi.platzimarket.persistence.entities.Producto;
import com.platzi.platzimarket.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository  implements ProductRepository {
  private ProductoCRUDRepository productoCRUDRepository;
  private ProductMapper mapper;

  public List<Product> getAll() {
    List<Producto> productos = (List<Producto>) productoCRUDRepository.findAll();
    return mapper.toProducts(productos);
  }

  @Override
  public Optional<List<Product>> getByCategory(int categoryId) {
    List<Producto> productos = productoCRUDRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
    return Optional.of(mapper.toProducts((productos)));
  }

  @Override
  public Optional<List<Product>> getScarseProducts(int quantity) {
    Optional<List<Producto>> productos = productoCRUDRepository.findByCantidadStockLessThanAndEstado(quantity, true);
    // This is a lambda expression that is equivalent to the following code: productos.map(new Function<List<Producto>, List<Product>>() { @Override public List<Product> apply(List<Producto> prods) { return mapper.toProducts(prods); } });
    return productos.map(prods -> mapper.toProducts(prods));
    // in order words, takes the elements of the list and maps them to the Product domain model
  }

  public  List<Producto> getByCategoria(int idCategoria){
    return productoCRUDRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
  }

  public Optional<List<Producto>> getEscasos(int cantidadStock){
    return productoCRUDRepository.findByCantidadStockLessThanAndEstado(cantidadStock, true);
  }

  public Optional<Product> getProduct(int productId){
      return productoCRUDRepository.findById(productId).map(producto -> mapper.toProduct(producto));
  }

  @Override
  public Product save(Product product){
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCRUDRepository.save(producto));
    }
  @Override
  public void delete(int idProducto){
      productoCRUDRepository.deleteById(idProducto);
  }
}
