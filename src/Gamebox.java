import java.util.Random;

public class Gamebox {
    private final Cell[][] grid;

    public Gamebox(int rows, int cols) {
        grid = new Cell[rows][cols];
        initializeGrid();
    }

    private void initializeGrid() {
        Random random = new Random();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Cell(random.nextFloat() < 0.3);
            }
        }
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public int getRows() {
        return grid.length;
    }

    public int getCols() {
        return grid[0].length;
    }
}