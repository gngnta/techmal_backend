package backend.repository.jpa;

import backend.repository.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpa extends JpaRepository<CategoryEntity, Integer> {
}
