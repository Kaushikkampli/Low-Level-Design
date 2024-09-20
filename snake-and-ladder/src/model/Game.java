package model;

public class Game {
    private int currPlayerIndex;
    private Player winner;
    private Player[] players;

    Board board;

    public Game(Snake[] s, Ladder[] l, Player[] p) {
        this.currPlayerIndex = 0;
        this.players = p;
        this.board = new Board(s, l);
    }

    public void Play(Dice dice) {
        while (winner == null) {
            Player player = players[this.currPlayerIndex];

            int steps = dice.castDice();
            int currPos = player.getPosition();
            int dest = this.board.traverse(currPos + steps);

            if (dest <= 100)
                player.setPosition(dest);
            else
                dest = currPos;

            if (dest == board.getWinningState())
                this.winner = player;

            System.out.println(player.getName() + " rolled a " +steps+ " and moved from " +currPos+ " to " +dest);

            currPlayerIndex = (currPlayerIndex + 1) % players.length;
        }

        System.out.println(this.winner.getName() + " wins the game");
    }
}
