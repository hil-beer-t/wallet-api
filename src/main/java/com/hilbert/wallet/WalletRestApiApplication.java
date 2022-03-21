package com.hilbert.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WalletRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletRestApiApplication.class, args);
	}

}
