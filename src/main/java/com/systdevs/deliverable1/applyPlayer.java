package com.systdevs.deliverable1;

// Class extends the abstract Player class
public class applyPlayer extends Player {

    // Constructor for passing name to abstract class Player.java
    public applyPlayer(String name) {
        super(name);
    }

    // Overriding the play method to inform the player of their turn
    @Override
    public void play() {
        System.out.println(getName() + " is playing their turn.");
    }
}
