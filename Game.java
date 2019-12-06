import java.util.Scanner;

// To represent Snake Game 
public class Game {

	Scanner keyboard = new Scanner(System.in);
	// System.out.println("Enter an integer")

	public static final int DIRECTION_NONE = 0, DIRECTION_RIGHT = 1, DIRECTION_LEFT = -1, DIRECTION_UP = 2,
			DIRECTION_DOWN = -2;
	private Snake snake;
	private Board board;
	private int direction;
	private boolean gameOver;

	/**
	 * Constructor for the game object
	 * 
	 * @param snake
	 * @param board
	 */
	public Game(Snake snake, Board board) {
		this.snake = snake;
		this.board = board;
	}

	/**
	 * Creates an instance of the overall snake object
	 * 
	 * @param snake
	 */
	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	/**
	 * Returns the snake object
	 * 
	 * @return
	 */
	public Snake getSnake() {
		return snake;
	}

	/**
	 * Creates instance of a board
	 * 
	 * @param board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * Returns the board object
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Boolean fucntion that returns the gameOver variable
	 * 
	 * @return gameOver
	 */
	public boolean isGameOver() {
		return gameOver;
	}

	/**
	 * Sets an instance of a variable that determines the state of the game
	 * 
	 * @param gameOver
	 */
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	/**
	 * Sets the direction of the snake
	 * 
	 * @param direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * Returns the direction of the snake
	 * 
	 * @return direction
	 */
	public int getDirection() {
		return direction;
	}

	// Updates the board, checks for snake direction, if the snake crashes, the game
	// ends, else the snake will move to the next cell, if it "eats" food it will
	// grow

	/**
	 * Updates the board, checks for snake direction, if the snake crashes, the game
	 * ends, else the snake will move to the next cell, if it "eats" food it will
	 * grow
	 */
	public void update() {
		System.out.println("Updating..");
		if (!gameOver) {
			if (direction != DIRECTION_NONE) {
				Cell nextCell = getNextCell(snake.getHead());

				if (snake.checkCrash(nextCell)) {
					System.out.print("Snake crashed!");
					setDirection(DIRECTION_NONE);
					gameOver = true;
				} else {
					snake.move(nextCell);
					if (nextCell.getCellType() == CellType.FOOD) {
						System.out.print("Snake ate the food!");
						snake.grow();
						board.generateFood();
					}
				}
			}
		}
	}

	/**
	 * Function to retrieve the next cell for the snake to move to
	 * 
	 * @param currentPosition
	 * @return
	 */
	private Cell getNextCell(Cell currentPosition) {
		System.out.println("Finding next cell..");
		int row = currentPosition.getRow();
		int col = currentPosition.getCol();

		if (direction == DIRECTION_RIGHT) {
			col++;
		} else if (direction == DIRECTION_LEFT) {
			col--;
		} else if (direction == DIRECTION_UP) {
			row--;
		} else if (direction == DIRECTION_DOWN) {
			row++;
		}

		Cell nextCell = board.getCells()[row][col];

		return nextCell;
	}

	/**
	 * Runs the Game
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Starting game..");

		Cell initPos = new Cell(0, 0);
		Snake initSnake = new Snake(initPos);
		Board board = new Board(20, 20);
		Game newGame = new Game(initSnake, board);
		newGame.gameOver = false;
		newGame.direction = DIRECTION_RIGHT;

		// For Testing Input
		for (int i = 0; i < 5; i++) {
			if (i == 2)
			newGame.board.generateFood();
			newGame.update();
			if (i == 3)
				newGame.direction = DIRECTION_RIGHT;
			if (newGame.gameOver == true)
				// System.out.println("Game over!");
				break;
		}
	}
}
