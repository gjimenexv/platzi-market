package com.platzi.platzimarket.persistence.mapper;


import com.platzi.platzimarket.domain.Category;
import com.platzi.platzimarket.persistence.entities.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
  @Mappings({
    @Mapping(source = "idCategoria", target = "categoryId"),
    @Mapping(source = "descripcion", target = "category"),
    @Mapping(source = "estado", target = "active")
  })
  Category toCategory(Categoria categoria);

  @InheritInverseConfiguration
  @Mapping(target = "products", ignore = true)
  Categoria toCategoria(Category category);
}
