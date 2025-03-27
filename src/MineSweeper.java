public class MineSweeper {

    public static void main(String[] args) {
        Board board = new Board(5, 5, 3);
        //board.printDiscoveredBoard();
        board.discover(-2,1);
    }
}
