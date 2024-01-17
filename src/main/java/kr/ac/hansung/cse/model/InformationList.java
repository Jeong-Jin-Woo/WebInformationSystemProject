package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class InformationList {
	int year;
	int semester;
	String course_id;
	String title;
	String name;
	String division;
	String classroom;
	int credit;
}
