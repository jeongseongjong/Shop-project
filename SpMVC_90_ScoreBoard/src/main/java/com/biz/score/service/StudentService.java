package com.biz.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.score.dao.StudentDao;
import com.biz.score.domain.StudentVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentDao studentDao ;
	
	public List<StudentVO> studentList(){
		
		return studentDao.selectAll();
	}

	public int insert(StudentVO studentVO) {
		
		return studentDao.insert(studentVO);
	}

	public StudentVO findByNum(String st_num) {

		return studentDao.findByNum(st_num);
	}

	public int update(StudentVO studentVO) {

		return studentDao.update(studentVO);
	}

	public int delete(long st_num) {

		return studentDao.delete(st_num);
	}

	public List<StudentVO> join(long st_num) {
		
		return studentDao.join(st_num);
		
	}
}
