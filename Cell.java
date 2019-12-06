public class Cell {

    private final int row, col;
    private CellType cellType;

    /**
     * Cell constructor
     * 
     * @param row
     * @param col
     */
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Returns the cellType enum
     * 
     * @return celltype
     */
    public CellType getCellType() {
        return cellType;
    }


    /**
     * Instantiates the cellType enum to "this" instance
     * @param cellType
     */
    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    /**
     * Returns the called row
     * @return row
     */
    public int getRow() {
        return row;
    }


    /**
     * Returns the called column
     * @return col
     */
    public int getCol() {
        return col;
    }
}