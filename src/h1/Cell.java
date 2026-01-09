package h1;


public class Cell {
    private int indexRow;
    private int indexCol;
    private boolean alive;
    private int numLivingNeighbors;
    private boolean isAliveNextGen;

    public Cell(int indexRow, int indexCol, boolean alive) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive    = alive;
    }

    public Cell(int indexRow, int indexCol) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
    }

    public int getIndexRow() {
        return indexRow;
    }

    public void setIndexRow(int indexRow) {
        this.indexRow = indexRow;
    }

    public int getIndexCol() {
        return indexCol;
    }

    public void setIndexCol(int indexCol) {
        this.indexCol = indexCol;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getNumLivingNeighbors() {
        return numLivingNeighbors;
    }

    public void setNumLivingNeighbors(int numLivingNeighbors) {
        this.numLivingNeighbors = numLivingNeighbors;
    }

    public boolean getIsAliveNextGen() {
        return isAliveNextGen;
    }

    public void setIsAliveNextGen(boolean isAliveNextGen) {
        this.isAliveNextGen = isAliveNextGen;
    }

    public void countLivingNeighbors(Cell[][] gridArray) {
        int rows     = gridArray.length;
        int cols     = gridArray[0].length;
        int numAlive = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int     neighborRow = getIndexRow()+i;
                int     neighborCol = getIndexCol()+j;
                boolean rowInGrid   = neighborRow >= 0 && neighborRow < rows;
                boolean colInGrid   = neighborCol >= 0 && neighborCol < cols;
                if (rowInGrid && colInGrid) {
                    if (gridArray[neighborRow][neighborCol].isAlive()) {
                        numAlive++;
                    }
                }
            }
        }
        setNumLivingNeighbors(numAlive);
        decideNextStatus();
    }

    private void decideNextStatus() {
        if (isAlive()) {
            setIsAliveNextGen(getNumLivingNeighbors() == 2 || getNumLivingNeighbors() == 3);
        } else {
            setIsAliveNextGen(getNumLivingNeighbors() == 3);
        }
    }

}