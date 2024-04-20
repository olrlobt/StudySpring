package olrlobt.springstudy.nonFk.repository.nonfk;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import olrlobt.springstudy.nonFk.domain.nonfk.NonFkReply;

public interface NonFkReplyRepository extends JpaRepository<NonFkReply, Long> {
	List<NonFkReply> findAllByBoardId(Long boardId);
}
