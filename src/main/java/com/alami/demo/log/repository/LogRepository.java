package com.alami.demo.log.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.alami.demo.base.UserLog;

@Repository
public interface LogRepository extends MongoRepository<UserLog, String> {
	
	List<UserLog> findByAgentid(String agentId);

}
