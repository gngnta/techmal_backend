package backend.repository;

import backend.domain.Category;
import backend.repository.entity.CategoryEntity;
import backend.repository.jpa.CategoryJpa;
import backend.repository.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class CategoryRepository {

    private final CategoryJpa categoryJpa;
    private final CategoryMapper categoryMapper;

    public CategoryRepository(CategoryJpa categoryJpa, CategoryMapper categoryMapper) {
        this.categoryJpa = categoryJpa;
        this.categoryMapper = categoryMapper;
    }

    public Category save(Category category) {
        CategoryEntity entity = categoryMapper.toEntity(category);
        CategoryEntity saved = categoryJpa.save(entity);
        return categoryMapper.toDomain(saved);
    }

    public Optional<Category> findById(Integer id) {
        return categoryJpa.findById(id).map(categoryMapper::toDomain);
    }

    public List<Category> findAll() {
        return categoryJpa.findAll().stream().map(categoryMapper::toDomain).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        categoryJpa.deleteById(id);
    }
}
