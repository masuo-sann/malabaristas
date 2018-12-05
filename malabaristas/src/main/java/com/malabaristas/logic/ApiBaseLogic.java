package com.malabaristas.logic;

import java.security.InvalidParameterException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.malabaristas.api.controller.MemberAction;
import com.malabaristas.controller.AbstractAction;

public class ApiBaseLogic {
	private static final Logger LOGGER = Logger.getLogger(ApiBaseLogic.class.getName());
	private final String _API_ = "/api/";
	private final String REGEX = "!";
	public static enum Actions {
		MEMBER("member");
		private String name;
		private Actions(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
	}

	public AbstractAction createAction(HttpServletRequest req, HttpServletResponse resp) throws IllegalArgumentException {
		String requestUri = req.getRequestURI();
		String method;
		Actions action;

		LOGGER.info("[INFO] requestUri = " + requestUri);
		if(!requestUri.startsWith(_API_)) {
			LOGGER.warning("requestURI: " + requestUri + " is invalud.");
			throw new InvalidParameterException("requestURI: " + requestUri + " is invalud.");
		}
		String[] splitUri = requestUri.substring(_API_.length()).split(REGEX);  // "/api/"を除いて!で分割
		if(2 < splitUri.length) {
			LOGGER.warning("requestURI: " + requestUri + " is invalud.");
			throw new InvalidParameterException("requestURI: " + requestUri + " is invalud.");
		} else if (splitUri.length == 1) {
			method = null;
		} else {
			method = splitUri[1];
		}
		try {
			action = Actions.valueOf(splitUri[0].toUpperCase());
		} catch (IllegalArgumentException iae) {
			LOGGER.warning("Illegal value of enum Actions: value=" + splitUri[0]);
			throw iae;
		}
		/* APIに関するクラスを追加するときはここに追加 */
		switch(action) {
		case MEMBER: return new MemberAction(req, resp, method);
		default: LOGGER.warning("Unexpected Error"); return null;
		}
	}
}
