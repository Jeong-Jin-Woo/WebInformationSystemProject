package kr.ac.hansung.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.ScoreDao;
import kr.ac.hansung.cse.model.Score;

@Service
public class ScoreService {
	@Autowired
	ScoreDao scoreDao;

	public List<Score> getCurrents(String name, int year, int semester){
		return scoreDao.getScores(name, year, semester);
	}
	
}
