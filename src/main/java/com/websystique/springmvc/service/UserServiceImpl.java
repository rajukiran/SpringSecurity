package com.websystique.springmvc.service;

import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;
import com.websystique.springmvc.dao.UserDao;
import com.websystique.springmvc.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	
//	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	
	private UserDao userDao;

    public void setUserDAO(UserDao userDAO) {
	this.userDao = userDAO;
    }

	public List<User> findAllUsers() {
		return this.userDao.getAllUsers();
	}
	
	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public User findByName(String name) {
		for(User user : users){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(User user) {
		//user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(User user) {
		return findByName(user.getName())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	
}
