package com.monojue.assignment.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.monojue.assignment.domain.Course;
import com.monojue.assignment.domain.OpenClass;
import com.monojue.assignment.domain.Registration;
import com.monojue.assignment.model.RegistrationModel;

public class RegistrationModelImpl implements RegistrationModel{

	private static final String SELECT_BYID = """
			Select c.id cid, name, fees, duration, description, 
			r.id rid, open_class_id, student, phone, email,
			oc.id ocid, course_id, start_date, teacher
			from registration r join open_class oc on oc.id = r.open_class_id 
			join course c on c.id = course_id where r.open_class_id = ?
			""";
	private static final String INSERT = """
			Insert into registration(open_class_id, student, phone, email)
			values(?, ?, ?, ?) 
			""";
	DataSource dataSource;
	
	public RegistrationModelImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<Registration> findById(int classId) {
		var list = new ArrayList<Registration>();
		
		try(var con = dataSource.getConnection();
				var stmt = con.prepareStatement(SELECT_BYID)){
			
			stmt.setInt(1, classId);
			var rt = stmt.executeQuery();
			
			while(rt.next()) {
				var c = new Course();
				c.setId(rt.getInt("cid"));
				c.setName(rt.getString("name"));
				c.setFees(rt.getInt("fees"));
				c.setDuration(rt.getInt("duration"));
				c.setDescription(rt.getString("description"));
				
				var oc = new OpenClass();
				oc.setCourse(c);
				oc.setId(rt.getInt("ocid"));
				oc.setStartDate(rt.getDate("start_date").toLocalDate());
				oc.setTeacher(rt.getString("teacher"));
				
				var r = new Registration();
				r.setOpenClass(oc);
				r.setId(rt.getInt("rid"));
				r.setStudent(rt.getString("student"));
				r.setPhone(rt.getString("phone"));
				r.setEmail(rt.getString("email"));
				
				list.add(r);
				
			}
			
		} catch (SQLException e) {
			System.out.println("Registration ->".concat(e.getMessage()));
		}
		
		return list;
	}

	@Override
	public void create(Registration registration) {
		try(var con = dataSource.getConnection();
				var stmt = con.prepareStatement(INSERT)){
			
			stmt.setInt(1, registration.getOpenClass().getId());
			stmt.setString(2, registration.getStudent());
			stmt.setString(3, registration.getPhone());
			stmt.setString(4, registration.getEmail());

			stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Registration ->".concat(e.getMessage()));
		}
	}

}
