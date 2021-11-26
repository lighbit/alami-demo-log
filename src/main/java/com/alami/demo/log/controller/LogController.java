package com.alami.demo.log.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alami.demo.base.UserLog;
import com.alami.demo.log.repository.LogRepository;
import com.alami.demo.log.service.LogService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/v1/log")
public class LogController {

	@Autowired
	LogService logService;

	@Autowired
	LogRepository logRepo;

	@GetMapping("/all")
	public @ResponseBody List<UserLog> findAll() {
		List<UserLog> list = logRepo.findAll();

		return list;
	}

	@GetMapping("/all/{agentId}")
	public @ResponseBody List<UserLog> findByAgentId(@PathVariable("agentId") String id) {

		List<UserLog> list = logRepo.findByAgentid(id);

		return list;
	}

	@GetMapping("/{agentId}")
	public @ResponseBody UserLog findByID(@PathVariable("agentId") String id) {

		return logRepo.findById(id).get();
	}

}
