package com.example.test.modifiedsource.seconditem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.comum.UserDao;

import ma.glasnost.orika.MapperFacade;

@Service
public class UsersService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MapperFacade mapperFacade;
	
	public List<UserOutput> searchUsers(List<Integer> usersIds) {
		return mapperFacade.mapAsList(userDao.findAllActiveUsers(usersIds), UserOutput.class);
	}
}
