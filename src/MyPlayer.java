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
        print3x3boards();


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

        // add code to fill in the columns array
        // so that it represents the gameBoard in number form
        // print your columns array to show its working

        for (int c = 0; c < columns.length; c++) {
            int count = 0;
            for (int r = 0; r < gameBoard.length; r++) {
                if (gameBoard[r][c].isAlive) {
                    count++;

                }


            }
            columns[c] = count;

        }
        System.out.println(Arrays.toString(columns));


        Point myMove = new Point(row, column);
        return myMove;
    }

    public void print3x3boards() {
        //using 1 or more for loop, print all possible 3x3 or smaller board states
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                for (int k = 0; k <= 3; k ++) {
                    if (i >= j && j >= k) {
                        System.out.println(i + " " + j + " " + k);
                        oneMove(i,j,k);
                    }

                }

            }
            System.out.println();



        }

    }
    //print all boards that results from a single move
    //out of all those possible "reductions", if any is a Loser, then the current board is winner. Otherwise, that current board, itself is a loser.
    //we only know that 1,0,0 is a loser
    //for each Winner, what move should we make?
    //save all of the winners and the corresponding moves  into something
    public void oneMove(int i, int j, int k) {

        for (int x = 1; x <= 3; x++) {
            if (k > 0 && i >= j && j >= (k - x) && (k - x) >= 0) {
                System.out.println(i + " " + j + " " + (k - x));
            }

        }
        for (int y = j-1; y >= 0; y--) {

            if (y >= k) {
                System.out.println(i + " " + y + " " + k);
            }
            else {
                System.out.println(i + " " + y + " " + y);
            }


        }
        for (int z = 2; z >= 0; z--) {
            if (z >= j && j>=k) {
                System.out.println(z + " " + j + " " + k);
            }
            else {
                System.out.println(z + " " + z + " " + z);
            }


        }
        System.out.println();




        



    }



}
