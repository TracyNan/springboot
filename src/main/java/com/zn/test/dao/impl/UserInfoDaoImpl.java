package com.zn.test.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.zn.test.dao.UserInfoDao;
import com.zn.test.pojo.UserInfo;
import com.zn.test.pojo.user.UserBaseInfo;
import com.zn.test.pojo.user.UserProfInfo;
import com.zn.test.pojo.user.UserRoleInfo;

@Service
public class UserInfoDaoImpl implements UserInfoDao {
	private JdbcTemplate jdbcTemplate;
	private String baseInfoSQL = "select * from EEMS_USER where ID = ?";
	private String profileInfoSQL = "select * from EEMS_USER_PROFILE where UserID = ?";
	private String roleInfoSQL = "select * from EEMS_URR where UserID = ?";

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public UserInfo getUserInfo(String userId) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserBaseInfo(getUserBaseInfo(userId));
		userInfo.setUserProfInfo(getUserProfileInfo(userId));
		userInfo.setUserRoleInfos(getUserRoleInfo(userId));
		return userInfo;
	}

	private UserBaseInfo getUserBaseInfo(String userId) {

		List<UserBaseInfo> baseInfos = this.jdbcTemplate.query(baseInfoSQL, new Object[] { userId }, new RowMapper<UserBaseInfo>() {

			@Override
			public UserBaseInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserBaseInfo baseInfo = new UserBaseInfo();
				baseInfo.setId(rs.getString("ID"));
				baseInfo.setName(rs.getString("Name"));
				baseInfo.seteMail(rs.getString("Email"));
				baseInfo.setStatus(rs.getString("Status"));
				return baseInfo;
			}
		});
		if (baseInfos.isEmpty()) {
			return null;
		}
		return baseInfos.get(0);
	}

	private UserProfInfo getUserProfileInfo(String userId) {
		List<UserProfInfo> profInfos = this.jdbcTemplate.query(profileInfoSQL, new Object[] { userId }, new RowMapper<UserProfInfo>() {

			@Override
			public UserProfInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserProfInfo profInfo = new UserProfInfo();
				profInfo.setId(rs.getString("UserID"));
				profInfo.setType(rs.getString("Type"));
				profInfo.setValue(rs.getString("Value"));
				return profInfo;
			}
		});
		if (profInfos.isEmpty()) {
			return null;
		}
		return profInfos.get(0);
	}

	private List<UserRoleInfo> getUserRoleInfo(String userId) {
		List<UserRoleInfo> profInfos = this.jdbcTemplate.query(roleInfoSQL, new Object[] { userId }, new RowMapper<UserRoleInfo>() {

			@Override
			public UserRoleInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserRoleInfo profInfo = new UserRoleInfo();
				profInfo.setId(rs.getString("UserID"));
				profInfo.setResourceId(rs.getString("ResourceID"));
				profInfo.setResourceName(rs.getString("ResourceName"));
				profInfo.setRoleName(rs.getString("RoleName"));
				profInfo.setEnv(rs.getString("ENV"));
				return profInfo;
			}
		});
		if (profInfos.isEmpty()) {
			return null;
		}
		return profInfos;
	}

}
