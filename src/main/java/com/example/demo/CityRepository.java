package com.example.demo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author Madhura Bhave
 */
public interface CityRepository extends ReactiveCrudRepository<City, String> {

}
