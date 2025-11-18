package backend.repository.jpa;

import backend.repository.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizJpa extends JpaRepository<QuizEntity, Integer> {
}
