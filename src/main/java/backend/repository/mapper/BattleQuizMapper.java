package backend.repository.mapper;

import backend.domain.BattleQuiz;
import backend.repository.entity.BattleQuizEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BattleQuizMapper {
    BattleQuizEntity toEntity(BattleQuiz battleQuiz);

    BattleQuiz toDomain(BattleQuizEntity battleQuizEntity);

    List<BattleQuizEntity> toEntities(List<BattleQuiz> battleQuizzes);

    List<BattleQuiz> toDomains(List<BattleQuizEntity> battleQuizEntities);
}
