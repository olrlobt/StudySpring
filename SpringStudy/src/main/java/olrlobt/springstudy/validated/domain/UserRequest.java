package olrlobt.springstudy.validated.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class UserRequest {

	@Email(groups = UserValidationGroup.class)
	private String email;

	@NotBlank(groups = {UserValidationGroup.class, AdminValidationGroup.class})
	private String password;
}
