package model;

public class Transporters {
    private int start;
    private int destination;

    public Transporters(int s, int d) {
        this.start = s;
        this.destination = d;
    }

    public int getStartPosition() {
        return this.start;
    }

    public int getDestination() {
        return this.destination;
    }
}

