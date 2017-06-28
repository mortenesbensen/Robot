package mesb.jayway.dk.robot.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import mesb.jayway.dk.robot.R;

public class MainActivity extends Activity implements SettingsFragment.OnStartButtonClicked {

    private boolean mIsDualMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if we have access to dual mode (2 fragments)
        mIsDualMode = findViewById(R.id.fragment_container) == null;

        if(savedInstanceState == null) {
            // If we are not in the dual mode we add the fragment to our container
            if(!mIsDualMode) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                SettingsFragment fragment = new SettingsFragment();
                transaction.add(R.id.fragment_container, fragment);
                transaction.commit();
            }
        }
    }

    @Override
    public void onStartButtonClicked(int gridRows, int gridCols, int robotRow, int robotCol, String robotDir, String robotIns) {

    }
}
