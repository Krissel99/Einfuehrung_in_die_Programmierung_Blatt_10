package h1;


public class Grid {
    private Cell[][] gridArray;

    public Cell[][] getGridArray() {
        return this.gridArray;
    }

    public void setGridArray(Cell[][] gridArray) {
        this.gridArray = gridArray;
    }

    public Grid(Cell[] cells, int gridRows, int gridCols) {
        gridArray = new Cell[gridRows][gridCols];
        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {
                gridArray[i][j] = new Cell(i, j, false);
            }
        }
        for (Cell cell : cells) {
            int cellRow = cell.getIndexRow();
            int cellCol = cell.getIndexCol();

            if (cellRow >= 0 && cellRow < gridRows && cellCol >= 0 && cellCol < gridCols) {
                gridArray[cellRow][cellCol].setAlive(true);
            }
        }
        for (int cellRow = 0; cellRow < gridRows; cellRow++) {
            for (int cellCol = 0; cellCol < gridCols; cellCol++) {
                gridArray[cellRow][cellCol].countLivingNeighbors(gridArray);
            }
        }
    }

    public void computeNextGen() {
        int rows = getGridArray().length;
        int cols = getGridArray()[0].length;
        for (int cellRow = 0; cellRow < rows; cellRow++) {
            for (int cellCol = 0; cellCol < cols; cellCol++) {
                getGridArray()[cellRow][cellCol].countLivingNeighbors(gridArray);

            }
        }
        for (int cellRow = 0; cellRow < rows; cellRow++) {
            for (int cellCol = 0; cellCol < cols; cellCol++) {
                getGridArray()[cellRow][cellCol].setAlive(gridArray[cellRow][cellCol].getIsAliveNextGen());
            }
        }
    }

    public void computeGeneration(int n) {
        if (n <= 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            computeNextGen();
        }
    }

    public String toDisplayString() {
        StringBuilder sb   = new StringBuilder();
        int           rows = getGridArray().length;
        int           cols = getGridArray()[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                sb.append(gridArray[r][c].isAlive() ? "1 " : "0 ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}