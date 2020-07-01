package com.cos.raspstreaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 어노테이션들을 모두 활성화
@SpringBootApplication
public class RaspStreamingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaspStreamingApplication.class, args);
	}

}
