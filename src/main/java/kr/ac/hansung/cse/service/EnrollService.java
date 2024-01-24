package kr.ac.hansung.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.EnrollDao;
import kr.ac.hansung.cse.model.Enroll;
import kr.ac.hansung.cse.model.InformationList;

@Service
public class EnrollService {
	@Autowired
	EnrollDao enrollDao;
	
	public List<Enroll> getCurrent(String name){
		return enrollDao.getEnrolls(name);
	}

	public List<Enroll> getCurrents(){
		return enrollDao.getInformationLists();
	}
	
	public void setEnroll(Enroll enroll) {
		try {
			enrollDao.insert(enroll);
        } catch (DuplicateKeyException e) {
            // 중복 예외 처리 또는 다른 로직 수행
            throw new DuplicateKeyException("Duplicate entry for key 'enrollment.PRIMARY'");
        }
	}
	public void classidCheck(Enroll enroll) {
		if(!enrollDao.read(enroll))
            throw new DuplicateKeyException("No code");
	}
	public void deleteEnroll(String name, String class_id) {
		enrollDao.delete(name, class_id);
	}
}
