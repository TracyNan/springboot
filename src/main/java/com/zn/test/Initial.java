package com.zn.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.zn.test.dao.impl.LoginDaoImpl;

@Component
public class Initial implements CommandLineRunner {

	@Autowired
	private LoginDaoImpl loginDao;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		loginDao.initUsers();
	}

}
