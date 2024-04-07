package olrlobt.springstudy.valid.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class UserRequest2 {
	@Email
	private String email;

	@NotBlank
	private String password;

	@Valid // NotNull 대신 @Valid를 사용한다.
	private Address address;
}

