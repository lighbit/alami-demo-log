package com.alami.demo.log.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.alami.demo.base.UserLog;
import com.alami.demo.log.repository.LogRepository;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	LogRepository logRepo;

	@Override
	@KafkaListener(groupId = "group_id_json", topics = "customer-log", containerFactory = "jsonKafkaListenerContainerFactory")
	public void saveLog(UserLog logEntity) {
		logRepo.save(logEntity);
	}

}
