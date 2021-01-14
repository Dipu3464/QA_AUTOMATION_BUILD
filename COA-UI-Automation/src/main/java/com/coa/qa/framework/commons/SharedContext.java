package com.coa.qa.framework.commons;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SharedContext {

	public RequestSpecification request;
	public Response response;
	public Map<String, Object> data = new HashMap<String, Object>();
	
}
