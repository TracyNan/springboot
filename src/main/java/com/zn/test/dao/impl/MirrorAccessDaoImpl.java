package com.zn.test.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.zn.test.dao.MirrorAccessDao;

@Service
public class MirrorAccessDaoImpl implements MirrorAccessDao {

	private JdbcTemplate jdbcTemplate;
	private String mirrorActivity = "insert into EEMS_USER values(?,?,?,'A',getdate(),getdate())";
	private String mirrorProfile = "insert into EEMS_USER_PROFILE select ?,Type,Value,getdate() from EEMS_USER_PROFILE where UserID=?";
	private String mirrorRrole = "insert into EEMS_URR select ?,ResourceID,ResourceName,RoleName,ENV,getdate() from EEMS_URR where UserID=?";

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void mirrorAccess(String mirrorId, String userId, String userName, String userMail) {
		this.jdbcTemplate.update(mirrorActivity, new Object[] { userId, userName, userMail });
		this.jdbcTemplate.update(mirrorProfile, new Object[] { userId, mirrorId });
		this.jdbcTemplate.update(mirrorRrole, new Object[] { userId, mirrorId });
	}

}
