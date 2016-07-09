package com.junaid.training.springjdbc;

import com.bov.dto.User;

public interface BankOfVizDao {

	
	public void insert(User usr);
	
	
	public User findUserById(int id);
}
