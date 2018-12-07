package com.lh.kamusi;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class KamusiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KamusiApplication.class, args);

		try {

			FileInputStream serviceAccount = new FileInputStream("src\\main\\resources\\google-services.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://dictionnaire-fr-com.firebaseio.com").build();

			FirebaseApp.initializeApp(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
