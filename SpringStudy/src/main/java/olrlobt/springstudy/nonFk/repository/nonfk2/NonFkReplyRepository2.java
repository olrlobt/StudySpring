package olrlobt.springstudy.nonFk.repository.nonfk2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import olrlobt.springstudy.nonFk.domain.nonfk2.NonFkReply2;

public interface NonFkReplyRepository2 extends JpaRepository<NonFkReply2, Long> {
	List<NonFkReply2> findAllByBoardId(Long boardId);
}
