package com.postman.assignment.assignmentbackend;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class AssignmentBackendApplication extends SpringBootServletInitializer {

	@Autowired
	ResourceLoader resourceLoader;

	@Value("${firebase.sdk.jsonpath}")
	private String fireBaseSDKPath;

	@Value("${firebase.auth.url}")
	private String fireBaseURL;

	public static void main(String[] args) {
		SpringApplication.run(AssignmentBackendApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AssignmentBackendApplication.class);
	}

	@Bean
	public FirebaseAuth firebaseAuth() throws IOException {
		FileInputStream serviceAccount = new FileInputStream(fireBaseSDKPath );
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl(fireBaseURL).build();
		FirebaseApp.initializeApp(options);
		return FirebaseAuth.getInstance();
	}

}
