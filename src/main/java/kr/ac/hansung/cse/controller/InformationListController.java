package kr.ac.hansung.cse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.cse.model.InformationList;
import kr.ac.hansung.cse.service.InformationListService;

@Controller
public class InformationListController {
	@Autowired
	InformationListService informationListService;
	
	@RequestMapping("/informationLists")
	public String showInformationLists(Model model) {
		List<InformationList> informationLists = informationListService.getCurrent();
		model.addAttribute("informationLists", informationLists);
		return "informationLists";
	}
	
}
