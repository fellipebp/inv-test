package com.example.test.originalsource.seconditem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.test.comum.User;
import com.example.test.comum.UserDao;

@Service
public class UsersService {

	private UserDao userDao;
	
	public List<UserOutput> searchUsers(List<Integer> usersIds) {
		List<UserOutput> output = new ArrayList<>();
		for (Integer id : usersIds) {
			User user = userDao.findByPrimaryKey(id);
			if (user != null && user.isActive()) {
				UserOutput userOutput = new UserOutput();
				userOutput.setId(user.getId());
				userOutput.setLogin(user.getLogin());
				userOutput.setName(user.getName());
				userOutput.setEmail(user.getEmail());
				userOutput.setCreated(user.getCreated());
				userOutput.setLastUpdate(user.getLastUpdate());
				output.add(userOutput);
			}
		}
		return output;
	}

}
