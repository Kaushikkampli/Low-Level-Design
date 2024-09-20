package model;

import java.util.HashMap;

public class Board {
    private int winningState;

    private Snake[] snakes;
    private Ladder[] ladders;
    private HashMap<Integer, Transporters> transports;


    public Board(Snake[] snakes, Ladder[] ladders) {
        this.winningState = 100;
        transports = new HashMap<>();

        this.snakes = snakes;
        this.ladders = ladders;

        for(Snake s: snakes) {
            transports.put(s.getStartPosition(), s);
        }

        for(Ladder l: ladders) {
            transports.put(l.getStartPosition(), l);
        }
    }

    public boolean isSnakeOrLadder(int pos) {
        return transports.containsKey(pos);
    }

    public Transporters getTransporter(int pos) {
        return transports.get(pos);
    }

    public int getWinningState() {
        return this.winningState;
    }

    public int traverse(int pos) {
        while (isSnakeOrLadder(pos)) {
            Transporters t = getTransporter(pos);
            pos = t.getDestination();
        }

        return pos;
    }
}
