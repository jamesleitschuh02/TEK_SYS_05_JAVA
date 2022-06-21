package com.springboot.web.app.service;

import java.util.List;

import com.springboot.web.app.model.Responses;

public interface ResponsesService {

	Responses createResponse(Responses response);
	
	List<Responses> getAllResponses();
	
	List<Responses> getAllResponsesById(long id);
	
	void deleteResponse(long id);
}
