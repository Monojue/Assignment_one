package com.monojue.assignment.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.monojue.assignment.domain.Course;
import com.monojue.assignment.domain.OpenClass;
import com.monojue.assignment.model.CourseModel;
import com.monojue.assignment.model.OpenClassModel;

@WebServlet(urlPatterns = {
	"/classes",
	"/class-edit"
})
public class OpenClassServlet extends AbstractBeanFactoryServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var courseId = req.getParameter("courseId");
		req.setAttribute("course", getCourseFormID(courseId));
		
		var page = switch (req.getServletPath()) {
		case "/classes" ->{
			req.setAttribute("classes", getBean("openClassModel", OpenClassModel.class).findByID(Integer.parseInt(courseId)));
			yield "/classes.jsp";
		}
		default -> "/class-edit.jsp";
		};
		
		getServletContext().getRequestDispatcher(page).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//get parameter
		var courseId = req.getParameter("courseId");
		var teacher = req.getParameter("teacher");
		var start_date = req.getParameter("start_date");
		//convert to openclass object
		OpenClass oc = new OpenClass();
		oc.setCourse(getCourseFormID(courseId));
		oc.setTeacher(teacher);
		oc.setStartDate(LocalDate.parse(start_date));
		
		//save to db
		getBean("openClassModel", OpenClassModel.class).create(oc);
		
		//redirect
		resp.sendRedirect("/classes?courseId=%s".formatted(courseId));
	}
	
	private Course getCourseFormID(String id) {
		return getBean("courseModel", CourseModel.class).findByID(Integer.parseInt(id));
	}

}
