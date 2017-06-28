package mesb.jayway.dk.robot.view;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import mesb.jayway.dk.robot.robot.Direction;
import mesb.jayway.dk.robot.robot.Grid;
import mesb.jayway.dk.robot.robot.Instruction;
import mesb.jayway.dk.robot.robot.RobotPosition;
import mesb.jayway.dk.robot.robot.util.InstructionParser;
import mesb.jayway.dk.robot.robot.Robot;

/**
 * Here we visualise the robot movement
 */
public class GridFragment extends Fragment implements Robot.RobotMoveListener{

    public GridFragment() {}

    public void start(int gridCol, int gridRow, int robotCol, int robotRow, String robotDir, String robotIns) {
        // First we draw the grid
        GridView gridView = (GridView) getView();
        gridView.drawGrid(gridCol, gridRow);

        // Then we create our robot
        Grid grid = new Grid(gridCol, gridRow);
        Robot robot = new Robot(robotCol, robotRow, Direction.valueOf(robotDir), grid);
        robot.addRobotMoveListener(this);

        // Then we parse the instructions
        List<Instruction> instructions = InstructionParser.parseInstructionString(robotIns);

        // Lastly, we let the robot move
        robot.processInstructions(instructions);


    }

    @Override
    public void onResume() {
        super.onResume();
        Bundle b = getArguments();
        if(b != null) {
            start(b.getInt(MainActivity.EXTRA_GRID_COLS), b.getInt(MainActivity.EXTRA_GRID_ROWS), b.getInt(MainActivity.EXTRA_ROBOT_COL), b.getInt(MainActivity.EXTRA_ROBOT_ROW), b.getString(MainActivity.EXTRA_ROBOT_DIR), b.getString(MainActivity.EXTRA_ROBOT_INST));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         // Create the grid.
        GridView view = new GridView(getActivity());

        // If this fragments was started with extras retrieve them
        Bundle b = getArguments();
        if (b != null) {
            int cols = b.getInt(MainActivity.EXTRA_GRID_COLS);
            int rows = b.getInt(MainActivity.EXTRA_GRID_ROWS);
            view.drawGrid(cols, rows);
        }

        return view;
    }

    @Override
    public void onRobotMove(RobotPosition position) {
        GridView view = (GridView) getView();
        view.drawRobot(position);
    }
}
