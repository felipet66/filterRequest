package com.felipeteles.filterTest.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felipeteles.filterTest.domain.Log;
import com.felipeteles.filterTest.service.LogService;

@RestController
@RequestMapping(value="/api/log")
public class LogResource {
	
	@Autowired
	private LogService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Log>> findAll() {		
		List<Log> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Log log) {
		log = service.insert(log);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(log.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
