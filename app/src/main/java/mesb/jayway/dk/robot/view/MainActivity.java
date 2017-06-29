package mesb.jayway.dk.robot.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import mesb.jayway.dk.robot.R;
import mesb.jayway.dk.robot.view.grid.GridFragment;
import mesb.jayway.dk.robot.view.settings.SettingsFragment;

public class MainActivity extends Activity implements SettingsFragment.OnStartButtonClicked {

    public static final String EXTRA_GRID_COLS = "grid_cols";
    public static final String EXTRA_GRID_ROWS = "grid_rows";
    public static final String EXTRA_ROBOT_COL = "robot_col";
    public static final String EXTRA_ROBOT_ROW = "robot_row";
    public static final String EXTRA_ROBOT_DIR = "robot_dir";
    public static final String EXTRA_ROBOT_INST = "robot_inst";

    private boolean mIsDualMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if we have access to dual mode (2 fragments)
        mIsDualMode = findViewById(R.id.fragment_container) == null;

        if (savedInstanceState == null) {
            // If we are not in the dual mode we add the fragment to our container
            if (!mIsDualMode) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                SettingsFragment fragment = new SettingsFragment();
                transaction.add(R.id.fragment_container, fragment);
                transaction.commit();
            }
        }
    }

    @Override
    public void onStartButtonClicked(int gridCols, int gridRows, int robotCol, int robotRow, String robotDir, String robotIns) {
        // If we are in dual mode, the grid fragment is already available, if not, we have to switch fragments
        if (mIsDualMode) {
            GridFragment gridFragment = (GridFragment) getFragmentManager().findFragmentById(R.id.fragment_grid);
            gridFragment.start(gridCols, gridRows, robotCol, robotRow, robotDir, robotIns);
        } else {
            GridFragment gridFragment = new GridFragment();
            Bundle b = new Bundle();
            b.putInt(EXTRA_GRID_COLS, gridCols);
            b.putInt(EXTRA_GRID_ROWS, gridRows);
            b.putInt(EXTRA_ROBOT_COL, robotCol);
            b.putInt(EXTRA_ROBOT_ROW, robotRow);
            b.putString(EXTRA_ROBOT_DIR, robotDir);
            b.putString(EXTRA_ROBOT_INST, robotIns);

            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            gridFragment.setArguments(b);
            transaction.replace(R.id.fragment_container, gridFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
