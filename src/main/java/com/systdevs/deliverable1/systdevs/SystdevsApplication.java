package com.systdevs.deliverable1.systdevs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.systdevs.deliverable1.applyGame;

@SpringBootApplication
public class SystdevsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystdevsApplication.class, args);
		
		// Creating an instance of applyGame with the game name "Blackjack"
		applyGame blackJackGame = new applyGame("Blackjack");

		// Starting the Blackjack game
		blackJackGame.play();

		
	}

}
