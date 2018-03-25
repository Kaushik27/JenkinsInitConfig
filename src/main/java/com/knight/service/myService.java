package com.knight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knight.dao.myRepository;
import com.knight.dto.Student;

@Service
public class myService {
	
	@Autowired
	myRepository repo;

	public Student getDataFromService(String id) {
		return repo.getValueFromDao(id);
	}

	public List<Student> getAllDataFromService() {
		return repo.getAllValueFromDao();
	}

	public int insertDataFromView(Student student) {
		return repo.insertData(student);
	}

	
}
