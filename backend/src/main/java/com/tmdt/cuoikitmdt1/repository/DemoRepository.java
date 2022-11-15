package com.tmdt.cuoikitmdt1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tmdt.cuoikitmdt1.model.Demo;

public interface DemoRepository extends MongoRepository<Demo, String>{
	
}
