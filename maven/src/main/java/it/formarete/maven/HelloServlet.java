package it.formarete.maven;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = -1646906587427909450L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getOutputStream().println("Hello world!");
	}
}
