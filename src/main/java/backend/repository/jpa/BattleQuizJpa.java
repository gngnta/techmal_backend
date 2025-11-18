package backend.repository.jpa;

import backend.repository.entity.BattleQuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BattleQuizJpa extends JpaRepository<BattleQuizEntity, Integer> {
}
