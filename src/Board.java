public class Board {
    int[] cols = new int[3]; // columns in the board
    int winRow, winCol; // coordinate move I want to make

    public Board( int x,int y, int z, int pWinRow, int pWinCol ){

        cols[0]=x;
        cols[1]=y;
        cols[2]=z;
        winRow= pWinRow;
        winCol= pWinCol;
    }
}
