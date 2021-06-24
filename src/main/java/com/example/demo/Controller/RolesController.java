package com.example.demo.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.service.userrolesservice;
import com.example.demo.model.userroles;
@org.springframework.web.bind.annotation.RestController
public class RolesController {

	@Autowired
	private userrolesservice service1;
	
	@PostMapping("/save-user")
	@Transactional
	 public String registeruser(@RequestBody userroles userroles)
	 {
		service1.savemyuserroles(userroles);
		return "userrole"+userroles.getUsertype()+"registered";
	 }
	
	
	
}
