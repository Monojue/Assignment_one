package com.monojue.assignment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;

import com.monojue.assignment.domain.Course;
import com.monojue.assignment.listener.SpringContainerManager;
import com.monojue.assignment.model.CourseModel;

@WebServlet(urlPatterns = {
		"/",
		"/courses",
		"/course-edit"
})
public class CourseServlet extends AbstractBeanFactoryServlet{

	private static final long serialVersionUID = 1L;	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var page = switch(req.getServletPath()){
			
			case "/course-edit" -> "/course-edit.jsp";
			default -> {
				//get courses data and set
				
				var courseModel = getBean("courseModel", CourseModel.class);
				req.setAttribute("courses", courseModel.getAll());
				
				yield "/index.jsp";
			}
		};
		getServletContext().getRequestDispatcher(page).forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get req param
		var name = req.getParameter("name");
		var duration = req.getParameter("duration");
		var fees = req.getParameter("fees");
		var description = req.getParameter("description");

		//create course obj from req param
		
		Course course = new Course();
		course.setName(name);
		course.setDuration(Integer.parseInt(duration));
		course.setFees(Integer.parseInt(fees));
		course.setDescription(description);
		
		//save to db
		
		getBean("courseModel", CourseModel.class).save(course);
		
		//redirect to top page
		resp.sendRedirect("/");
	}

}
