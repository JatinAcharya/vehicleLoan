package com.lti.vehicleloan.layer5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.vehicleloan.layer2.Login;
import com.lti.vehicleloan.layer2.UserDetail;
import com.lti.vehicleloan.layer4.LoginService;

@RestController
@CrossOrigin
public class LoginController {
	@Autowired
	private LoginService loginService;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestBody Login login) {
		UserDetail isValidUser = loginService.validateUser(login);
		if (isValidUser != null) {
			return "{\"status\" : \"Logged in successfully!\"}";
		}
		else {
		return "{\"status\" : \"Login unsuccessful!\"}";
	}
	}
}