package olrlobt.springstudy.nonFk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import olrlobt.springstudy.nonFk.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
