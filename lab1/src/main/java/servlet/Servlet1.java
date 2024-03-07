package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import crud.Lab2CrudInterface;
import entity.Entity;


@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServletConfigInterface servletConfig;
	Lab2CrudInterface lab2Crud;
	
	
	public Servlet1() {
		super();
		
		this.servletConfig = new ServletConfig();
		this.lab2Crud =  servletConfig.getCrud();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		
	    out.println("["+lab2Crud.readEntity()+"]");
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		int age = Integer.parseInt(request.getParameter("age"));
		float width = Float.parseFloat(request.getParameter("width"));
		
		lab2Crud.updateEntity(new Entity(title,age,width));
		
	}


}
