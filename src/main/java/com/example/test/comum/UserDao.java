package com.example.test.comum;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	public User findByPrimaryKey(Integer id) {
		return null;
	}

	public List<User> findAllActiveUsers(List<Integer> usersIds) {
		return null;
	}

}
