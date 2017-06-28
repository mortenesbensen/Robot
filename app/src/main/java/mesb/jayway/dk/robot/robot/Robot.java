package mesb.jayway.dk.robot.robot;

import java.util.List;

/**
 * This is our robot which moves in a grid
 * @author Morten
 *
 */
public class Robot {

	private RobotPosition position;
	private Grid grid;
	private RobotMoveListener mRobotMoveListener;

	public Robot(int startingCol, int startingRow, Direction direction, Grid grid) {
		position = new RobotPosition(startingCol, startingRow, direction);
		this.grid = grid;
	}

	public void processInstructions(List<Instruction> instructions) {
        for(Instruction i : instructions) {
            doMove(i);
        }
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

		if(mRobotMoveListener != null)
		    mRobotMoveListener.onRobotMove(position);
	}
	
	public RobotPosition getPosition() {
		return position;
	}
	
	
	private void turnLeft() {
		switch(position.getDirection()) {
		case N:
			position.setDirection(Direction.W);
			break;
		case S:
			position.setDirection(Direction.E);
			break;
		case E:
			position.setDirection(Direction.N);
			break;
		case W:
			position.setDirection(Direction.S);
			break;
		}
	}
	
	private void turnRight() {
		switch(position.getDirection()) {
		case N:
			position.setDirection(Direction.E);
			break;
		case S:
			position.setDirection(Direction.W);
			break;
		case E:
			position.setDirection(Direction.S);
			break;
		case W:
			position.setDirection(Direction.N);
			break;
		}
	}
	
	private void moveForward() {
		switch(position.getDirection()) {
		case N:
			position.setRow(position.getRow() - 1);
			break;
		case S:
			position.setRow(position.getRow() + 1);
			break;
		case E:
			position.setColumn(position.getColumn() + 1);
			break;
		case W:
			position.setColumn(position.getColumn() - 1);
			break;
		}
	}

	public void addRobotMoveListener(RobotMoveListener listener) {
        mRobotMoveListener = listener;
    }

	public interface RobotMoveListener {
		void onRobotMove(RobotPosition position);
	}
}
