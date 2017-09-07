package com.websystique.springmvc.dao;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.websystique.springmvc.model.User;
public class UserDaoImpl implements UserDao{

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
		
    	Session session = null;
    	
    	try{
    		session = this.sessionFactory.openSession();
			Query query = session.createQuery("from User");
			
			List<User> usersList = query.list();
			System.out.println(usersList);
		
			if (CollectionUtils.isNotEmpty(usersList)) {
		
			    return usersList;
		
			}
	    } catch(Exception e){
	    	e.printStackTrace();
	    } finally {
	    	System.out.println("Closing session");
	    	session.flush();
			session.close();
		}
		return null;
    }
}
