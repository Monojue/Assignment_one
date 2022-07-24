package com.monojue.assignment.model;

import java.util.List;

import com.monojue.assignment.domain.Registration;

public interface RegistrationModel {

	List<Registration> findById(int classId);
	void create(Registration registration);
}
