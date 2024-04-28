import java.util.Random;

// Klassen som representerar spelplanen
public class Gamebox {
    private final Cell[][] grid; // En tvådimensionell array av celler för att representera spelplanen

    // Konstruktor för att skapa spelplanen med givet antal rader och kolumner
    public Gamebox(int rows, int cols) {
        grid = new Cell[rows][cols]; // Skapa en ny spelplan med angiven storlek
        initializeGrid(); // Initialisera spelplanen med celler
    }

    // Privat metod för att initialisera spelplanen med celler
    private void initializeGrid() {
        Random random = new Random(); // Skapa ett Random-objekt för att slumpmässigt bestämma cellernas tillstånd
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // Slumpmässigt bestämma om cellen ska vara en vägg baserat på en sannolikhetsfaktor
                grid[i][j] = new Cell(random.nextFloat() < 0.3);
            }
        }
    }

    // Metod för att hämta en specifik cell på spelplanen med given rad och kolumn
    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    // Metod för att hämta antalet rader på spelplanen
    public int getRows() {
        return grid.length;
    }

    // Metod för att hämta antalet kolumner på spelplanen (antalet kolumner för varje rad är samma)
    public int getCols() {
        return grid[0].length;
    }
}