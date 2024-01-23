package kr.ac.hansung.cse.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ac.hansung.cse.model.Enroll;
import kr.ac.hansung.cse.service.EnrollService;

@Controller
public class EnrollController {
	@Autowired
	EnrollService enrollService;
	
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String showEnrolls(@RequestParam(value="name",required=false)String name, Model model) {
		List<Enroll> enrolls = enrollService.getCurrent(name);
		model.addAttribute("enrolls", enrolls);
		return "check";
	}
	
	//Crud
	@RequestMapping(value = "/enroll", method = RequestMethod.GET)
	public String enroll(@RequestParam(value="name",required=false)String name, Model model) {
		Enroll enroll = new Enroll();		
		model.addAttribute("enroll", enroll);
		
		List<Enroll> enrolls = enrollService.getCurrent(name);
		model.addAttribute("enrolls", enrolls);
		
		return "enroll";
	}
	
	//D
	@RequestMapping(value = "/enroll/delete", method = RequestMethod.GET)
	public String enrollDelete(
			@RequestParam(value="stu_name",required=false)String stu_name, 
			@RequestParam(value="class_id",required=false)String class_id, 
			Model model,
			RedirectAttributes redirectAttributes) {
		enrollService.deleteEnroll(stu_name, class_id);
		redirectAttributes.addAttribute("name", stu_name);
	    return "redirect:/enroll";
	}
	
//	//D
//	@RequestMapping(value = "/enroll/delete", method = RequestMethod.GET)
//	public String enrollDelete(
//			@RequestParam(value="enroll",required=false)Enroll enroll,  
//			Model model,
//			RedirectAttributes redirectAttributes) {
//
////		enrollService.deleteEnroll(enroll);
//		System.out.println(enroll);
//		redirectAttributes.addAttribute("name", enroll.getStu_name());
//	    return "redirect:/enroll";
//	}

	@RequestMapping(value = "/doenroll", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Enroll enroll, BindingResult result, RedirectAttributes redirectAttributes) { // 결과값을 result에 전달.
		if(result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error: errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "enroll";
		}
		System.out.println(model);
		System.out.println(enroll);
		enrollService.setEnroll(enroll);
		redirectAttributes.addAttribute("name", enroll.getStu_name());
	    return "redirect:/enroll";
	}

}
