import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Snakes & Ladders!");
        Scanner scan;

        if (args.length > 0) {
            File inputFile = new File(args[0]);
            try {
                scan = new Scanner(inputFile);
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + args[0]);
                return;
            }
        } else {
            scan = new Scanner(System.in);
        }

        // Input for snakes
        System.out.print("Enter the number of snakes: ");
        int noOfSnakes = scan.nextInt();
        scan.nextLine(); // Consume the newline
        Snake[] snakes = new Snake[noOfSnakes];

        for (int i = 0; i < noOfSnakes; i++) {
            System.out.print("Enter snake " + (i + 1) + " (head tail): ");
            String[] s = scan.nextLine().split(" ");
            snakes[i] = new Snake(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        // Input for ladders
        System.out.print("Enter the number of ladders: ");
        int noOfLadders = scan.nextInt();
        scan.nextLine(); // Consume the newline
        Ladder[] ladders = new Ladder[noOfLadders];

        for (int i = 0; i < noOfLadders; i++) {
            System.out.print("Enter ladder " + (i + 1) + " (start end): ");
            String[] s = scan.nextLine().split(" ");
            ladders[i] = new Ladder(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        // Input for players
        System.out.print("Enter the number of players: ");
        int noOfPlayers = scan.nextInt();
        scan.nextLine(); // Consume the newline
        Player[] players = new Player[noOfPlayers];

        for (int i = 0; i < noOfPlayers; i++) {
            System.out.print("Enter player " + (i + 1) + " name: ");
            String name = scan.nextLine();
            players[i] = new Player(i + 1, name); // Assuming Player constructor takes ID and name
        }

        System.out.println("All input collected. Starting the game...");

        // Start the game
        Game g = new Game(snakes, ladders, players);
        Dice d = new Dice(2);

        g.Play(d);
        scan.close();
    }
}
