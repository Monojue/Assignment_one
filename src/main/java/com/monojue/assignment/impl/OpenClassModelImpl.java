package com.monojue.assignment.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.monojue.assignment.domain.Course;
import com.monojue.assignment.domain.OpenClass;
import com.monojue.assignment.model.OpenClassModel;

public class OpenClassModelImpl implements OpenClassModel {

	private static final String SELECTALLWITHID = """
			Select oc.id ocID, oc.course_id, oc.start_date, oc.teacher,
			c.id cID, c.name, c.duration, c.fees, c.description 
			from open_class oc join course c on oc.course_id = c.id 
			where c.id = ?
			""";
	private static final String INSERT = "Insert into open_class(course_id, start_date, teacher) values(?, ?, ?)";
	private static final String SELECT_ONEBYID = """
			Select oc.id ocID, oc.course_id, oc.start_date, oc.teacher,
			c.id cID, c.name, c.duration, c.fees, c.description 
			from open_class oc join course c on oc.course_id = c.id 
			where oc.id = ?
			""";
	DataSource dataSource;
	
	public OpenClassModelImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<OpenClass> findByID(int courseID) {
		
		var list = new ArrayList<OpenClass>();
		try(var con = dataSource.getConnection();
				var stmt = con.prepareStatement(SELECTALLWITHID);){
			
			stmt.setInt(1, courseID);
			var result = stmt.executeQuery();
			
			while(result.next()) {
				var c = new Course();
				var oc = new OpenClass();
				
				c.setId(result.getInt("cID"));
				c.setName(result.getString("name"));
				c.setDuration(result.getInt("duration"));
				c.setFees(result.getInt("fees"));
				c.setDescription(result.getString("description"));
				
				oc.setId(result.getInt("ocID"));
				oc.setCourse(c);
				oc.setTeacher(result.getString("teacher"));
				oc.setStartDate(result.getDate("start_date").toLocalDate());
				
				list.add(oc);
			}
			
		} catch (SQLException e) {
			System.out.println("OpenClassfindByID ->".concat(e.getMessage()));
		}
		
		return list;
	}

	@Override
	public void create(OpenClass openClass) {
		try(var con = dataSource.getConnection();
				var stmt = con.prepareStatement(INSERT);){
			
			stmt.setInt(1, openClass.getCourse().getId());
			stmt.setString(2, openClass.getStartDate().toString());
			stmt.setString(3, openClass.getTeacher());
			
			var no = stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("OpenClasscreate ->".concat(e.getMessage()));
		}

	}

	@Override
	public OpenClass findOpenClassByID(int openClassID) {
		var c = new Course();
		var oc = new OpenClass();
		try(var con = dataSource.getConnection();
				var stmt = con.prepareStatement(SELECT_ONEBYID);){
			
			stmt.setInt(1, openClassID);
			
			var rt = stmt.executeQuery();
			while(rt.next()) {
				c.setId(rt.getInt("cID"));
				c.setName(rt.getString("name"));
				c.setDuration(rt.getInt("duration"));
				c.setFees(rt.getInt("fees"));
				c.setDescription(rt.getString("description"));
				
				oc.setId(rt.getInt("ocID"));
				oc.setCourse(c);
				oc.setStartDate(rt.getDate("start_date").toLocalDate());
				oc.setTeacher(rt.getString("teacher"));
			}
	
		} catch (SQLException e) {
			System.out.println("OpenClassfindOpenClassByID ->".concat(e.getMessage()));
		}
		
		return oc;
	}
		

}
