package com.cos.navernews;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;

import reactor.core.publisher.Flux;

public interface NaverNewsRepository extends ReactiveMongoRepository<NaverNews, String> {
	@Tailable
	@Query("{}") // findAll 이랑 똑같음 
	Flux<NaverNews> mFindAll();
}
