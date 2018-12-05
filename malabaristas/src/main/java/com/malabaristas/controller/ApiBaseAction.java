package com.malabaristas.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.malabaristas.logic.ApiBaseLogic;

public class ApiBaseAction extends HttpServlet{
	private static final Logger LOGGER = Logger.getLogger(ApiBaseAction.class.getName());
	private ApiBaseLogic apiBaseLogic = new ApiBaseLogic();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		LOGGER.warning("Sending API request by GET is not allowed. Please use POST.");
		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		AbstractAction action;
		try {
			action = apiBaseLogic.createAction(req, resp);
		} catch (IllegalArgumentException e) {
			LOGGER.warning(e.getMessage());
			return;
		}
		action.execute();
    }
}
