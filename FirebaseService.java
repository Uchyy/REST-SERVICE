package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import objects.Answer;
import objects.Option;
import objects.Question;

@Component
public class FirebaseService {
	
	
	public String getQuestions () throws InterruptedException, ExecutionException, JsonMappingException, JsonProcessingException {
		
		List <Question> que = new ArrayList<Question>();
		
		Firestore fstore = FirestoreClient.getFirestore();
		
		ApiFuture<QuerySnapshot> future = fstore.collection("Consultations").get();
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {
				
			if (document.exists()) {
				Question question = document.toObject(Question.class);
				que.add(question);
			} 
			
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String results = "{\n\"consultations\":{\n\"Questions\":" + gson.toJson(que) + "\n}\n}";
	
		return results;	
	}
	
	public String getOptions(String id) throws InterruptedException, ExecutionException {
		
		List <Option> opt = new ArrayList<Option>();
		
		Firestore fstore = FirestoreClient.getFirestore();
		
		ApiFuture<QuerySnapshot> future = fstore.collection("Consultations").document(id).collection("Options").get();
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {
				
			if (document.exists()) {
				Option option = document.toObject(Option.class);
				opt.add(option);
			} 
			
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String results = "{\n\"Question\": \"" +id+"\",\n\"Options\":" + gson.toJson(opt) + "\n}";
		
		return results;
	
	}
	
	public String getResponse(String id) throws InterruptedException, ExecutionException {
		
		List <Answer> ans = new ArrayList<Answer>();
		
		Firestore fstore = FirestoreClient.getFirestore();
		
		ApiFuture<QuerySnapshot> future = fstore.collection("Consultations").document(id).collection("Answers").get();
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {
				
			if (document.exists()) {
				Answer answer = document.toObject(Answer.class);
				ans.add(answer);
			} 
			
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String results = "{\n\"Question\": \"" +id+"\",\n\"Answers\":" + gson.toJson(ans) + "\n}";
		
		return results;		
	
	}

}
