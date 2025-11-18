package backend.repository.mapper;

import backend.domain.Quiz;
import backend.repository.entity.QuizEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuizMapper {
    QuizEntity toEntity(Quiz quiz);

    Quiz toDomain(QuizEntity quizEntity);

    List<QuizEntity> toEntities(List<Quiz> quizzes);

    List<Quiz> toDomains(List<QuizEntity> quizEntities);
}
