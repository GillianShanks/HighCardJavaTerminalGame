import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Runner {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to High Card (two player edition)!");


        System.out.println("How many players do you have (please choose between 2 and 52)?");
        String response = input.next();

        Integer numOfPlayers;
        try{
            numOfPlayers = parseInt(response);
        } catch (NumberFormatException e) {
            numOfPlayers = null;
        }


        if (numOfPlayers == null || !(numOfPlayers >= 2 && numOfPlayers <=52 )){
            while (numOfPlayers == null || !(numOfPlayers >= 2 && numOfPlayers <=52 )){
                System.out.println("Please ensure the number is between 2 and 52. How many players?");
                response = input.next();
                try{
                    numOfPlayers = parseInt(response);
                } catch (NumberFormatException e) {
                    numOfPlayers = null;
                }
            }
        }




        ArrayList<Player> players = new ArrayList<Player>();
        for (int i = 0; i < numOfPlayers; i++) {
            String nameQuestion = String.format("What is player %s's name?", (i+1));
            System.out.println(nameQuestion);
            String name = input.next();
            Player player = new Player(name);
            players.add(player);

        }

        Game game = new Game(players);
        while (game.isDraw()){
            game.deal();

            for (int i = 0; i < numOfPlayers; i++) {
                System.out.println(players.get(i).getName() + " has:");
                System.out.println(players.get(i).getPlayerHand().getRank() + " of " + players.get(i).getPlayerHand().getSuit());
            }

            game.checkForWinner();

            if(game.isDraw()){
                System.out.println("That was a draw! Let's deal again!");
                System.out.println();
            } else {
                System.out.println("The winner is: " + game.getWinner().getName());
            }
        }

    }
}
