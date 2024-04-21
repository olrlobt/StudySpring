package olrlobt.springstudy.nonFk.service.nonfk2;

import olrlobt.springstudy.nonFk.dto.BoardResponse;

public interface NonFkBoardService2 {
	BoardResponse findBoard(Long boardId);

	void addBoard();

	void deleteBoard(Long boardId);

	void addReply(Long boardId);
}
