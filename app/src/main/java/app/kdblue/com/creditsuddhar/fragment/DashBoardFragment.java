package app.kdblue.com.creditsuddhar.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.github.anastr.speedviewlib.SpeedView;

import java.util.List;

import app.kdblue.com.creditsuddhar.R;
import app.kdblue.com.creditsuddhar.activity.MainActivity;
import app.kdblue.com.creditsuddhar.db.UserDataBase;
import app.kdblue.com.creditsuddhar.model.Article;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment {

    private Toolbar toolbar;
    private SpeedView speedView;

    public DashBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);
        speedView = view.findViewById(R.id.speedView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        speedView.speedTo(609, 1500);
    }


}
