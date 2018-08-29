package com.felipeteles.filterTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeteles.filterTest.domain.Log;
import com.felipeteles.filterTest.repository.LogRepository;

@Service
public class LogService {
	
	@Autowired
	private LogRepository repo;
	
	public Log insert(Log log) {
		return repo.insert(log);
	}
	
	public List<Log> findAll(){
		return repo.findAll();
	}
}
