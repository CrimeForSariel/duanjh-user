package com.asjy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.asjy.model.User;
import com.asjy.util.Dao;

public class UserDao extends Dao{

	public static List<User> getUser(String sql, Object...obj){
		List<User> list = null;
		Connection conn = getConn();
		PreparedStatement ps = null;
		ResultSet r = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
			list = new ArrayList<>();
			r = ps.executeQuery();
			while (r.next()) {
				User user = new User();
				user.setId(r.getInt("id"));
				user.setUsername(r.getString("username"));
				user.setPassword(r.getString("password"));
				user.setUsercname(r.getString("usercname"));
				user.setAddtime(r.getString("addtime"));
				list.add(user);
			}
		} catch (SQLException e) {
			System.err.println("sql´íÎó:" + sql);
			System.err.println(e.getMessage());
		} finally {
			close(r, ps, conn);
		}
		return list;
	}
}
