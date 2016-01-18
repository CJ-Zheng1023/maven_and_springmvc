package com.zhengchj.service.impl;

import org.springframework.stereotype.Service;

import com.zhengchj.domain.Student;
import com.zhengchj.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	public Student getStu(String id) {
		// TODO Auto-generated method stub
		return new Student(id,"zheng","male","soccer");
	}

}
