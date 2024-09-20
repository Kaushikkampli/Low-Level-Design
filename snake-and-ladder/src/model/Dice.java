package model;

import java.util.Random;

public class Dice {
    private int diceInUse;

    public Dice(int n) {
        this.diceInUse = n;
    }

    public int castDice() {
        Random rand = new Random();
        return rand.nextInt(1, 7) + rand.nextInt(1, 7);
    }
}
