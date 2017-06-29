package mesb.jayway.dk.robot.view.settings;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import mesb.jayway.dk.robot.R;

/**
 * Here we can set up the grid and give our robot instructions
 */
public class SettingsFragment extends Fragment {

    private OnStartButtonClicked mButtonClickListener;

    public SettingsFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnStartButtonClicked) {
            mButtonClickListener = (OnStartButtonClicked) context;
        } else {
            throw new ClassCastException(context.toString() + " doesn't implement OnStartButtonClicked");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        final EditText etCols = (EditText) view.findViewById(R.id.settings_et_grid_columns);
        final EditText etRows = (EditText) view.findViewById(R.id.settings_et_grid_rows);
        final EditText etRobotCol = (EditText) view.findViewById(R.id.settings_et_robot_colum);
        final EditText etRobotRow = (EditText) view.findViewById(R.id.settings_et_robot_row);
        final EditText etRobotDir = (EditText) view.findViewById(R.id.settings_et_robot_dir);
        final EditText etRobotIns = (EditText) view.findViewById(R.id.settings_et_robot_instructions);

        final Button startBtn = (Button) view.findViewById(R.id.setting_btn_start);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int gridCols = Integer.valueOf(etCols.getText().toString());
                int gridRows = Integer.valueOf(etRows.getText().toString());
                int robotCol = Integer.valueOf(etRobotCol.getText().toString());
                int robotRow = Integer.valueOf(etRobotRow.getText().toString());
                String robotDir = etRobotDir.getText().toString();
                String robotIns = etRobotIns.getText().toString();

                mButtonClickListener.onStartButtonClicked(gridCols, gridRows, robotCol, robotRow, robotDir, robotIns);
            }
        });

        return view;
    }

    public interface OnStartButtonClicked {
        void onStartButtonClicked(int gridCols, int gridRows, int robotCol, int robotRow, String robotDir, String robotIns);
    }
}