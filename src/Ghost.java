import java.util.Random;

public class Ghost {
    private int row;
    private int col;

    public Ghost(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void move(Gamebox gamebox) {
        Random random = new Random();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int newDirection = random.nextInt(4); // 0: up, 1: down, 2: left, 3: right

        int newRow = row + dx[newDirection];
        int newCol = col + dy[newDirection];

        if (isValidMove(gamebox, newRow, newCol)) {
            row = newRow;
            col = newCol;
        }
    }

    private boolean isValidMove(Gamebox gamebox, int row, int col) {
        return row >= 0 && row < gamebox.getRows() && col >= 0 && col < gamebox.getCols() &&
                !gamebox.getCell(row, col).isWall();
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}