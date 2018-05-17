package com.asjy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Dao {
	/*
	 * 增删改
	 * 例子：String sql = insert into stu values(?, ?, ?);
	 * 	Dao.update(sql, 1, 2, 3);
	 */
	public static boolean update(String sql, Object...obj){
		
		Connection c = getConn();
		PreparedStatement ps = null;
		try {
			ps = c.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				System.out.println(obj[i]);
				ps.setObject(i + 1, obj[i]);
			}
			int x = ps.executeUpdate();
			if (x > 0) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("SQL错误：" + sql);
			System.out.println(e.getMessage());
		} finally {
			close(null, ps, c);
		}
		
		return false;
	}
	
	//获取个数
	public static int getCount(String sql, Object...obj){
		int count = 0;
		Connection conn = getConn();
		PreparedStatement ps = null;
		ResultSet r = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
			r = ps.executeQuery();
			while (r.next()) {
				count = r.getInt(1);
			}
		} catch (SQLException e) {
			System.err.println("sql错误:" + sql);
			System.err.println(e.getMessage());
		} finally {
			close(r, ps, conn);
		}
		return count;
	}

	//获取链接
	public static Connection getConn() {
		Connection c = null;
		try {
			Class.forName(Const.DRIVER_CLASS);
			c = DriverManager.getConnection(Const.URL, Const.USER, Const.PW);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动不存在!");
		} catch (SQLException e) {
			System.out.println("URL、账号、密码错误");
		}
		return c;
	}
	public static void close(ResultSet r, Statement s, Connection c) {
		if (r != null) {
			try {
				r.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (s != null) {
			try {
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
