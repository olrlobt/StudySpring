package olrlobt.springstudy.nonFk.service.nonfk;

import olrlobt.springstudy.nonFk.domain.nonfk.NonFkBoard;

public interface NonFkBoardService {

	NonFkBoard findBoard(Long boardId);

	void addBoard();

	void deleteBoard(Long boardId);

	void addReply(Long boardId);
}
