package com.monojue.assignment.model;

import java.util.List;

import com.monojue.assignment.domain.OpenClass;

public interface OpenClassModel {

	List<OpenClass> findByID(int courseID);
	void create(OpenClass openClass);
	OpenClass findOpenClassByID(int openClassID);
}
