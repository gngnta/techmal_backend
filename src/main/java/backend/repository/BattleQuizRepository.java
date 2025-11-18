package backend.repository;

import backend.domain.BattleQuiz;
import backend.repository.entity.BattleQuizEntity;
import backend.repository.jpa.BattleQuizJpa;
import backend.repository.mapper.BattleQuizMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class BattleQuizRepository {

    private final BattleQuizJpa battleQuizJpa;
    private final BattleQuizMapper battleQuizMapper;

    public BattleQuizRepository(BattleQuizJpa battleQuizJpa, BattleQuizMapper battleQuizMapper) {
        this.battleQuizJpa = battleQuizJpa;
        this.battleQuizMapper = battleQuizMapper;
    }

    public BattleQuiz save(BattleQuiz battleQuiz) {
        BattleQuizEntity entity = battleQuizMapper.toEntity(battleQuiz);
        BattleQuizEntity saved = battleQuizJpa.save(entity);
        return battleQuizMapper.toDomain(saved);
    }

    public Optional<BattleQuiz> findById(Integer id) {
        return battleQuizJpa.findById(id).map(battleQuizMapper::toDomain);
    }

    public List<BattleQuiz> findAll() {
        return battleQuizJpa.findAll().stream().map(battleQuizMapper::toDomain).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        battleQuizJpa.deleteById(id);
    }
}
