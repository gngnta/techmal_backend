package backend.repository.mapper;

import backend.domain.Battle;
import backend.repository.entity.BattleEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BattleMapper {
    BattleEntity toEntity(Battle battle);

    Battle toDomain(BattleEntity battleEntity);

    List<BattleEntity> toEntities(List<Battle> battles);

    List<Battle> toDomains(List<BattleEntity> battleEntities);
}
