package de.mildslaff.gameing;

import java.util.Scanner;

/**
 * Created by Dende on 02.08.2016.
 */
public class BulbGame extends GameFieldLogic{

    public BulbGame(int x) {
        super(x);
    }

    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        int userInputFieldSize = 0;

        System.out.print("Bitte Feldgroeße angeben n(2 < n < 10): ");
        userInputFieldSize = scanner.nextInt();

        while(userInputFieldSize < 2 || userInputFieldSize >= 10){
            System.out.print("Fehlerhafte eingabe, Bitte Feldgroeße angeben n(2 < n < 10): ");
            userInputFieldSize = scanner.nextInt();
        }

        System.out.println();

        BulbGame bulbGame = new BulbGame(userInputFieldSize);
        bulbGame.printGameField();

        while(!bulbGame.isSolved()){

            System.out.print("Bitte Reihe eingeben(0-" + (userInputFieldSize-1) + "): ");
            int userInputRow = scanner.nextInt();

            while(userInputRow < 0 || userInputRow >= userInputFieldSize){
                System.out.print("Fehlerhafte eingabe,Bitte Reihe eingeben(0-" + (userInputFieldSize-1) + "): ");
                userInputRow = scanner.nextInt();
            }

            System.out.print("Bitte Spalte eingeben(0-" + (userInputFieldSize-1) + "): ");
            int userInputColumn = scanner.nextInt();

            while(userInputColumn < 0 || userInputColumn >= userInputFieldSize){
                System.out.print("Fehlerhafte eingabe,Bitte Spalte eingeben(0-" + (userInputFieldSize-1) + "): ");
                userInputColumn = scanner.nextInt();
            }

            System.out.println();

            bulbGame.setUserInput(userInputRow,userInputColumn);

        }

        System.out.println("Winner Winner Chicken Dinner!");

    }
}
