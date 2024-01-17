package kr.ac.hansung.cse.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.service.OfferService;

@Controller
public class OfferController {
	@Autowired
	OfferService offerService;
	
	//cRud
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offerService.getCurrent();
		model.addAttribute("offers", offers);
		return "offers";
	}
	
	//Crud
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		model.addAttribute("offer", new Offer());
		
		return "createoffer";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) { // 결과값을 result에 전달.
		if(result.hasErrors()) {
			return "createoffer";
		}
//		System.out.println(offer);
		offerService.setOffer(offer);
		return "offercreated";
	}
	
}
