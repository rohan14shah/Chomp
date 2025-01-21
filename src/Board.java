import java.util.Arrays;

public class Board {
    int[] cols = new int[10]; // columns in the board
    int winRow, winCol; // coordinate move I want to make

    public Board(int x, int y, int z, int a, int b, int c, int d, int e, int f, int g, int pWinRow, int pWinCol ){

        cols[0]=x;
        cols[1]=y;
        cols[2]=z;
        cols[3]=a;
        cols[4]=b;
        cols[5]=c;
        cols[6]=d;
        cols[7]=e;
        cols[8]=f;
        cols[9]=g;

        winRow= pWinRow;
        winCol= pWinCol;
    }
    public int[] getCols() {
        return cols;
    }

    public int getWinRow() {
        return winRow;
    }

    public int getWinCol() {
        return winCol;
    }

    @Override
    public String toString() {
        return "Board{" +
                "cols=" + Arrays.toString(cols) +
                ", winRow=" + winRow +
                ", winCol=" + winCol +
                '}';
    }
}

