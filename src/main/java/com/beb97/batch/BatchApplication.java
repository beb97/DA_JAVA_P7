package com.beb97.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchApplication {

	/** Based upon :
	https://spring.io/guides/gs/batch-processing/#scratch
	 */
	public static void main(String[] args) throws Exception {
		System.exit(SpringApplication.exit(SpringApplication.run(BatchApplication.class, args)));
	}
}
