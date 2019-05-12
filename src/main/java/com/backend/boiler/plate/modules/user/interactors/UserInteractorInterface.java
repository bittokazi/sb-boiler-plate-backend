package com.backend.boiler.plate.modules.user.interactors;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import model.User;

public interface UserInteractorInterface {
	
	Map<String, Object> showAllUsers(HttpServletResponse response);
	
	interface showAllUsers {
		void showAllUsersSuccess(Map<String, Object> generatedResponse, List<User> userList);
		void showAllUsersError(Map<String, Object> generatedResponse, HttpServletResponse response);
	}
}
