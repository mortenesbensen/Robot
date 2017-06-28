package mesb.jayway.dk.robot.robot;

/**
 * This is our robot which moves in a grid
 * @author Morten
 *
 */
public class Robot {

	private RobotPosition position;
	private Grid grid;
	
	public Robot(int startingCol, int startingRow, Direction direction, Grid grid) {
		position = new RobotPosition(startingCol, startingRow, direction);
		this.grid = grid;
	}
	
	/**
	 * Instructs the robot to move
	 * @param i
	 */
	public void doMove(Instruction i) {
		// If we can't move the robot we do nothing
		if(!grid.isValidMove(i, position))
			return;			
			
		// Else we update the position
		switch (i) {
		case F:
			moveForward();
			break;
		case L:
			turnLeft();
			break;
		case R:
			turnRight();
			break;
		default:
			break;
		}
	}
	
	public RobotPosition getPosition() {
		return position;
	}
	
	
	private void turnLeft() {
		switch(position.getDirection()) {
		case NORTH:
			position.setDirection(Direction.WEST);
			break;
		case SOUTH:
			position.setDirection(Direction.EAST);
			break;
		case EAST:
			position.setDirection(Direction.NORTH);
			break;
		case WEST:
			position.setDirection(Direction.SOUTH);
			break;
		}
	}
	
	private void turnRight() {
		switch(position.getDirection()) {
		case NORTH:
			position.setDirection(Direction.EAST);
			break;
		case SOUTH:
			position.setDirection(Direction.WEST);
			break;
		case EAST:
			position.setDirection(Direction.SOUTH);
			break;
		case WEST:
			position.setDirection(Direction.NORTH);
			break;
		}
	}
	
	private void moveForward() {
		switch(position.getDirection()) {
		case NORTH:
			position.setRow(position.getRow() - 1);
			break;
		case SOUTH:
			position.setRow(position.getRow() + 1);
			break;
		case EAST:
			position.setColumn(position.getColumn() + 1);
			break;
		case WEST:
			position.setColumn(position.getColumn() - 1);
			break;
		}
	}
}
