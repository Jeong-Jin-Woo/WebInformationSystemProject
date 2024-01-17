package kr.ac.hansung.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.InformationListDao;
import kr.ac.hansung.cse.model.InformationList;

@Service
public class InformationListService {
	@Autowired
	InformationListDao informationListDao;
	
	public List<InformationList> getCurrent(){
		return informationListDao.getInformationLists();
	}
	
}
