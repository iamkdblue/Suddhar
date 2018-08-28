package app.kdblue.com.creditsuddhar.fragment;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.warkiz.widget.ColorCollector;
import com.warkiz.widget.IndicatorSeekBar;
import com.warkiz.widget.IndicatorStayLayout;
import com.warkiz.widget.IndicatorType;
import com.warkiz.widget.OnSeekChangeListener;
import com.warkiz.widget.SeekParams;
import com.warkiz.widget.TickMarkType;

import app.kdblue.com.creditsuddhar.R;
import app.kdblue.com.creditsuddhar.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreditReportFragment extends Fragment {


    private static final String TAG = "CreditReportFragment";
    private LinearLayout llSeekBar;

    public CreditReportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_credit_report, container, false);
        llSeekBar = view.findViewById(R.id.llSeekBar);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        IndicatorSeekBar seekbar = IndicatorSeekBar
                .with(getActivity())
                .max(900)
                .min(300)
                .progress(609)
                .tickCount(7)
                .tickMarksColor(ContextCompat.getColor(getActivity(), R.color.blue))
                .tickMarksSize(13)//dp
                .showTickTexts(true)
                .tickTextsColor(getResources().getColor(R.color.colorAccent))
                .tickTextsSize(13)//sp
                .seekSmoothly(true)
                .userSeekable(true)
                .tickTextsTypeFace(Typeface.MONOSPACE)
                .showIndicatorType(IndicatorType.ROUNDED_RECTANGLE)
                .indicatorColor(getResources().getColor(R.color.blue))
                .indicatorTextColor(Color.parseColor("#ffffff"))
                .indicatorTextSize(13)//sp
                .thumbColor(ContextCompat.getColor(getActivity(), R.color.colorAccent))
                .thumbSize(14)
                .onlyThumbDraggable(false)
                .userSeekable(false)
                .trackProgressColor(ContextCompat.getColor(getActivity(), R.color.colorAccent))
                .trackProgressSize(4)
                .trackBackgroundColor(getResources().getColor(R.color.grey))
                .trackBackgroundSize(2)
                .build();

        seekbar.customSectionTrackColor(new ColorCollector() {
            @Override
            public boolean collectSectionTrackColor(int[] colorIntArr) {
                //the length of colorIntArray equals section count
                colorIntArr[0] = ContextCompat.getColor(getActivity(), R.color.red);
                colorIntArr[1] = ContextCompat.getColor(getActivity(), R.color.red);
                colorIntArr[2] = ContextCompat.getColor(getActivity(), R.color.red);
                colorIntArr[3] = ContextCompat.getColor(getActivity(), R.color.yellow);
                colorIntArr[4] = ContextCompat.getColor(getActivity(), R.color.green);
                colorIntArr[5] = ContextCompat.getColor(getActivity(), R.color.green);
                return true;//true if apply color , otherwise no change
            }
        });

        IndicatorStayLayout indicatorStayLayout = new IndicatorStayLayout(getContext());
        indicatorStayLayout.attachTo(seekbar);

        //seekbar.setDecimalScale(3);

        llSeekBar.addView(indicatorStayLayout);

    }
}
