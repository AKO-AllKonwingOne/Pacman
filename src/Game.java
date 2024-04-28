import java.awt.Point;
import java.awt.Rectangle;
import java.util.Scanner;

// Huvudklassen som hanterar spelet
public class Game {
    private final Rectangle gameArea; // Spelområdet
    private final Pacman pacman; // Pacman-objektet
    private final Ghost ghost; // Spöket-objektet
    private final Gamebox gamebox; // Spelplanen
    private final Point goalPosition; // Målet position

    // Konstruktör för att skapa ett nytt spel
    public Game() {
        final int rows = 10;
        final int columns = 10;
        final int cellSize = 50; // Storleken på varje cell i pixlar

        gameArea = new Rectangle(columns * cellSize, rows * cellSize);
        gamebox = new Gamebox(rows, columns);
        pacman = new Pacman(0, 0);
        ghost = new Ghost(0, 0);

        // Ställ in en slumpmässig målposition som skiljer sig från Pacmans och spökets positioner
        Point tempGoalPosition;
        do {
            tempGoalPosition = new Point((int) (Math.random() * 10) * 50, (int) (Math.random() * 10) * 50);
        } while (tempGoalPosition.equals(pacman.getPosition()) || tempGoalPosition.equals(ghost.getPosition()));
        goalPosition = tempGoalPosition;

        play(); // Starta spelet
    }

    // Metod som hanterar spelet
    private void play() {
        System.out.println("Välkommen till Pacman!");
        System.out.println("Regler:");
        System.out.println("- Använd WASD-tangenterna för att flytta Pacman.");
        System.out.println("- Nå målpositionen för att vinna spelet.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayGameboard(); // Visa spelplanen
            System.out.print("Ange ditt drag (WASD): ");
            String dragning = scanner.next().toLowerCase();

            switch (dragning) {
                case "w":
                    pacman.moveUp(gamebox);
                    break;
                case "a":
                    pacman.moveLeft(gamebox);
                    break;
                case "s":
                    pacman.moveDown(gamebox);
                    break;
                case "d":
                    pacman.moveRight(gamebox);
                    break;
                default:
                    System.out.println("Ogiltigt drag!");
            }

            ghost.move(gamebox);

            if (pacman.getPosition().equals(ghost.getPosition())) {
                System.out.println("Spelet är över! Spöket fångade Pacman.");
                break;
            }

            if (pacman.getPosition().equals(goalPosition)) {
                System.out.println("Grattis! Du vann spelet!");
                break;
            }
        }
    }

    // Metod för att visa spelplanen
    private void displayGameboard() {
        for (int i = 0; i < gameArea.height; i += 50) {
            for (int j = 0; j < gameArea.width; j += 50) {
                Point position = new Point(j, i);
                if (position.equals(pacman.getPosition())) {
                    System.out.print("P ");
                } else if (position.equals(ghost.getPosition())) {
                    System.out.print("G ");
                } else if (position.equals(goalPosition)) {
                    System.out.print("X ");
                } else if (gamebox.getCell(i / 50, j / 50).isWall()) {
                    System.out.print("# ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}