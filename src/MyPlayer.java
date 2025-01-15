import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

// Plan for 10x10
// 1. create a board file, where we store array of integers, and clone the board -- so we can see if a human makes a move (we can find the difference in coordinates and make a move based on that)
// 2. create a possibles method that finds all the possible boards in 10x10
// 3. then make a losing method that takes input from the possible boards methods and finds all the losing boards
// 4. need a method that changes the 2d array into an array of integers for the current board state
// 5. need a best move method that chooses the best move based on if it matches a losing board or if there is no other possibility then pick like the top right one
// 6. create a possible moves method that finds the best moves from a given board -- needs to work hand in hand with best move method
// 7. then we have to move function that we may need to change based on inputs/


public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    public ArrayList<Board> losingBoards = new ArrayList<>();
    public ArrayList<Board> winningBoards = new ArrayList<>();

    public MyPlayer() {
        columns = new int[10];
        //add the known losing board, the poison square
        losingBoards.add(new Board(1,0,0,0,0));

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
        print3x3boards();


        // fill columns array with 0's

//        for (int i = 0; i < columns.length; i++) {
//            columns[i]=0;
//        }
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
                        System.out.println("currentboard: " + i + ", " + j + ", " + k);
                        System.out.println("resulting boards:");
                        oneMove(i, j, k);

                    }

                }

            }
            System.out.println();



        }

    }
    //out of all those possible "reductions", if any is a Loser, then the current board is winner. Otherwise, that current board, itself is a loser.
    //we only know that 1,0,0 is a loser
    //for each Winner, what move should we make?
    //save all of the winners and the corresponding moves  into something
    public void oneMove(int i, int j, int k) {
        boolean isWinning = false;

        for (int x = 1; x <= 3; x++) {
            if (k > 0 && i >= j && j >= (k - x) && (k - x) >= 0) {
                Board newBoard = new Board(i, j, (k - x), i, j);
                System.out.println(i + " " + j + " " + (k - x));
                for (Board losingBoard : losingBoards) {
                    int r =0;
                    if (newBoard.cols == losingBoards.get(r).cols){
                        isWinning = true;
                        winningBoards.add(new Board(i,j,(k-x),i,j));
                        r++;
                        break;
                    }
                }


            }

        }
        for (int y = j-1; y >= 0; y--) {

            if (y >= k) {
                Board newBoard = new Board(i, y, k, i, y);
                System.out.println(i + " " + y + " " + k);
                for (Board losingBoard : losingBoards) {
                    int r =0;
                    if (newBoard.cols == losingBoards.get(r).cols){
                        winningBoards.add(new Board(i, y, k, i, y));
                        isWinning = true;
                        r++;
                        break;
                    }
                }

            }
            else {
                Board newBoard = new Board(i, y, y, i, y);
                System.out.println(i + " " + y + " " + y);
            }

        }
        for (int z = 2; z >= 0; z--) {
            if (z >= j && j>=k) {
                Board newBoard = new Board(z, j, k, z, j);
                System.out.println(z + " " + j + " " + k);
                for (Board losingBoard : losingBoards) {
                    int r =0;
                    if (newBoard.cols == losingBoards.get(r).cols){
                        winningBoards.add(new Board(z, j, k, z, j));
                        isWinning = true;
                        r++;
                        break;
                    }
                }


            }
            else {
                Board newBoard = new Board(z, z, z, z, z);
                System.out.println(z + " " + z + " " + z);
                for (Board losingBoard : losingBoards) {
                    int r =0;
                    if (newBoard.cols == losingBoards.get(r).cols){
                        winningBoards.add(new Board(z, z, z, z, z));
                        isWinning = true;
                        r++;
                        break;
                    }
                }

            }

        }
        if (!isWinning) {
            losingBoards.add(new Board(i,j,k,0,0));
        }
        System.out.println();
        System.out.println(losingBoards);
        System.out.println(winningBoards);


    }



}
