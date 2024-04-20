package olrlobt.springstudy.nonFk.service.nonfk;

import olrlobt.springstudy.nonFk.domain.nonfk.NonFkBoard;
import olrlobt.springstudy.nonFk.dto.BoardResponse;

public interface NonFkBoardService {

	BoardResponse findBoard(Long boardId);

	void addBoard();

	void deleteBoard(Long boardId);

	void addReply(Long boardId);
}
