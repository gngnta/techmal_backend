package backend.repository.mapper;

import backend.domain.User;
import backend.repository.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(User user);

    User toDomain(UserEntity userEntity);

    List<UserEntity> toEntities(List<User> users);

    List<User> toDomains(List<UserEntity> userEntities);
}
