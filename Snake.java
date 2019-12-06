import java.util.LinkedList;

public class Snake {

    private LinkedList<Cell> snakePartList = new LinkedList<>();
    private Cell head;

    /**
     * Snake Constructor
     * 
     * @param initPos
     */
    public Snake(Cell initPos) {
        head = initPos;
        snakePartList.add(head);
    }

    /**
     * Function to add more "length" to the snake
     */
    public void grow() {
        snakePartList.add(head);
    }

    /**
     * Function to move the snake
     * 
     * @param nextCell
     */
    public void move(Cell nextCell) {
        System.out.println("Snake is moving to " + nextCell.getRow() + " " + nextCell.getCol());
        Cell tail = snakePartList.removeLast();
        tail.setCellType(CellType.EMPTY);
        head = nextCell;
        snakePartList.addFirst(head);
    }

    /**
     * Boolean function to check for collision
     * 
     * @param nextCell
     * @return true
     * @return false
     */
    public boolean checkCrash(Cell nextCell) {
        System.out.println("Checking for crash..");
        for (Cell cell : snakePartList) {
            if (cell == nextCell) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sets the snake (with its parts that change length)
     * 
     * @param snakePartList
     */
    public void setSnakePartList(LinkedList<Cell> snakePartList) {
        this.snakePartList = snakePartList;
    }

    /**
     * Returns the snake "body"
     * 
     * @return snakePartList
     */
    public LinkedList<Cell> getSnakePartList() {
        return snakePartList;
    }

    /**
     * Sets an instance of the snake
     * 
     * @param head
     */
    public void setHead(Cell head) {
        this.head = head;
    }

    /**
     * Returns the snake
     * 
     * @return
     */
    public Cell getHead() {
        return head;
    }

}