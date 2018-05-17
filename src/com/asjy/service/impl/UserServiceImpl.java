package com.asjy.service.impl;

import java.util.List;

import com.asjy.dao.UserDao;
import com.asjy.model.User;
import com.asjy.service.IUserService;

public class UserServiceImpl implements IUserService {

	@Override
	public List<User> findAll() {
		String sql = " select id,username,password,usercname,addtie from tb_user";
		return UserDao.getUser(sql);
	}

	@Override
	public void add(User user) {
		String sql = "insert into tb_user (username,password,usercname,addtime) values (?,?,?, now())";
		UserDao.update(sql, user.getUsername(),user.getPassword(),user.getUsercname());
	}

	@Override
	public void delete(int id) {
		String sql = "delete from a where id=?";
		UserDao.update(sql, id);
		
	}

	@Override
	public void update(User user) {
		String sql = "update tb_user set username = ? , password = ? , usercname = ? where id = ?";
		UserDao.update(sql, user.getUsername(),user.getPassword(),user.getUsercname(),user.getId());
		
	}

}
