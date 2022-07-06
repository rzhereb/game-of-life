public class Game {
    public static final int ROWS = 25;
    public static final int COLS = 25;

    public static final int STEPS = 15;

    public static final int PAUSE_MILLIS = 1000;

    public static void main(String[] args) throws InterruptedException {
        Grid grid = new Grid(ROWS, COLS);
        initializeGrid(grid);
        for (int i = 0; i < STEPS; i++) {
            clearConsole(i);
            grid.display();
            grid = grid.createNewGeneration();
            Thread.sleep(PAUSE_MILLIS);
        }
    }
    private static void initializeGrid(Grid grid) {
        int[][] glider = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}};
        int gliderRow = 0;
        for (int i = ROWS / 2; i < ROWS / 2 + glider.length; i++, gliderRow++) {
            int gliderCol = 0;
            for (int j = COLS / 2; j < COLS / 2 + glider.length; j++) {
                grid.setValue(glider[gliderRow][gliderCol++], i, j);
            }
        }
    }

    private static void clearConsole(int step) {
        System.out.println("\n\n\n\n");
        System.out.println("Step " + step + ":");
    }
}
