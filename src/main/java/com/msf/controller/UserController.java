package com.msf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msf.models.User;
import com.msf.responses.APIResponse;
import com.msf.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping(value="/create")
	public ResponseEntity<APIResponse> createUser(@RequestBody User user) {
	    userService.createUser(user);
        return new ResponseEntity<>(new APIResponse(true, "a new user created"), HttpStatus.CREATED);
    }
}
