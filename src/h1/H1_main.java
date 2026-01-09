package h1;


public class H1_main {
    public static void main(String[] args) {
        Cell[] seeds = new Cell[]{new Cell(0, 4, true), new Cell(1, 1, true), new Cell(2, 2, true), new Cell(2, 3, true),
                                  new Cell(3, 1, true), new Cell(3, 2, true)};

        int  rows = 4;
        int  cols = 5;
        Grid grid = new Grid(seeds, rows, cols);

        int generations = 3;
        System.out.println("Generation 0:");
        System.out.println(grid.toDisplayString());

        for (int g = 1; g <= generations; g++) {
            grid.computeNextGen();
            System.out.println("Generation "+g+":");
            System.out.println(grid.toDisplayString());
        }
    }
}