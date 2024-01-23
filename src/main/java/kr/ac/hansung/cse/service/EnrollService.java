package kr.ac.hansung.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.EnrollDao;
import kr.ac.hansung.cse.model.Enroll;

@Service
public class EnrollService {
	@Autowired
	EnrollDao enrollDao;
	
	public List<Enroll> getCurrent(String name){
		return enrollDao.getEnrolls(name);
	}
	public void setEnroll(Enroll enroll) {
		enrollDao.insert(enroll);
	}
}
