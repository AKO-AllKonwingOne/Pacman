import java.util.Scanner;

public class Game {
    private final Gamebox gamebox;
    private final Pacman pacman;
    private final Ghost ghost;

    public Game() {
        final int ROWS = 10;
        final int COLS = 10;

        gamebox = new Gamebox(ROWS, COLS);
        pacman = new Pacman(ROWS / 2, COLS / 2);
        ghost = new Ghost(ROWS / 2, COLS / 2);

        play();
    }