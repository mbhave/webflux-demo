package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner initData(MongoOperations mongo) {
		return (String... args) -> {
			mongo.dropCollection(City.class);
			mongo.createCollection(City.class, CollectionOptions.empty().size(1000000).capped());

			mongo.save(new City("San Francisco", "USA"));
			mongo.save(new City("London", "England"));
			mongo.save(new City("Paris", "France"));
			mongo.save(new City("Rome", "Italy"));
			mongo.save(new City("Chicago", "USA"));
			mongo.save(new City("Madrid", "Spain"));
			mongo.save(new City("New York", "USA"));
			mongo.save(new City("Seattle", "USA"));
			mongo.save(new City("Tokyo", "Japan"));
			mongo.save(new City("New Delhi", "India"));
			mongo.save(new City("Las Vegas", "USA"));
		};
	}

}
