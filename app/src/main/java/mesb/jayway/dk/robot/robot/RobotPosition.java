package mesb.jayway.dk.robot.robot;

/**
 * Class representing our Robot's position
 */
public class RobotPosition {

    private int row;
    private int column;
    private Direction direction;

    public RobotPosition(int column, int row, Direction direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return column + " " + row + " " + direction.toString();
    }
}
