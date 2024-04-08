package olrlobt.springstudy.nonFk.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddBoardRequest {
	private List<Long> itemIds;
}
