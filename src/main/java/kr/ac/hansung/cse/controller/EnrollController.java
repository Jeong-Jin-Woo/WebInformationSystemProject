package kr.ac.hansung.cse.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
		
		List<Enroll> informations = enrollService.getCurrents();
		model.addAttribute("informations", informations);
		
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
	

	@RequestMapping(value = "/doenroll", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Enroll enroll, BindingResult result, RedirectAttributes redirectAttributes) { // 결과값을 result에 전달.
		if(result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error: errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "enroll";
		}
		try {
			enrollService.classidCheck(enroll); // 있는 교과코드?
			try { // 중복?
				enrollService.setEnroll(enroll);
				redirectAttributes.addAttribute("name", enroll.getStu_name());
			    return "redirect:/enroll";
			}catch (DuplicateKeyException e) {
	            // 중복 예외 처리 또는 다른 로직 수행
	            model.addAttribute("errorMessage", "중복된 키 예외가 발생했습니다.");
	            model.addAttribute("msg", "이미 수강신청한 교과목입니다.");
	            model.addAttribute("url", "enroll?name=" + enroll.getStu_name());
	            return "error";
	        }
		}
		catch (DuplicateKeyException e) {
            model.addAttribute("msg", "존재하지 않는 과목코드/분반 입니다.");
            model.addAttribute("url", "enroll?name=" + enroll.getStu_name());
	        return "error";
		}
	}
	
}
