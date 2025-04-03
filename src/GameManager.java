public class GameManager {
    private GameState gameState;
    private static GameManager instance = null;

    private GameManager() {
        gameState = GameState.INGAME;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void checkGameStatus(Board board, int i) {
        if(i == -1) {
            gameState = GameState.GAMEOVER;
        } else if (i == 0) {
            gameState = GameState.INGAME;
        } else if (board.allCellsDiscovered()) {
            gameState = GameState.WIN;
        }
    }

    public static GameManager getInstance() {
        if(instance == null) {
            instance = new GameManager();
        }
        return instance;
    }
}