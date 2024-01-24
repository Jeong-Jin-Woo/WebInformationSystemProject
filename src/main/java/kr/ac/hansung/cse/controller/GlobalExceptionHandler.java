package kr.ac.hansung.cse.controller;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

import kr.ac.hansung.cse.model.Offer;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(DuplicateKeyException.class)
//    @ResponseStatus(HttpStatus.CONFLICT)
//    public String handleDuplicateKeyException(DuplicateKeyException ex, Model model, HttpServletRequest request) {
//        // 여기에서는 원하는 로직을 수행하거나 에러 메시지를 모델에 추가해서 에러 페이지로 전달할 수 있습니다.
//        model.addAttribute("errorMessage", "중복된 키 예외가 발생했습니다.");
//        model.addAttribute("msg", "이미 수강신청한 교과목입니다");
//
//        // 세션에서 Offer 객체 가져오기
//        Offer offer = (Offer) request.getSession().getAttribute("offer");
//        model.addAttribute("url", "/enroll?name=" + offer.getName());
//        
//        // 에러 페이지로 포워딩하거나 리다이렉트할 JSP 또는 URL을 반환합니다.
//        return "error";
//    }
}
