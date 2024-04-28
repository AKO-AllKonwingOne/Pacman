// Klassen som representerar en cell på spelplanen
public class Cell {
    private final boolean isWall; // En flagga som indikerar om cellen representerar en vägg eller inte

    // Konstruktor för att skapa en cell med angivet tillstånd (vägg eller inte)
    public Cell(boolean isWall) {
        this.isWall = isWall; // Sätt det angivna tillståndet för cellen
    }

    // Metod för att kontrollera om cellen representerar en vägg
    public boolean isWall() {
        return isWall; // Returnera värdet av isWall-flaggan
    }
}