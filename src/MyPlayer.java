import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class MyPlayer {
    // the in-game board of Chips
    public Chip[][] gameBoard;
    public int[] columns;
    public ArrayList<Board> losingBoards = new ArrayList<>();
    public ArrayList<Board> winningBoards = new ArrayList<>();


    public MyPlayer() {
        columns = new int[10];


        //add the known losing board, the poison square
        losingBoards.add(new Board(1,0,0,0,0,0,0,0,0,0,0,0));


//        print10x10boards();
    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 1;
        int row = 1;

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

        for (Board winningBoard: winningBoards) {
            if (Arrays.equals(winningBoard.cols, columns)) {
                row = winningBoard.winRow;
                column = winningBoard.winCol;

            }

        }
        Point myMove = new Point(row, column);
        return myMove;
    }

//    public void print10x10boards() {
//        for(int c0=1; c0<=10; c0++){
//            for(int c1=0; c1<=10; c1++){
//                for(int c2=0; c2<=10; c2++){
//                    for(int c3=0; c3<=10; c3++){
//                        for(int c4=0; c4<=10; c4++){
//                            for(int c5=0; c5<=10; c5++){
//                                for(int c6=0; c6<=10; c6++){
//                                    for(int c7=0; c7<=10; c7++){
//                                        for(int c8=0; c8<=10; c8++){
//                                            for(int c9=0; c9<=10; c9++){
//                                                if(c0>=c1 && c1>=c2 && c2>=c3 && c3>=c4 && c4>=c5 && c5>=c6 && c6>=c7 && c7>=c8 && c8>=c9) {
//                                                    System.out.println("currentboard: " + c0 + "," + c1 + "," + c2 + "," + c3 + "," + c4 + "," + c5 + "," + c6 + "," + c7 + "," + c8 + "," + c9);
//                                                    System.out.println("resulting boards:");
//                                                    oneMove(c0, c1, c2, c3, c4, c5, c6, c7, c8, c9);
//                                                    System.out.println();
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            System.out.println();
//        }
//    }
    public void oneMove(int c0, int c1, int c2, int c3, int c4, int c5, int c6, int c7, int c8, int c9) {
        boolean isWinning = false;
        int r = 0;
        int c = 0;
        //column 9/level 1
        for (int x = c9-1; x>= 0; x--) {
                Board newBoard = new Board(c0,c1,c2,c3,c4,c5,c6,c7,c8,x,x,9);
                for (Board losingBoard : losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = x;
                        c = 9;
                        isWinning = true;
                        break;
                    }
                }

            }

        //columm 8/level 2
        for (int y = c8-1; y >=0; y--) {
            if (y < c9) {
                Board newBoard = new Board(c0, c1, c2, c3, c4, c5, c6, c7, y, y,y,8);
                for (Board losingBoard : losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = y;
                        c = 8;
                        isWinning = true;
                        break;
                    }
                }

            }
            else {
                Board newBoard = new Board(c0, c1, c2, c3, c4, c5, c6, c7, y, c9,y,8);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = y;
                        c=8;
                        isWinning = true;
                        break;
                    }


                }


            }

        }

        for (int z = c7-1; z>=0; z--) {
            if (z < c8 && z < c9) {
                Board newBoard = new Board(c0, c1, c2, c3, c4, c5, c6, z, z, z,z,7);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = z;
                        c=7;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (z < c8) {
                Board newBoard = new Board(c0, c1, c2, c3, c4, c5, c6, z, z, c9,z,7);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = z;
                        c=7;
                        isWinning = true;
                        break;
                    }

                }
            }
            else {
                Board newBoard = new Board(c0, c1, c2, c3, c4, c5, c6, z, c8, c9,z,7);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = z;
                        c=7;
                        isWinning = true;
                        break;
                    }

                }
            }
        }

        for (int a = c6-1; a>=0; a--) {
            if (a < c7 && a < c8 && a < c9) {
                Board newBoard = new Board(c0, c1, c2, c3, c4, c5, a, a, a, a,a,6);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = a;
                        c=6;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (a < c7 && a < c8) {
                Board newBoard = new Board(c0, c1, c2, c3, c4, c5, a, a, a, c9,a,6);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = a;
                        c=6;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (a < c7 ) {
                Board newBoard = new Board(c0, c1, c2, c3, c4, c5, a, a, c8, c9,a,6);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = a;
                        c=6;
                        isWinning = true;
                        break;
                    }

                }
            }
            else {
                Board newBoard = new Board(c0, c1, c2, c3, c4, c5, a, c7, c8, c9,a,6);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = a;
                        c=6;
                        isWinning = true;
                        break;
                    }

                }
            }
        }

        for (int b = c5-1; b>=0; b--) {
            if (b < c6 && b < c7 && b < c8 && b < c9) {
                Board newBoard = new Board(c0, c1, c2, c3, c4, b, b, b, b, b,b,5);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = b;
                        c=5;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (b < c6 && b < c7 && b < c8) {
                Board newBoard = new Board(c0, c1, c2, c3, c4, b, b, b, b, c9,b,5);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = b;
                        c=5;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (b < c6 && b < c7) {
                Board newBoard = new Board(c0, c1, c2, c3, c4, b, b, b, c8, c9,b,5);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = b;
                        c=5;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (b < c6) {
                Board newBoard = new Board(c0, c1, c2, c3, c4, b, b ,c7 , c8, c9,b,5);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = b;
                        c=5;
                        isWinning = true;
                        break;
                    }

                }
            }
            else {
                Board newBoard = new Board(c0, c1, c2, c3, c4, b, c6 , c7, c8, c9,b,5);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = b;
                        c=5;
                        isWinning = true;
                        break;
                    }

                }
            }
        }


        for (int d = c4-1; d>=0; d--) {
            if (d< c5 && d < c6 && d < c7 && d < c8 && d < c9) {
                Board newBoard = new Board(c0, c1, c2, c3, d, d, d, d, d, d,d,4);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = d;
                        c=4;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (d < c5 && d < c6 && d < c7 && d < c8) {
                Board newBoard = new Board(c0, c1, c2, c3, d,d, d, d,d, c9,d,4);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = d;
                        c=4;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (d < c5 && d < c6 && d < c7) {
                Board newBoard = new Board(c0, c1, c2, c3, d, d, d, d, c8, c9,d,4);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = d;
                        c=4;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (d < c5 && d < c6) {
                Board newBoard = new Board(c0, c1, c2, c3, d, d, d ,c7 , c8, c9,d,4);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = d;
                        c=4;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (d < c5) {
                Board newBoard = new Board(c0, c1, c2, c3, d, d, c6 ,c7 , c8, c9,d,4);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = d;
                        c=4;
                        isWinning = true;
                        break;
                    }

                }
            }
            else {
                Board newBoard = new Board(c0, c1, c2, c3, d, c5, c6 , c7, c8, c9,d,4);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = d;
                        c=4;
                        isWinning = true;
                        break;
                    }

                }
            }
        }
        for (int e = c3-1; e>=0; e--) {
            if (e< c4 && e< c5 && e < c6 && e < c7 && e < c8 && e < c9) {
                Board newBoard = new Board(c0, c1, c2, e, e, e, e, e, e, e,e,3);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = e;
                        c=3;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (e< c4 && e < c5 && e < c6 && e < c7 && e < c8) {
                Board newBoard = new Board(c0, c1, c2, e, e,e, e, e,e, c9,e,3);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = e;
                        c=3;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (e< c4 && e < c5 && e < c6 && e < c7) {
                Board newBoard = new Board(c0, c1, c2, e, e, e, e, e, c8, c9,e,3);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = e;
                        c=3;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (e< c4 && e < c5 && e < c6) {
                Board newBoard = new Board(c0, c1, c2, e, e, e, e ,c7 , c8, c9,e,3);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = e;
                        c=3;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (e< c4 && e < c5) {
                Board newBoard = new Board(c0, c1, c2, e, e, e, c6 ,c7 , c8, c9,e,3);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = e;
                        c=3;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (e< c4 ) {
                Board newBoard = new Board(c0, c1, c2, e, e, c5, c6 ,c7 , c8, c9,e,3);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = e;
                        c=3;
                        isWinning = true;
                        break;
                    }

                }
            }
            else {
                Board newBoard = new Board(c0, c1, c2, e, c4, c5, c6 , c7, c8, c9,e,3);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = e;
                        c=3;
                        isWinning = true;
                        break;
                    }

                }
            }
        }
        for (int g = c1-1; g>=0; g--) {
            if (g< c2 && g< c3 && g< c4 && g< c5 && g < c6 && g < c7 && g < c8 && g < c9) {
                Board newBoard = new Board(c0, g, g, g, g, g, g, g, g, g,g,1);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = g;
                        c=1;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (g< c2 && g< c3 && g< c4 && g< c5 && g < c6 && g < c7 && g < c8) {
                Board newBoard = new Board(c0, g, g, g, g,g, g, g,g, c9,g,1);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = g;
                        c=1;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (g< c2 && g< c3 && g< c4 && g< c5 && g < c6 && g < c7) {
                Board newBoard = new Board(c0,g, g, g, g, g, g, g, c8, c9,g,1);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = g;
                        c=1;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (g< c2 && g< c3 && g< c4 && g< c5 && g < c6) {
                Board newBoard = new Board(c0, g, g, g, g, g, g ,c7 , c8, c9,g,1);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = g;
                        c=1;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (g< c2 && g< c3 && g< c4 && g< c5) {
                Board newBoard = new Board(c0, g, g, g, g, g, c6 ,c7 , c8, c9,g,1);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = g;
                        c=1;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (g< c2 && g< c3 && g< c4 ) {
                Board newBoard = new Board(c0, g, g, g, g, c5, c6 ,c7 , c8, c9,g,1);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = g;
                        c=1;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (g< c2 && g< c3 ) {
                Board newBoard = new Board(c0, g, g, g, c4, c5, c6 ,c7 , c8, c9,g,1);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = g;
                        c=1;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (g< c2 ) {
                Board newBoard = new Board(c0, g, g, c3, c4, c5, c6 ,c7 , c8, c9,g,1);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = g;
                        c=1;
                        isWinning = true;
                        break;
                    }

                }
            }
            else {
                Board newBoard = new Board(c0, g, c2, c3, c4, c5, c6 , c7, c8, c9,g,1);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = g;
                        c=1;
                        isWinning = true;
                        break;
                    }

                }
            }
        }
        for (int h = c0-1; h>0; h--) {
            if (h< c1 && h< c2 && h< c3 && h< c4 && h< c5 && h < c6 && h < c7 && h < c8 && h < c9) {
                Board newBoard = new Board(h, h, h, h, h, h, h, h, h, h,h,0);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = h;
                        c=0;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (h< c1 && h< c2 && h< c3 && h< c4 && h< c5 && h < c6 && h < c7 && h < c8) {
                Board newBoard = new Board(h, h, h, h, h,h, h, h,h, c9,h,0);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = h;
                        c=0;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (h< c1 && h< c2 && h< c3 && h< c4 && h< c5 && h < c6 && h < c7) {
                Board newBoard = new Board(h,h,h,h,h,h, h,h, c8, c9,h,0);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = h;
                        c=0;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (h< c1 && h< c2 && h< c3 && h< c4 && h< c5 && h < c6) {
                Board newBoard = new Board(h, h, h, h, h, h, h ,c7 , c8, c9,h,0);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = h;
                        c=0;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (h< c1 && h< c2 && h< c3 && h< c4 && h< c5) {
                Board newBoard = new Board(h, h, h, h, h, h, c6 ,c7 , c8, c9,h,0);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = h;
                        c=0;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (h< c1 && h< c2 && h< c3 && h< c4 ) {
                Board newBoard = new Board(h, h, h, h, h, c5, c6 ,c7 , c8, c9,h,0);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = h;
                        c=0;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (h< c1 && h< c2 && h< c3) {
                Board newBoard = new Board(h, h, h, h, c4, c5, c6 ,c7 , c8, c9,h,0);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = h;
                        c=0;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (h< c1 && h< c2) {
                Board newBoard = new Board(h, h, h, c3, c4, c5, c6 ,c7 , c8, c9,h,0);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = h;
                        c=0;
                        isWinning = true;
                        break;
                    }

                }
            }
            else if (h< c1 ) {
                Board newBoard = new Board(h, h, c2, c3, c4, c5, c6 ,c7 , c8, c9,h,0);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = h;
                        c=0;
                        isWinning = true;
                        break;
                    }

                }
            }
            else {
                Board newBoard = new Board(h, c1, c2, c3, c4, c5, c6 , c7, c8, c9,h,0);
                for (Board losingBoard: losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)){
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2] + newBoard.cols[3] + newBoard.cols[4] + newBoard.cols[5] + newBoard.cols[6] + newBoard.cols[7] + newBoard.cols[8] + newBoard.cols[9]);
                        r = h;
                        c=0;
                        isWinning = true;
                        break;
                    }

                }
            }
        }




        if (isWinning) {
            winningBoards.add(new Board(c0,c1,c2,c3,c4,c5,c6,c7,c8,c9, r, c));

        }
        else {
            losingBoards.add(new Board(c0,c1,c2,c3,c4,c5,c6,c7,c8,c9, r, c));

        }
        System.out.println();
        System.out.println(losingBoards);
        System.out.println(winningBoards);


    }

}




