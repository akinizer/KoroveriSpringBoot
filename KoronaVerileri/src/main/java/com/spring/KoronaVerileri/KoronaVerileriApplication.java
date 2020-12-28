package com.spring.KoronaVerileri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import java.sql.Date;

import org.bson.Document;

@SpringBootApplication
public class KoronaVerileriApplication {

	public static void main(String[] args) {
		SpringApplication.run(KoronaVerileriApplication.class, args); //SPRING OPERATIONS		
	}

}
