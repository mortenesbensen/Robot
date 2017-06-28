package mesb.jayway.dk.robot.robot;

/**
 * Represents a grid in which our robot can move
 * @author Morten
 *
 */
public class Grid {

	private int columns;
	private int rows;

	public Grid(int columns, int rows) {
		this.columns = columns;
		this.rows = rows;
	}

	/**
	 * Checks if a move is valid
	 * 
	 * @param instruction
	 * @param pos
	 * @return true if the move is valid else false
	 */
	public boolean isValidMove(Instruction instruction, RobotPosition pos) {
		// We can always turn no matter where we are
		if (instruction != Instruction.F)
			return true;

		switch (pos.getDirection()) {
		case NORTH:
			return pos.getRow() - 1 > 0;
		case SOUTH:
			return pos.getRow() + 1 < rows;
		case EAST:
			return pos.getColumn() + 1 < columns;
		case WEST:
			return pos.getColumn() - 1 > 0;
		default:
			return false;
		}
	}
}
