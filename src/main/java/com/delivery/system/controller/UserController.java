package com.delivery.system.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.system.entity.User;
import com.delivery.system.service.ParcelDeliveryService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	@Autowired
	ParcelDeliveryService service;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping(value="/login")
	public ResponseEntity<User> checkLogin(@RequestParam Map<String,String> requestParams) throws Exception{
		String userName = requestParams.get("userName");
		User userDetails = service.getUser(userName);
		return ResponseEntity.ok(userDetails);
	}
	
}
