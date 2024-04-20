package olrlobt.springstudy.nonFk.repository.nonfk;

import org.springframework.data.jpa.repository.JpaRepository;

import olrlobt.springstudy.nonFk.domain.nonfk.NonFkUser;

public interface NonFkUserRepository extends JpaRepository<NonFkUser, Long> {
}
