package backend.repository.jpa;

import backend.repository.entity.ChoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoiceJpa extends JpaRepository<ChoiceEntity, Integer> {
}
