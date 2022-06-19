package com.example.demo;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class Controller {
	
	@Autowired
	FirebaseService fbs;
	
	@GetMapping("/GetAllQuestions")
	public String getQuestions() throws InterruptedException, ExecutionException, JsonMappingException, JsonProcessingException {
		return fbs.getQuestions();
		
	}
	
	@GetMapping("/GetQuestionOptions/{id}")
	public String getOptions(@PathVariable String id) throws InterruptedException, ExecutionException {
		return fbs.getOptions(id);
		
	}
	
	@GetMapping("/GetQuestionResponse/{id}")
	public String getResponse(@PathVariable String id) throws InterruptedException, ExecutionException {
		return fbs.getResponse(id);
		
	}
	

}
