package model;

public class Player {
    private int id;
    private String name;
    private int pos;

    public Player(int id, String  name) {
        this.id = id;
        this.name = name;
        this.pos = 0;
    }

    public int getPosition() {
        return this.pos;
    }

    public String getName() {
        return this.name;
    }

    public void setPosition(int pos) {
        this.pos = pos;
    }
}
