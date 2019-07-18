package com.zn.test.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.zn.test.dao.LoginDao;
import com.zn.test.pojo.LoginInfo;
import com.zn.test.pojo.user.ZWUser;

@Service
public class LoginDaoImpl implements LoginDao {

	private JdbcTemplate jdbcTemplate;
	
	public List<ZWUser> zWUsers;
	

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public LoginInfo getLogininfo(String userId) {
		String sql = "select top 1 * from QT_USER_ACCESS where SOEID = ?";
		LoginInfo loginInfo = new LoginInfo();
		this.jdbcTemplate.query(sql, new Object[] { userId }, (ResultSet rs, int index) -> {
			// TODO Auto-generated method stub
			loginInfo.setSoeId(rs.getString("SOEID"));
			loginInfo.setHostname(rs.getString("HostName"));
			loginInfo.setVersion(rs.getString("Version"));
			loginInfo.setSource(rs.getString("Source"));
			loginInfo.setLastLoginTime(rs.getDate("LastLoginTime"));
			return null;
		});

		return loginInfo;
	}

	@Override
	public ZWUser nwLogin(String username, String password) {
//		String sql = "select * from ZW_USER where username=? and password=?";
//		ZWUser user = new ZWUser();
//		this.jdbcTemplate.query(sql, new Object[] { username, password }, (ResultSet rs, int index) -> {
//			user.setLoginId(rs.getInt("userid"));
//			user.setUsername(rs.getString("username"));
//			user.setPassword(rs.getString("password"));
//			return null;
//		});
//		return user;
		ZWUser user =null;
		for (ZWUser zwUser : zWUsers) {
			if (username.equals(zwUser.getUsername())&&password.equals(zwUser.getPassword())) {
				user=zwUser;
			}
		}
		return user;
	}

	public void initUsers(){
		System.out.println("init method");
		String sql = "select * from ZW_USER";
		zWUsers=this.jdbcTemplate.query(sql, new Object[] {}, (ResultSet rs, int index) -> {
			ZWUser user = new ZWUser();
			user.setLoginId(rs.getInt("userid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			return user;
		});
	}
}
