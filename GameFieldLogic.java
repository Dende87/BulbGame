package de.mildslaff.gameing;

/**
 * Created by Dende on 02.08.2016.
 */
public class GameFieldLogic {

    private boolean gameField[][];

    public GameFieldLogic(int x) {
        initNewGameField(x);
    }

    private void initNewGameField(int x){
        gameField = new boolean[x][x];
    }

    public void printGameField() {

        System.out.print(" ");
        for(int i = 0;i < gameField.length;i++){
            System.out.print(i);
        }
        System.out.println();

        for(int i = 0; i < gameField.length;i++){
            System.out.print(i);
            for(int j = 0; j < gameField.length;j++){
                System.out.print(getBulbState(gameField[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }

    public String getBulbState(boolean state){

        if(state == false){
            return ".";
        }
        return "+";
    }

    public boolean isSolved() {

        for(boolean a[]:gameField){
            for(boolean fieldValue: a){
                if(fieldValue == false) return false;
            }
        }
        return true;
    }

    public void setUserInput(int userInputRow, int userInputColumn) {

        int gFL = gameField.length-1;
        gameField[userInputRow][userInputColumn] = !gameField[userInputRow][userInputColumn];

        if(userInputRow-1 < 0) {gameField[gFL][userInputColumn] = !gameField[gFL][userInputColumn];} else gameField[userInputRow-1][userInputColumn] = !gameField[userInputRow-1][userInputColumn];
        if(userInputRow+1 > gFL) {gameField[0][userInputColumn] = !gameField[0][userInputColumn];} else gameField[userInputRow+1][userInputColumn] = !gameField[userInputRow+1][userInputColumn];
        if(userInputColumn-1 < 0) {gameField[userInputRow][gFL] = !gameField[userInputRow][gFL];} else gameField[userInputRow][userInputColumn-1] = !gameField[userInputRow][userInputColumn-1];
        if(userInputColumn+1 > gFL) {gameField[userInputRow][0] = !gameField[userInputRow][0];} else gameField[userInputRow][userInputColumn+1] = !gameField[userInputRow][userInputColumn+1];

        printGameField();
    }
}
