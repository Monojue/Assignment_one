package com.monojue.assignment.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.monojue.assignment.domain.Course;
import com.monojue.assignment.model.CourseModel;

public class CourseModelImpl implements CourseModel{
	
	private static final String SELECT_ALL = "Select * from course";
	private static final String INSERT = "Insert into course(name, duration, fees, description) values(?, ?, ?, ?)";
	private static final String SELECT_BYID = "Select * from course where id = ?";
	DataSource dataSource;

	public CourseModelImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<Course> getAll() {
		
		var list = new ArrayList<Course>();
		
		try(var con = dataSource.getConnection();
				var stmt = con.prepareStatement(SELECT_ALL);){
			
			
			var result = stmt.executeQuery();
			
			while(result.next()) {
				Course course = new Course();
				course.setId(result.getInt("id"));
				course.setName(result.getString("name"));
				course.setDuration(result.getInt("duration"));
				course.setFees(result.getInt("fees"));
				course.setDescription(result.getString("description"));
				
				list.add(course);
			}
		} catch (SQLException e) {
			
			System.out.println("course ->".concat(e.getMessage()));
		}
		
		return list;
	}

	@Override
	public void save(Course course) {
		try(var con = dataSource.getConnection()){
			
			var stmt = con.prepareStatement(INSERT);
			
			stmt.setString(1, course.getName());
			stmt.setInt(2, course.getDuration());
			stmt.setInt(3, course.getFees());
			stmt.setString(4, course.getDescription());
			
			stmt.executeUpdate();
			

		} catch (SQLException e) {
			System.out.println("course ->".concat(e.getMessage()));
		}
	}

	@Override
	public Course findByID(int id) {
		
		try(var con = dataSource.getConnection();
				var stmt = con.prepareStatement(SELECT_BYID);){
			
			stmt.setInt(1, id);
			var result = stmt.executeQuery();
			
			while(result.next()) {
				Course course = new Course();
				course.setId(result.getInt("id"));
				course.setName(result.getString("name"));
				course.setDuration(result.getInt("duration"));
				course.setFees(result.getInt("fees"));
				course.setDescription(result.getString("description"));
				
				return course;
			}
		} catch (SQLException e) {
			System.out.println("course ->".concat(e.getMessage()));
		}
		
		return null;
	}

}
