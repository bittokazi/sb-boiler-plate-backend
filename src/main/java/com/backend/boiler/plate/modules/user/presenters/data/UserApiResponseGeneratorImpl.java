package com.backend.boiler.plate.modules.user.presenters.data;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.backend.boiler.plate.Utils.Constants;
import com.backend.boiler.plate.modules.base.data.ResponseGeneratorBase;
import com.backend.boiler.plate.modules.user.interactors.UserInteractorInterface;

import model.User;

@Service
public class UserApiResponseGeneratorImpl extends ResponseGeneratorBase implements UserInteractorInterface.showAllUsers {

	Constants constants = Constants.getInstance();
	
	@Override
	public void showAllUsersSuccess(Map<String, Object> generatedResponse, List<User> userList) {
		success(generatedResponse);
		generatedResponse.put(constants.USERS_API_MAP_KEY, userList);
	}

	@Override
	public void showAllUsersError(Map<String, Object> generatedResponse, HttpServletResponse response) {
		error(generatedResponse, response);
	}

}
