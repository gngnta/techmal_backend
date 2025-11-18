package backend.repository.jpa;

import backend.repository.entity.BattleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BattleJpa extends JpaRepository<BattleEntity, Integer> {
}
