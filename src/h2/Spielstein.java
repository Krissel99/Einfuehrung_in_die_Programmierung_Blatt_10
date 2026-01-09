package h2;


public class Spielstein {
    private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        this.currentRow = indexRow;
        this.currentCol = indexCol;
        this.brett      = brett;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrenCol(int currenCol) {
        this.currentCol = currenCol;
    }

    public Spielbrett getBrett() {
        return brett;
    }

    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }

    private boolean movesOut() {
        Feld feld  = brett.getBrett()[currentRow][currentCol];
        char direc = feld.getDirection();

        int row = currentRow;
        int col = currentCol;
        switch (direc) {
            case ('U') -> row--;
            case ('D') -> row++;
            case ('L') -> col--;
            case ('R') -> col++;
        }

        int dim = brett.getDim();
        return (row < 0 || row >= dim || col < 0 || col >= dim);
    }

    public void go(int n) {
        if (n <= 0)
            return;
        for (int i = 0; i < n; i++) {
            Feld feld  = brett.getBrett()[currentRow][currentCol];
            char direc = feld.getDirection();
            if (feld.isBoese() || movesOut())
                continue;
            switch (direc) {
                case ('U') -> currentRow--;
                case ('D') -> currentRow++;
                case ('L') -> currentCol--;
                case ('R') -> currentCol++;
            }


        }
    }


    @Override
    public String toString() {
        return "Indizes ("+currentRow+","+currentCol+")";
    }
}