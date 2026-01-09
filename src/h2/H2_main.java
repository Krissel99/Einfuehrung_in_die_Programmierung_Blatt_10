package h2;

public class H2_main {
    public static void main(String[] args) {
        runBoard(board3(), 7, 2, 2);
    }

    private static void board5x5(int numSteps, int startRow, int startCol) {

        System.out.println("Szenario 5x5 (Start ("+startRow+","+startCol+"), "+numSteps+" Schritte):");
        Spielbrett b = new Spielbrett(5);
        char[][] dirs = {{'U', 'R', 'L', 'L', 'D'}, {'L', 'R', 'L', 'L', 'D'}, {'U', 'L', 'L', 'L', 'R'}, {'D', 'R', 'U', 'L', 'L'},
                         {'U', 'R', 'L', 'D', 'D'}};
        boolean[][] boese = new boolean[5][5]; // alles false

        brettBefuellen(b, dirs, boese);
        Spielstein s = new Spielstein(b, startRow, startCol);

        ausgabe(numSteps, s);
    }


    private static Layout board3() {
        int         dim       = 3;
        char[][]    dirs      = {{'L', 'R', 'L'}, {'L', 'R', 'U'}, {'L', 'U', 'U'}};
        boolean[][] boese     = {{false, true, false}, {false, true, false}, {false, false, false}};
        Layout      testBoard = new Layout(dim, dirs, boese);
        return testBoard;
    }

    private static void board3x3(int numSteps, int startRow, int startCol) {

        Spielbrett  b     = new Spielbrett(3);
        char[][]    dirs  = {{'L', 'R', 'L'}, {'L', 'R', 'U'}, {'L', 'U', 'U'}};
        boolean[][] boese = {{false, true, false}, {false, true, false}, {false, false, false}};


        brettBefuellen(b, dirs, boese);

        Spielstein s = new Spielstein(b, startRow, startCol);

        ausgabe(numSteps, s);
    }

    private static void ausgabe(int numSteps, Spielstein s) {
        System.out.println("Der Spielstein startet auf dem Feld mit dem "+s); // Spielstein{row=2, col=2}

        System.out.println("\nWird nun go("+numSteps+") aufgerufen, dann steht der Spielstein nach dem");
        for (int i = 1; i <= numSteps; i++) {
            s.go(1);
            System.out.println(i+". Schritt auf dem Feld mit "+s);
        }

    }

    private static void brettBefuellen(Spielbrett b, char[][] dirs, boolean[][] boese) {
        for (int r = 0; r < dirs.length; r++) {
            for (int c = 0; c < dirs[r].length; c++) {
                b.getBrett()[r][c] = new Feld(boese[r][c], dirs[r][c]);
            }
        }

    }

    private static void runBoard(Layout bordLayout, int numSteps, int startRow, int startCol) {

        Spielbrett b = new Spielbrett(bordLayout.dim);

        brettBefuellen(b, bordLayout.dirs, bordLayout.boese);

        Spielstein s = new Spielstein(b, startRow, startCol);

        ausgabe(numSteps, s);

    }
}