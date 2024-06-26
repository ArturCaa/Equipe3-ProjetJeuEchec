package ca.mv.projet.models.cases;

import ca.mv.projet.Utilities;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean estValide() {
        return x >= 0 && x < Utilities.NB_CASES_COTE && y >= 0 && y < Utilities.NB_CASES_COTE;
    }

    public int convertirEnIndex(){
        return x * Utilities.NB_CASES_COTE + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
