package com.backend.boiler.plate.modules.user.presenters;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.backend.boiler.plate.Utils.Mappings;
import com.backend.boiler.plate.modules.user.services.UserServiceImpl;
import com.backend.boiler.plate.modules.user.services.UserServiceInterface;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = Mappings.API)
public class RestUserController {
	
	private UserServiceInterface userServiceInterface;
	
	public RestUserController(UserServiceImpl userServiceImpl) {
		this.userServiceInterface = userServiceImpl;
	} 
	
	@Secured({ "ROLE_SUPER_ADMIN"})
	@GetMapping(Mappings.API_USER)
	public Map<String, Object> showUser(HttpServletResponse response) {
		return this.userServiceInterface.showAllUsers(response);
	}
}
