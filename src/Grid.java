public class Grid {

    public static final int ALIVE = 1;
    public static final int DEAD = 0;

    private final int[][] grid;

    public Grid(int rows, int cols) {
        grid = new int[rows][cols];
    }

    public int getValue(int row, int col) {
        return grid[row][col];
    }

    public void setValue(int value, int row, int col) {
        grid[row][col] = value;
    }

    public void display() {
        for (int i = 0; i < Game.ROWS; i++) {
            for (int j = 0; j < Game.COLS; j++) {
                if (this.getValue(i, j) == DEAD) {
                    System.out.print("-");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public Grid createNewGeneration() {
        Grid newGeneration = new Grid(Game.ROWS, Game.COLS);
        for (int i = 0; i < Game.ROWS; i++) {
            for (int j = 0; j < Game.COLS; j++) {
                int neighbourCount = countAliveNeighbours(i, j);
                if (this.getValue(i, j) == ALIVE) {
                    if (neighbourCount < 2) {
                        newGeneration.setValue(DEAD, i, j);
                    } else if (neighbourCount < 4) {
                        newGeneration.setValue(ALIVE, i, j);
                    } else {
                        newGeneration.setValue(DEAD, i, j);
                    }
                } else {
                    if (neighbourCount == 3) {
                        newGeneration.setValue(ALIVE, i, j);
                    } else {
                        newGeneration.setValue(DEAD, i, j);
                    }
                }
            }
        }
        return newGeneration;
    }

    private int countAliveNeighbours(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1 ; j++) {
                if (i >= 0 && i < Game.ROWS &&
                    j >= 0 && j < Game.COLS &&
                    !(i == row && j == col) &&
                    this.getValue(i, j) == ALIVE) {
                        count++;
                }
            }
        }
        return count;
    }
}
