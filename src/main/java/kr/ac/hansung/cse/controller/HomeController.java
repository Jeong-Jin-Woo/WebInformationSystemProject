package kr.ac.hansung.cse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home"; // ~/home.jsp
	}
	
	@RequestMapping(value = "/information")
	public String information() {
		return "information"; // ~/information.jsp
	}

	@RequestMapping(value = "/information/semester")
	public String semester() {
		return "semester"; // ~/semester.jsp
	}

	@RequestMapping(value = "/check")
	public String check() {
		return "check"; // ~/check.jsp
	}

	@RequestMapping(value = "/enroll")
	public String enroll() {
		return "enroll"; // ~/enroll.jsp
	}
}
