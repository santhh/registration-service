package com.google.swarm.microservice.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.swarm.microservice.entity.Registration;
import com.google.swarm.microservice.service.RegistrationService;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/api/registration")
public class RegistrationController {
	@Autowired
	private RegistrationService regService;
	
	@RequestMapping(value = "/{regId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<Registration>> getRegistration(@PathVariable("regId") String studentId) {
	
		Collection<Registration> reg = this.regService.findRegistrationByStudentId(studentId);
		if (reg == null) {
			return new ResponseEntity<Collection<Registration>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Registration>>(reg, HttpStatus.OK);
	}
	
}
