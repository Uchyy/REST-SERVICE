package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseIns {
	
	@PostConstruct
	public void initialize() throws IOException {
		FileInputStream serviceAccount =
			  new FileInputStream("./src/main/resources/serviceAccountKey.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
			  .setDatabaseUrl("https://myauthenticator-f0cfd-default-rtdb.europe-west1.firebasedatabase.app")
			  .build();

			FirebaseApp.initializeApp(options);
			
	}
}
