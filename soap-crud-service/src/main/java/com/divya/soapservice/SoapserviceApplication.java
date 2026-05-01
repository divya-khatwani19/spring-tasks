package com.divya.soapservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.divya.soapservice")
public class SoapserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapserviceApplication.class, args);
	}

}
