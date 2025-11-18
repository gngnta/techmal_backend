package backend.repository;

import backend.domain.User;
import backend.repository.entity.UserEntity;
import backend.repository.jpa.UserJpa;
import backend.repository.mapper.UserMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class UserRepository {

    private final UserJpa userJpa;
    private final UserMapper userMapper;

    public UserRepository(UserJpa userJpa, UserMapper userMapper) {
        this.userJpa = userJpa;
        this.userMapper = userMapper;
    }

    public User save(User user) {
        UserEntity entity = userMapper.toEntity(user);
        UserEntity saved = userJpa.save(entity);
        return userMapper.toDomain(saved);
    }

    public Optional<User> findById(Integer id) {
        return userJpa.findById(id).map(userMapper::toDomain);
    }

    public List<User> findAll() {
        return userJpa.findAll().stream().map(userMapper::toDomain).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        userJpa.deleteById(id);
    }
}
