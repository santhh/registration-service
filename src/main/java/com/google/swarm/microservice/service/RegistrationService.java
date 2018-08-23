package com.google.swarm.microservice.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.swarm.microservice.entity.Registration;
import com.google.swarm.microservice.repository.RegistrationRepository;



@Service
public class RegistrationService {
	
	static private final Logger logger = LoggerFactory.getLogger(RegistrationService.class);
	@Autowired
	private RegistrationRepository regRepository;
	
	   
	   @Transactional(readOnly = true)
		public Collection<Registration> findRegistrationByStudentId(String studentId) throws DataAccessException {
		   Collection<Registration> reg = null;
			try {
				reg = regRepository.findByStudentId(studentId);
			} catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
				
				logger.error(e.toString());
				return null;
			}
			return reg;
		}

}
