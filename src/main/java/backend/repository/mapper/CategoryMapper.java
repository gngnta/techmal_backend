package backend.repository.mapper;

import backend.domain.Category;
import backend.repository.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryEntity toEntity(Category category);

    Category toDomain(CategoryEntity categoryEntity);

    List<CategoryEntity> toEntities(List<Category> categories);

    List<Category> toDomains(List<CategoryEntity> categoryEntities);
}
