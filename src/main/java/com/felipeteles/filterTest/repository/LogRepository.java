package com.felipeteles.filterTest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.felipeteles.filterTest.domain.Log;

public interface LogRepository extends MongoRepository<Log, String>{

}
