package olrlobt.springstudy.nonFk.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class BoardResponse {

	private long boardId;
	private List<ReplyResponse> replies;
	private String userName;
}
