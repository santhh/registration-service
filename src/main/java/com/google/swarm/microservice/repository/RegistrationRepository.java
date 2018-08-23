package com.google.swarm.microservice.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.google.swarm.microservice.entity.Registration;


public interface RegistrationRepository  extends Repository <Registration, Integer>{ 

	@Query("SELECT registration FROM Registration registration WHERE registration.studentId =:id")	
    public Collection<Registration> findByStudentId(@Param("id") String studentId);
}
