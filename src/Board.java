import java.util.Random;

public class Board {
    private Cell[][] board;
    private int width;
    private int height;
    private int maxMines;

    public Board(int width, int height, int maxMines) {
        this.width = width;
        this.height = height;
        this.maxMines = maxMines;
        this.board = new Cell[width][height];

        createEmptyBoard();
        placeMines();
    }

    private boolean inBounds(int y, int x) {
        return (0 <= y && y < height) && (0 <= x && x < width);
    }

    private void createEmptyBoard() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                board[y][x] = new Cell(y, x, true, 0);
            }
        }
    }

    private void placeMines() {
        Random r = new Random();
        int minesPlacedCounter = 0;

        while (minesPlacedCounter < maxMines) {
            int randomY = r.nextInt(0, height);
            int randomX = r.nextInt(0, width);

            if (getCell(randomY, randomX).isEmpty()) {
                getCell(randomY, randomX).setValue(-1);
                incrementAdjacentAtMine(randomY, randomX);
                minesPlacedCounter++;
            }
        }
    }

    private void incrementAdjacentAtMine(int y, int x) {
        if (inBounds(y + 1, x + 1) && !getCell(y + 1, x + 1).isMine()) getCell(y + 1, x + 1).incrementValue();
        if (inBounds(y + 1, x - 1) && !getCell(y + 1, x - 1).isMine()) getCell(y + 1, x - 1).incrementValue();
        if (inBounds(y - 1, x - 1) && !getCell(y - 1, x - 1).isMine()) getCell(y - 1, x - 1).incrementValue();
        if (inBounds(y - 1, x + 1) && !getCell(y - 1, x + 1).isMine()) getCell(y - 1, x + 1).incrementValue();
        if (inBounds(y + 1, x) && !getCell(y + 1, x).isMine()) getCell(y + 1, x).incrementValue();
        if (inBounds(y - 1, x) && !getCell(y - 1, x).isMine()) getCell(y - 1, x).incrementValue();
        if (inBounds(y, x + 1) && !getCell(y, x + 1).isMine()) getCell(y, x + 1).incrementValue();
        if (inBounds(y, x - 1) && !getCell(y, x - 1).isMine()) getCell(y, x - 1).incrementValue();
    }

    public void printDiscoveredBoard() {
        for (int y = 0; y < height; y++) {
            System.out.println(" ");
            for (int x = 0; x < width; x++) {
                if (getCell(y, x).isMine()) {
                    System.out.print("|" + "*" + "|");
                } else {
                    System.out.print("|" + getCell(y, x).getValue() + "|");
                }
            }
        }
        System.out.println(" ");
    }

    private Cell getCell(int y, int x) {
        return board[y][x];
    }

    public int discover(int y, int x) {
        if (!inBounds(y, x)) {
            System.out.println("Coordinate not valid.");
            return -999;
        }

        Cell cell = getCell(y, x);

        if (!cell.isHidden()) {
            //System.out.println("Cell discovered.");
            return -9999;
        }

        if (cell.isMine()) {
            //System.out.println("Mine discovered!");
            return -1;
        }

        cell.setHidden(false);

        if (cell.isEmpty()) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dx = -1; dx <= 1; dx++) {
                    if (dy == 0 && dx == 0) continue;
                    int adjY = y + dy;
                    int adjX = x + dx;
                    if (inBounds(adjY, adjX) && getCell(adjY, adjX).isHidden()) {
                        discover(adjY, adjX);
                    }
                }
            }
        }

        System.out.println("Cell value: " + cell.getValue());
        return cell.getValue();
    }

    public void printBoard() {
        for (int y = 0; y < height; y++) {
            System.out.println(" ");
            for (int x = 0; x < width; x++) {
                if (getCell(y, x).isHidden()) {
                    System.out.print("|" + "?" + "|");
                } else {
                    if (getCell(y, x).isMine()) {
                        System.out.print("|" + "*" + "|");
                    } else if (getCell(y, x).isEmpty()) {
                        System.out.print("|" + "0" + "|");
                    } else {
                        System.out.print("|" + getCell(y, x).getValue() + "|");
                    }
                }
            }
        }
        System.out.println(" ");
    }

    public boolean allCellsDiscovered() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (!getCell(y, x).isMine() && getCell(y, x).isHidden()) {
                    return false;
                }
            }
        }
        return true;
    }
}
