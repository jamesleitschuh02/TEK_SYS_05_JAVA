package com.springboot.web.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.app.exception.ResourceNotFoundException;
import com.springboot.web.app.model.Responses;
import com.springboot.web.app.repository.ResponsesRepository;
import com.springboot.web.app.service.ResponsesService;

@Service
public class ResponsesServiceImpl implements ResponsesService {
	
	@Autowired
	private ResponsesRepository responsesRepo;

	@Override
	public Responses createResponse(Responses response) {
		return responsesRepo.save(response);
	}

	@Override
	public List<Responses> getAllResponses() {
		return responsesRepo.findAll();
	}
	
	@Override
	public List<Responses> getAllResponsesById(long id) {
		return responsesRepo.findAllResponsesById(id);
	}

	@Override
	public void deleteResponse(long id) {
		responsesRepo.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("User", "Id", id));
		responsesRepo.deleteById(id);
		
	}

}
