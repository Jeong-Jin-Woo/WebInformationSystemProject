package kr.ac.hansung.cse.model;

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
public class Enroll {
	@Size(min=1, max=10, message="Name must be between 2 and 10 chars")
	@NotEmpty(message="The 과목 코드 cannot be empty")
	String class_id;
	@NotEmpty(message="The 분반 cannot be empty")
	String division;

	String stu_name;
	String professor;
	String title;
	int credit;
	String room;
    
}
