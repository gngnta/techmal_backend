package backend.repository.mapper;

import backend.domain.Choice;
import backend.repository.entity.ChoiceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChoiceMapper {
    ChoiceEntity toEntity(Choice choice);

    Choice toDomain(ChoiceEntity choiceEntity);

    List<ChoiceEntity> toEntities(List<Choice> choices);

    List<Choice> toDomains(List<ChoiceEntity> choiceEntities);
}
