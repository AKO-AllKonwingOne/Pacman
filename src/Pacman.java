public class Pacman {
    private int row;
    private int col;

    public Pacman(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void moveUp() {
        row--;
    }

    public void moveDown() {
        row++;
    }

    public void moveLeft() {
        col--;
    }

    public void moveRight() {
        col++;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}