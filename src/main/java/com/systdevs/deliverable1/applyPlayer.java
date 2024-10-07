package com.systdevs.deliverable1;

public class applyPlayer extends Player {

    public applyPlayer(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println(getName() + " is playing their turn.");
    }


    
}
