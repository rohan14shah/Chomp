import java.awt.*;
import java.util.Arrays;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public MyPlayer() {
        columns = new int[10];

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
        // fill columns array with 0's
        for (int i = 0; i < columns.length; i++) {
            columns[i]=0;
        }
    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 0;
        int row = 0;

        row = 1;
        column = 1;

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        // strategy for my player to win :)
        // basic strategy is that first player wins no matter win if they go first.
        // the first move is the (1,1) creating an L position
        // from there all you do is copy the opponents' move so we keep that diagonal symmetry, and we will win no matter what.

        // add code to fill in the columns array
        // so that it represents the gameBoard in number form
        // print your columns array to show its working



        for (int c = 0; c < columns.length; c++) {
            int count = 0;
            for (int r = 0; r < gameBoard.length; r++) {
                if (gameBoard[c][r].isAlive) {
                    count++;

                }


            }
            columns[c] = count;

        }
        System.out.println(Arrays.toString(columns));


        Point myMove = new Point(row, column);
        return myMove;
    }

}
