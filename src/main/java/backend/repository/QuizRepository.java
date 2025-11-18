package backend.repository;

import backend.domain.Quiz;
import backend.repository.entity.QuizEntity;
import backend.repository.jpa.QuizJpa;
import backend.repository.mapper.QuizMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class QuizRepository {

    private final QuizJpa quizJpa;
    private final QuizMapper quizMapper;

    public QuizRepository(QuizJpa quizJpa, QuizMapper quizMapper) {
        this.quizJpa = quizJpa;
        this.quizMapper = quizMapper;
    }

    public Quiz save(Quiz quiz) {
        QuizEntity entity = quizMapper.toEntity(quiz);
        QuizEntity saved = quizJpa.save(entity);
        return quizMapper.toDomain(saved);
    }

    public Optional<Quiz> findById(Integer id) {
        return quizJpa.findById(id).map(quizMapper::toDomain);
    }

    public List<Quiz> findAll() {
        return quizJpa.findAll().stream().map(quizMapper::toDomain).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        quizJpa.deleteById(id);
    }
}
