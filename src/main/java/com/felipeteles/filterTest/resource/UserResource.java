package com.felipeteles.filterTest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.felipeteles.filterTest.domain.User;
import com.felipeteles.filterTest.service.UserService;

@RestController
@RequestMapping(value="/api/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {		
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
