package kr.ac.hansung.cse.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Offer {
	int id;
	@Size(min=2, max=100, message="Name must be between 2 and 100 chars")
	String name;
	@Email(message="Please provide a valid email address")
	@NotEmpty(message="The email address cannot be empty")
	String email;
	@NotEmpty(message="The password cannot be empty")
	@Size(min=2, max=50, message="Name must be between 1 and 50 chars")
	String password;
	
}
