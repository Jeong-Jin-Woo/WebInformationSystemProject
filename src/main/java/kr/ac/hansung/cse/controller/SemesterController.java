package kr.ac.hansung.cse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.cse.model.Score;
import kr.ac.hansung.cse.model.Semester;
import kr.ac.hansung.cse.service.ScoreService;
import kr.ac.hansung.cse.service.SemesterService;

@Controller
public class SemesterController {
	@Autowired
	SemesterService semesterService;
	
	@RequestMapping(value = "/information/semester")
	public String semester(@RequestParam(name = "name", required = false) String name, Model model) {
	    // ?name='~~~'
		List<Semester> semesters = semesterService.getCurrents(name);
		model.addAttribute("semesters", semesters);

		return "semester"; // ~/semester.jsp
	}

	@Autowired
	ScoreService scoreService;
	@RequestMapping(value = "/information/semester/score")
	public String score(
	    @RequestParam(name = "name", required = false) String name,
	    @RequestParam int year,
	    @RequestParam int semester,
	    Model model
	) {
	    // ~~~/score?name=??&year=??~~
		List<Score> scores = scoreService.getCurrents(name, year, semester);
		model.addAttribute("scores", scores);
		return "score"; // ~/score.jsp
	}

	
}
