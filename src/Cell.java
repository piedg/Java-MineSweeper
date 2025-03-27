public class Cell {
    private int x;
    private int y;
    private boolean hidden = false;
    private int value;

    public Cell(int x, int y, boolean hidden, int value) {
        this.x = x;
        this.y = y;
        this.hidden = hidden;
        this.value = value;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isMine()
    {
        return value == -1;
    }

    public boolean isEmpty() {
        return value == 0;
    }

    public void setValue(int newValue) {
        value = newValue;
    }

    public void incrementValue() {
        value += 1;
    }

    public int getValue() {
        return value;
    }
}
