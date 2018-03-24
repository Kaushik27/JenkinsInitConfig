package com.knight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knight.dao.myRepository;

@Service
public class myService {
	
	@Autowired
	myRepository repo;

	public Object getDataFromService(String id) {
		return repo.getValueFromDao(id);
	}

	
}
