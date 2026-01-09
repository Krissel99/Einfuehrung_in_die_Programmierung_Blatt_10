package h2;


public class Spielbrett {
    private Feld[][] brett;
    private int dim;

    public Feld[][] getBrett() {
        return brett;
    }

    public void setBrett(Feld[][] brett) {
        this.brett = brett;
    }

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    public Spielbrett(int dim) {
        this.dim   = dim;
        this.brett = new Feld[dim][dim];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Spielbrett{dim=").append(dim).append(", brett=\n");
        for (int r = 0; r < dim; r++) {
            sb.append("[");
            for (int c = 0; c < dim; c++) {
                Feld f = brett[r][c];
                sb.append(f == null ? "null" : f.getDirection()).append(f != null && f.isBoese() ? "*" : " ");
                if (c < dim-1)
                    sb.append("|");
            }
            sb.append("]");
            if (r < dim-1)
                sb.append("\n");
        }
        sb.append("\n}");
        return sb.toString();
    }
}