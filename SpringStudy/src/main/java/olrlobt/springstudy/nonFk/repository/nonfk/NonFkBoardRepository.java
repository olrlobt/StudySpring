package olrlobt.springstudy.nonFk.repository.nonfk;

import org.springframework.data.jpa.repository.JpaRepository;

import olrlobt.springstudy.nonFk.domain.nonfk.NonFkBoard;

public interface NonFkBoardRepository extends JpaRepository<NonFkBoard, Long> {
}
