package com.malabaristas.api.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.malabaristas.dto.MemberDto.Parameter;
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
		String method = req.getParameter(Parameter.METHOD.getName());
		LOGGER.info("datastore access! method = " + method);
		if(method==null) {
			LOGGER.warning("supecify method!");
			return;
		} else if("collectMemberList".equals(method)) {
			DatastoreLogic datastoreLogic = new DatastoreLogic();
			String json = datastoreLogic.collectMemberList(resp);
			try (ServletOutputStream sos = resp.getOutputStream()){
				sos.print(json);
			} catch(IOException e) {
				LOGGER.warning("error " + e.getMessage());
				return;
			}
			return;
		} else if("addMember".equals(method)) {
			DatastoreLogic datastoreLogic = new DatastoreLogic();
			datastoreLogic.addMember(req);
			return;
		} else if ("updateMember".equals(method)){
			DatastoreLogic datastoreLogic = new DatastoreLogic();
			datastoreLogic.updateMember(req);
		} else {
			LOGGER.warning("undefiened method");
			return;
		}
    }
}
