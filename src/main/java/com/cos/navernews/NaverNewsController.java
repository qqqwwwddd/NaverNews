package com.cos.navernews;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@RestController
public class NaverNewsController { 
	
	private final NaverNewsRepository naverNewsRepository;
	
	@CrossOrigin // 서버는 다른 도메인의 자바스크립트 요청을 거부한다. (허용해주는 어노테이션)
	@GetMapping(value =  "/news", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<NaverNews> findAll(){
		return naverNewsRepository.mFindAll()
		.subscribeOn(Schedulers.boundedElastic());
	}
	
	@PostMapping("/news")
	public Mono<NaverNews> save(@RequestBody NaverNews naverNews){
		return naverNewsRepository.save(naverNews);
	}
}

