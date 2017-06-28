package mesb.jayway.dk.robot.view;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mesb.jayway.dk.robot.R;
import mesb.jayway.dk.robot.robot.Direction;
import mesb.jayway.dk.robot.robot.Grid;
import mesb.jayway.dk.robot.robot.Instruction;
import mesb.jayway.dk.robot.robot.util.InstructionParser;
import mesb.jayway.dk.robot.robot.Robot;

/**
 * Here we visuzalise the robot movement
 */
public class GridFragment extends Fragment {

    private TextView result;

    public GridFragment() {
        // Required empty public constructor
    }

    public void startRobot(int gridCol, int gridRow, int robotCol, int robotRow, String robotDir, String robotIns) {

        Grid grid = new Grid(gridCol, gridRow);
        Robot robot = new Robot(robotCol, robotRow, Direction.valueOf(robotDir), grid);
        List<Instruction> instructions = InstructionParser.parseInstructionString(robotIns);
        for(Instruction i : instructions) {
            robot.doMove(i);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        Bundle b = getArguments();

        if(b != null) {
            startRobot(b.getInt(MainActivity.EXTRA_GRID_COLS), b.getInt(MainActivity.EXTRA_GRID_ROWS), b.getInt(MainActivity.EXTRA_ROBOT_COL), b.getInt(MainActivity.EXTRA_ROBOT_ROW), b.getString(MainActivity.EXTRA_ROBOT_DIR), b.getString(MainActivity.EXTRA_ROBOT_INST));
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = new GridView(getActivity(),5,5);

        result = view.findViewById(R.id.grid_tw_result);
        return view;
    }

}
