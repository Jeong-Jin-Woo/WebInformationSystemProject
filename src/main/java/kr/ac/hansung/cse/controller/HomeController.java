package kr.ac.hansung.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home"; // ~/home.jsp
	}
	
	@RequestMapping("/information")
	public String information() {
		return "information"; // ~/information.jsp
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
