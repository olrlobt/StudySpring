package olrlobt.springstudy.nonFk.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponse {

	private long boardId;
	private List<ReplyResponse> replies;
	private String userName;

}
