import java.awt.Point;

// Klassen som representerar en entitet i spelet
public class Entity {
    private Point position; // Positionen för entiteten

    // Konstruktor för att skapa en entitet med given position
    public Entity(int x, int y) {
        position = new Point(x, y);
    }

    // Metod för att flytta entiteten uppåt
    public void moveUp(Gamebox gamebox) {
        position.translate(0, -50);
    }

    // Metod för att flytta entiteten nedåt
    public void moveDown(Gamebox gamebox) {
        position.translate(0, 50);
    }

    // Metod för att flytta entiteten åt vänster
    public void moveLeft(Gamebox gamebox) {
        position.translate(-50, 0);
    }

    // Metod för att flytta entiteten åt höger
    public void moveRight(Gamebox gamebox) {
        position.translate(50, 0);
    }

    // Metod för att hämta entitetens position
    public Point getPosition() {
        return new Point(position.x, position.y);
    }

    // Metod för att flytta tillbaka till föregående position (används vid kollision)
    protected void moveBack() {
        position.translate(-position.x % 50, -position.y % 50);
    }

    // Metod för att flytta entiteten (kommer att överskuggas i subklasser)
    public void move(Gamebox gamebox) {
        // Denna metod kommer att överskuggas i subklasser
    }
}