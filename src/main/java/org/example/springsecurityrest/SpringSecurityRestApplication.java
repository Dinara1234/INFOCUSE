package org.example.springsecurityrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class SpringSecurityRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityRestApplication.class, args);
	}

}
