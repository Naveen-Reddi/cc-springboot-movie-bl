package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.mappers.MyUserRowMapper;
import com.example.demo.mappers.UsersCountRowMapper;
import com.example.demo.model.MyUser;


@Service
public class MyUserDetailsService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int create(MyUser user) {
		String sql="INSERT INTO myuser VALUES(?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, user.getUserId(), user.getUsername(),user.getPassword(), "user", user.getEmail(), user.getPhone(), user.getGender());
	}
	public List<MyUser> read() {
		return jdbcTemplate.query("SELECT * FROM myuser", new MyUserRowMapper());
	}
	public Optional<MyUser> read(String username) {
		try {
			MyUser user = jdbcTemplate.queryForObject("SELECT * FROM myuser WHERE username=?", new MyUserRowMapper(), username);
			System.out.println("User in Service "+ user);
			return Optional.of(user);
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
	    }
	}
	public int update(MyUser user) {
		String sql="UPDATE myuser SET username=?, email=?, phone=?, gender=?,  password=? WHERE userId=?";
		return jdbcTemplate.update(sql, user.getUsername(),user.getEmail(), user.getPhone(), user.getGender(), user.getPassword(), user.getUserId());
	}
	public int delete(Long userId) {
		String sql="DELETE FROM myuser WHERE userId=?";
		return jdbcTemplate.update(sql, userId);
	}
//	public int modifyUser(MyUser user) {
//		String sql="UPDATE MyUser SET  username=?, email=?, phone=?, gender=?, password=?, role=? WHERE userId=? ";
//		return jdbcTemplate.update(sql,user.getUsername(), user.getEmail(), user.getPhone(), user.getGender(), user.getPassword(), user.getRole(), user.getUserId());
//	}
	public MyUser modifyUser(MyUser user) {
		String sql="UPDATE myuser SET  username=?, email=?, phone=?, gender=? WHERE userId=? ";
		int success = jdbcTemplate.update(sql,user.getUsername(), user.getEmail(), user.getPhone(), user.getGender(), user.getUserId());
		if(success == 1) {
			return user;
		}else {
			return null;
		}
	}
	public int modifyUserbyUserName(MyUser user) {
		String sql="UPDATE myuser SET  username=?, email=?, phone=?, gender=? WHERE username=? ";
		return jdbcTemplate.update(sql,user.getUsername(), user.getEmail(), user.getPhone(), user.getGender(), user.getUserId());
	}
	public int deleteUser(String username) {
		String sql="DELETE FROM myuser WHERE username=?";
		return jdbcTemplate.update(sql, username);
   
	}
	public MyUser getUserById(Long id) {
		String sql = "SELECT * FROM myuser where userId= ?";
		return jdbcTemplate.queryForObject(sql, new MyUserRowMapper(),id);
	}
	public MyUser getUsersCount() {
		String sql = "SELECT count(userId) FROM myuser ";
		return jdbcTemplate.queryForObject(sql, new UsersCountRowMapper());

	}

}
