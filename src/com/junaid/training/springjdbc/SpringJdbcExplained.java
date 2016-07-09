package com.junaid.training.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bov.dto.User;

public class SpringJdbcExplained {
	
	public static void main(String args[]){
		
		
		ApplicationContext daoContext =
			new ClassPathXmlApplicationContext("applicationContext-dao.xml");
		BankOfVizDao jdbcDao=(BankOfVizDao)daoContext.getBean("sinanDao");
		//Populate the user here 
		User user=new User();
		user.setId(7);
		user.setUserName("Junaid");
		user.setPassword("Training");
		jdbcDao.insert(user);
		
	System.out.println("Retrieving user from JdbcTemplate " +jdbcDao.findUserById(1).getUserName());
		
	}

}
