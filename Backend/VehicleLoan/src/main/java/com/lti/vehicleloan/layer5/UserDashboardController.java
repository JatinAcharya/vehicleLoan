package com.lti.vehicleloan.layer5;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.vehicleloan.layer2.LoanDetail;
import com.lti.vehicleloan.layer4.UserDashboardServiceIpml;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserDashboardController {

	@Autowired
	UserDashboardServiceIpml userDashboardService;
	
	public UserDashboardController() {
		System.out.println("User Dashboard Controller constructed");
	}
	

	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getUserbyId/{userId}")
	
	public  List<LoanDetail>getUserbyUserId(@PathVariable int userId) {
		return userDashboardService.selectUserbyUserIdService(userId);
	}
	
	
}
