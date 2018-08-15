package com.malabaristas.api.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.malabaristas.logic.DatastoreLogic;

public class DatastoreAction extends HttpServlet{
	private static final Logger LOGGER = Logger.getLogger(DatastoreAction.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("hello world!(Servlet)");
    }

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		LOGGER.info("datastore access");
		if(req.getParameter("method")==null) {
			LOGGER.warning("supecify method!");
			return;
		} else if("addMember".equals(req.getParameter("method"))) {
			DatastoreLogic datastoreLogic = new DatastoreLogic();
			datastoreLogic.addMember(req);
			return;
		} else {
			LOGGER.warning("undefiened method");
			return;
		}
    }
}
