package com.monojue.assignment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.views.AbstractView;

import com.monojue.assignment.domain.Registration;
import com.monojue.assignment.model.CourseModel;
import com.monojue.assignment.model.OpenClassModel;
import com.monojue.assignment.model.RegistrationModel;

@WebServlet(urlPatterns = {
		"/registration",
		"/registration-edit"
})
public class RegistrationServlet extends AbstractBeanFactoryServlet  {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var classId = req.getParameter("classId");
		var courseId = req.getParameter("courseId");
		var course = getBean("courseModel", CourseModel.class).findByID(Integer.parseInt(courseId));
		req.setAttribute("course", course);
		var openClass = getBean("openClassModel", OpenClassModel.class).findOpenClassByID(Integer.parseInt(classId));
		req.setAttribute("openClass", openClass);
		var page = switch(req.getServletPath()) {
		
		case "/registration" -> {

			var registration = getBean("registrationModel", RegistrationModel.class).findById(Integer.parseInt(classId));
			req.setAttribute("registration", registration);
			yield "/registration.jsp";
		}
		default -> "/registration-edit.jsp";
		};
		
		getServletContext().getRequestDispatcher(page).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var name = req.getParameter("name");
		var ph = req.getParameter("phone");
		var email = req.getParameter("email");
		
		var classId = req.getParameter("classId");
		var courseId = req.getParameter("courseId");
		
		var reg = new Registration();
		reg.setStudent(name);
		reg.setPhone(ph);
		reg.setEmail(email);
		reg.setOpenClass(getBean("openClassModel", OpenClassModel.class).findOpenClassByID(Integer.parseInt(classId)));
		
		getBean("registrationModel", RegistrationModel.class).create(reg);
		
		resp.sendRedirect(req.getServletPath().concat("?courseId=%s&classId=%s").formatted(courseId, classId));
	}

}
