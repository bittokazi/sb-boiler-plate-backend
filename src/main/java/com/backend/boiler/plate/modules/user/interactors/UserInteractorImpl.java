package com.backend.boiler.plate.modules.user.interactors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.boiler.plate.modules.base.data.repository.UserRepository;
import com.backend.boiler.plate.modules.base.executor.Executor;
import com.backend.boiler.plate.modules.base.executor.ExecutorService;
import com.backend.boiler.plate.modules.user.presenters.data.UserApiResponseGeneratorImpl;

import model.User;

@Service
public class UserInteractorImpl implements UserInteractorInterface {
	
	@Autowired
	private ExecutorService executorService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserApiResponseGeneratorImpl userApiResponseGeneratorImpl;

	@Override
	public Map<String, Object> showAllUsers(HttpServletResponse response) {
		Map<String, Object> generatedResponse = new HashMap<>();
		UserInteractorInterface.showAllUsers showAllUsers = this.userApiResponseGeneratorImpl;
		this.executorService.run(new Executor() {
			@Override
			public void execute() {
				List<User> userList = userRepository.findAll();
				if(userList != null) {
					showAllUsers.showAllUsersSuccess(generatedResponse, userList);
				} else {
					showAllUsers.showAllUsersError(generatedResponse, response);
				}
			}
		}, "Error on All User Retrival");
		return generatedResponse;
	}

}
