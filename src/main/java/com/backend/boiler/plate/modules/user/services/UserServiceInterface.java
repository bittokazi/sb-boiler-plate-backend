package com.backend.boiler.plate.modules.user.services;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public interface UserServiceInterface {
	Map<String, Object> showAllUsers(HttpServletResponse response);
}
