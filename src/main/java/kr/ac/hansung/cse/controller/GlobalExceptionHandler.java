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
//        // ���⿡���� ���ϴ� ������ �����ϰų� ���� �޽����� �𵨿� �߰��ؼ� ���� �������� ������ �� �ֽ��ϴ�.
//        model.addAttribute("errorMessage", "�ߺ��� Ű ���ܰ� �߻��߽��ϴ�.");
//        model.addAttribute("msg", "�̹� ������û�� �������Դϴ�");
//
//        // ���ǿ��� Offer ��ü ��������
//        Offer offer = (Offer) request.getSession().getAttribute("offer");
//        model.addAttribute("url", "/enroll?name=" + offer.getName());
//        
//        // ���� �������� �������ϰų� �����̷�Ʈ�� JSP �Ǵ� URL�� ��ȯ�մϴ�.
//        return "error";
//    }
}
