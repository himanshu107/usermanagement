package com.modestack.service;
import java.io.IOException;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Service;

import com.modestack.common.RepositoryDependencyBean;
import com.modestack.model.User;

@Service
public class UserServiceImpl extends RepositoryDependencyBean implements UserService {
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public String userLogin(String email, String password) {
		
		
		String targetUrl="";
		Query loginQuery =new Query(
			Criteria.where("email").is(email).and("password").is(password)
				);
		User user =  mongoTemplate.findOne(loginQuery, User.class);
		
		if(user != null) {
			 targetUrl ="/superadminredirect"; 
			System.out.println("request comming");
			 
			return "Login successfully";
			 
		}else {
			return "Please check your username and password";
		}
		
	}

}
