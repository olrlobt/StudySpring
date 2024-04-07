package olrlobt.springstudy.valid.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class UserRequest {
	@Email
	private String email;

	@NotBlank
	private String password;

	@NotNull
	private Address address;
}
