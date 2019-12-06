public class Board {

    final int ROW_COUNT, COL_COUNT;
    private Cell[][] cells;

    // Board constructor
    // Parameters: rowCount, colCount

    /**
     * Board constructor
     * @param rowCount
     * @param colCount
     */
    public Board(int rowCount, int colCount) {
        ROW_COUNT = rowCount;
        COL_COUNT = colCount;

        cells = new Cell[ROW_COUNT][COL_COUNT];
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int col = 0; col < COL_COUNT; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    /**
     * Retreives the cell object
     * @return cells
     */
    public Cell[][] getCells() {
        return cells;
    }
    // Sets the 2D array 
    // Parameters: Cell[][] cells 

    /**
     * Sets the 2D array
     * @param cells
     */
    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }


/**
 * Generates food object at random location 
 */
    public void generateFood() {
        System.out.println("Generating food object..");
        int row = (int) (Math.random() * ROW_COUNT);
        int col = (int) (Math.random() * COL_COUNT);

        if (cells[row][col].getCellType() == CellType.SNAKE_NODE)
            generateFood();

        cells[row][col].setCellType(CellType.FOOD);
        System.out.println("Food is generated at: " + row + " " + col);
    }
}
