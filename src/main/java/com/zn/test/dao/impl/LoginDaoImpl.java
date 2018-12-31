package com.zn.test.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.zn.test.dao.LoginDao;
import com.zn.test.pojo.LoginInfo;

@Service
public class LoginDaoImpl implements LoginDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
	@Override
	public LoginInfo getLogininfo(String userId) {
		String sql="select top 1 * from QT_USER_ACCESS where SOEID = ?";
		LoginInfo loginInfo=new LoginInfo();
		this.jdbcTemplate.query(sql, new Object[]{userId}, new RowMapper<LoginInfo>() {
			
			@Override
			public LoginInfo mapRow(ResultSet rs, int index) throws SQLException {
				// TODO Auto-generated method stub
				loginInfo.setSoeId(rs.getString("SOEID"));
				loginInfo.setHostname(rs.getString("HostName"));
				loginInfo.setVersion(rs.getString("Version"));
				loginInfo.setSource(rs.getString("Source"));
				loginInfo.setLastLoginTime(rs.getDate("LastLoginTime"));
				return null;
			}
			
		});
		
		return loginInfo;
	}

}
