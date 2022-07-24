package com.monojue.assignment.model;

import java.util.List;

import com.monojue.assignment.domain.Course;

public interface CourseModel {
	
	List<Course> getAll();
	void save(Course course);
	Course findByID(int courseid);
}
