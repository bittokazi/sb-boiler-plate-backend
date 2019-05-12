package com.backend.boiler.plate.modules.user.services;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.boiler.plate.modules.user.interactors.UserInteractorInterface;

import model.User;

import com.backend.boiler.plate.modules.base.data.repository.UserRepository;
import com.backend.boiler.plate.modules.user.interactors.UserInteractorImpl;

@Service
public class UserServiceImpl implements UserDetailsService, UserServiceInterface {
	
	private UserInteractorInterface userInteractorInterface;
	private UserRepository userDao;
	
	public UserServiceImpl(UserInteractorImpl userInteractorInterfaceImpl, UserRepository userDao) {
		this.userInteractorInterface = userInteractorInterfaceImpl;
		this.userDao = userDao;
	}

	@Override
	public Map<String, Object> showAllUsers(HttpServletResponse response) {
		return this.userInteractorInterface.showAllUsers(response);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userDao.findOneByEmail(username);
		if (user.isPresent()) {
			return user.get();
		}
		throw new UsernameNotFoundException("No such user: " + username);
	}

}
