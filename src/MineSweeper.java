import java.util.Scanner;

public class MineSweeper {
    public static void main(String[] args) {
        int width = 18;
        int height = 18;
        int maxMines = 40;

        Board board = new Board(width, height, maxMines);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to MineSweeper!\nBoard is " + width + "x" + height + " with " + maxMines + " mines");

        while (GameManager.getInstance().getGameState() == GameState.INGAME) {
            board.printBoard();

            System.out.print("Coordinate X: ");
            int x = scanner.nextInt();

            System.out.print("Coordinate Y: ");
            int y = scanner.nextInt();

            int result = board.discover(y, x);
            GameManager.getInstance().checkGameStatus(board, result);

            if (GameManager.getInstance().getGameState() == GameState.WIN) {
                System.out.println("You Win!");
                board.printDiscoveredBoard();
                break;
            } else if (GameManager.getInstance().getGameState() == GameState.GAMEOVER) {
                System.out.println("Game Over!");
                board.printDiscoveredBoard();
                break;
            }
        }

        scanner.close();
    }
}
