package com.example.demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Madhura Bhave
 */
@RestController
public class CitiesController {

	private CityRepository repository;

	public CitiesController(CityRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/cities/{id}")
	public Mono<City> findById(@PathVariable String id) {
		return this.repository.findById(id);
	}

	@GetMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Object> all() {
		return this.repository.findAll()
				.filter(c -> c.getCountry().equals("USA"))
				.map(City::getName);
	}
}
