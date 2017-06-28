package mesb.jayway.dk.robot.view;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mesb.jayway.dk.robot.R;

/**
 * Here we visuzalise the robot movement
 */
public class GridFragment extends Fragment {


    public GridFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grid, container, false);
    }

}
