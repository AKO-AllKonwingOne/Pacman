import java.awt.Point;
import java.util.Random;

// Klassen som representerar spöket, ärver från Entity
public class Ghost extends Entity {
    // Konstruktor för att skapa ett spöke med given position
    public Ghost(int x, int y) {
        super(x, y);
    }

    // Metod för att flytta spöket och hantera kollisioner
    @Override
    public void move(Gamebox gamebox) {
        super.move(gamebox); // Flytta spöket
        handleCollision(gamebox); // Hantera kollisioner efter flytten
    }

    // Privat metod för att hantera kollisioner
    private void handleCollision(Gamebox gamebox) {
        // Kontrollera om spöket kolliderar med en vägg
        if (gamebox.getCell(getPosition().x / 50, getPosition().y / 50).isWall()) {
            // Spöket kolliderade med en vägg, flytta tillbaka till föregående position
            super.moveBack();
        }
    }
}