package com.site.backbrickbook;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class BackbrickbookApplication {
//	private static Logger logger = LogManager.getLogger(BackbrickbookApplication.class);
	public static void main(String[] args) {
//		logger.info("Iniciando...");
		SpringApplication.run(BackbrickbookApplication.class, args);
	}

}
