package olrlobt.springstudy.nonFk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import olrlobt.springstudy.nonFk.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
