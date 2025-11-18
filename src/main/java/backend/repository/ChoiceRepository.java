package backend.repository;

import backend.domain.Choice;
import backend.repository.entity.ChoiceEntity;
import backend.repository.jpa.ChoiceJpa;
import backend.repository.mapper.ChoiceMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ChoiceRepository {

    private final ChoiceJpa choiceJpa;
    private final ChoiceMapper choiceMapper;

    public ChoiceRepository(ChoiceJpa choiceJpa, ChoiceMapper choiceMapper) {
        this.choiceJpa = choiceJpa;
        this.choiceMapper = choiceMapper;
    }

    public Choice save(Choice choice) {
        ChoiceEntity entity = choiceMapper.toEntity(choice);
        ChoiceEntity saved = choiceJpa.save(entity);
        return choiceMapper.toDomain(saved);
    }

    public Optional<Choice> findById(Integer id) {
        return choiceJpa.findById(id).map(choiceMapper::toDomain);
    }

    public List<Choice> findAll() {
        return choiceJpa.findAll().stream().map(choiceMapper::toDomain).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        choiceJpa.deleteById(id);
    }
}
