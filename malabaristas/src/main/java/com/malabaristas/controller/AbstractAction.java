package com.malabaristas.controller;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.malabaristas.interfaces.ApiActionInterface;
import com.malabaristas.model.AbstractModel;
/**
*
* @author ishino
* 全てのAPIリクエストはapiBaseActionで処理される。
* apiBaseActionから呼び出されるActionはこのAbstractActionをextendsする必要がある。
*
*/
public abstract class AbstractAction<M extends AbstractModel> implements ApiActionInterface<M> {
	protected static final Logger LOGGER = Logger.getLogger(AbstractAction.class.getName());
	protected HttpServletRequest req;
	protected HttpServletResponse resp;
	protected String method;
	abstract public void setUp() ;
	abstract public void execute() throws IOException;

	protected AbstractAction(@Nonnull HttpServletRequest req, @Nonnull HttpServletResponse resp, String method){
		this.req = req;
		this.resp = resp;
		this.method = method;
	}

	public String readRequestBody() {
	    try {
			return req.getReader().lines().collect(Collectors.joining("\r\n"));
		} catch (IOException e) {
			LOGGER.warning("[WARN] " + e.getMessage());
			System.exit(-1);
			return null;
		}
	}
}
