import java.awt.Point;

// Klassen som representerar Pacman, ärver från Entity
public class Pacman extends Entity {
    // Konstruktor för att skapa en Pacman med given position
    public Pacman(int x, int y) {
        super(x, y);
    }

    // Metod för att flytta Pacman uppåt om möjligt
    @Override
    public void moveUp(Gamebox gamebox) {
        if (canMoveUp(gamebox)) {
            super.moveUp(gamebox);
        }
    }

    // Metod för att flytta Pacman nedåt om möjligt
    @Override
    public void moveDown(Gamebox gamebox) {
        if (canMoveDown(gamebox)) {
            super.moveDown(gamebox);
        }
    }

    // Metod för att flytta Pacman åt vänster om möjligt
    @Override
    public void moveLeft(Gamebox gamebox) {
        if (canMoveLeft(gamebox)) {
            super.moveLeft(gamebox);
        }
    }

    // Metod för att flytta Pacman åt höger om möjligt
    @Override
    public void moveRight(Gamebox gamebox) {
        if (canMoveRight(gamebox)) {
            super.moveRight(gamebox);
        }
    }

    // Privat metod för att kontrollera om Pacman kan flyttas uppåt
    private boolean canMoveUp(Gamebox gamebox) {
        Point nextPosition = new Point(getPosition().x, getPosition().y - 50);
        return isValidPosition(gamebox, nextPosition);
    }

    // Privat metod för att kontrollera om Pacman kan flyttas nedåt
    private boolean canMoveDown(Gamebox gamebox) {
        Point nextPosition = new Point(getPosition().x, getPosition().y + 50);
        return isValidPosition(gamebox, nextPosition);
    }

    // Privat metod för att kontrollera om Pacman kan flyttas åt vänster
    private boolean canMoveLeft(Gamebox gamebox) {
        Point nextPosition = new Point(getPosition().x - 50, getPosition().y);
        return isValidPosition(gamebox, nextPosition);
    }

    // Privat metod för att kontrollera om Pacman kan flyttas åt höger
    private boolean canMoveRight(Gamebox gamebox) {
        Point nextPosition = new Point(getPosition().x + 50, getPosition().y);
        return isValidPosition(gamebox, nextPosition);
    }

    // Privat metod för att kontrollera om en position är giltig för Pacman
    private boolean isValidPosition(Gamebox gamebox, Point position) {
        int row = position.y / 50;
        int col = position.x / 50;
        return row >= 0 && row < gamebox.getRows() && col >= 0 && col < gamebox.getCols() &&
                !gamebox.getCell(row, col).isWall();
    }
}