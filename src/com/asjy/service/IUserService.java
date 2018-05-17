package com.asjy.service;

import java.util.List;

import com.asjy.model.User;

public interface IUserService {

	public List<User> findAll();
	
	public void add(User user);
	
	public void delete(int id);
	
	public void update(User user);
}
