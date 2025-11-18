package backend.repository;

import backend.domain.Battle;
import backend.repository.entity.BattleEntity;
import backend.repository.jpa.BattleJpa;
import backend.repository.mapper.BattleMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class BattleRepository {

    private final BattleJpa battleJpa;
    private final BattleMapper battleMapper;

    public BattleRepository(BattleJpa battleJpa, BattleMapper battleMapper) {
        this.battleJpa = battleJpa;
        this.battleMapper = battleMapper;
    }

    public Battle save(Battle battle) {
        BattleEntity entity = battleMapper.toEntity(battle);
        BattleEntity saved = battleJpa.save(entity);
        return battleMapper.toDomain(saved);
    }

    public Optional<Battle> findById(Integer id) {
        return battleJpa.findById(id).map(battleMapper::toDomain);
    }

    public List<Battle> findAll() {
        return battleJpa.findAll().stream().map(battleMapper::toDomain).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        battleJpa.deleteById(id);
    }
}
