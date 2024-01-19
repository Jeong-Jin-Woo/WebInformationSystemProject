package kr.ac.hansung.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.SemesterDao;
import kr.ac.hansung.cse.model.Semester;

@Service
public class SemesterService {
	@Autowired
	SemesterDao semesterDao;

	public List<Semester> getCurrents(String name){
		return semesterDao.getSemesters(name);
	}
	public Semester getCurrent(String name){
		return semesterDao.getSemester(name);
	}
	
}
