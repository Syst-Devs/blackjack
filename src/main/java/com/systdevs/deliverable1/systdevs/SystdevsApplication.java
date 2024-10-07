package com.systdevs.deliverable1.systdevs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.systdevs.deliverable1.applyGame;

@SpringBootApplication
public class SystdevsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystdevsApplication.class, args);

		applyGame blackJackGame = new applyGame("Blackjack");
		blackJackGame.play();

		
	}

}
