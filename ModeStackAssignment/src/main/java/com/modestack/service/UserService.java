
package com.modestack.service;

import com.modestack.model.User;

public interface UserService {

	public void saveUser(User user);

	public String userLogin(String email, String password);

}
