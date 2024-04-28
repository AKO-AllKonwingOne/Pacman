import java.awt.Point;
import java.awt.Rectangle;
import java.util.Scanner;

public class Game {
    private final Rectangle gameArea;
    private final Pacman pacman;
    private final Ghost ghost;
    private final Gamebox gamebox;
    private final Point goalPosition;

    public Game() {
        final int rows = 10;
        final int columns = 10;
        final int cellSize = 50; // The size of each cell in pixels

        gameArea = new Rectangle(columns * cellSize, rows * cellSize);
        gamebox = new Gamebox(rows, columns);
        pacman = new Pacman(0, 0);
        ghost = new Ghost(0, 0);

        // Set a random goal position that is different from Pacman's and the ghost's positions
        Point tempGoalPosition;
        do {
            tempGoalPosition = new Point((int) (Math.random() * 10) * 50, (int) (Math.random() * 10) * 50);
        } while (tempGoalPosition.equals(pacman.getPosition()) || tempGoalPosition.equals(ghost.getPosition()));
        goalPosition = tempGoalPosition;

        play();
    }

    private void play() {
        System.out.println("Welcome to Pacman!");
        System.out.println("Rules:");
        System.out.println("- Use WASD keys to move Pacman.");
        System.out.println("- Reach the goal position to win the game.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayGameboard();
            System.out.print("Enter your move (WASD): ");
            String move = scanner.next().toLowerCase();

            switch (move) {
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
                    System.out.println("Invalid move!");
            }

            ghost.move(gamebox);

            if (pacman.getPosition().equals(ghost.getPosition())) {
                System.out.println("Game Over! Ghost caught Pacman.");
                break;
            }

            if (pacman.getPosition().equals(goalPosition)) {
                System.out.println("Congratulations! You won the game!");
                break;
            }
        }
    }

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
}}