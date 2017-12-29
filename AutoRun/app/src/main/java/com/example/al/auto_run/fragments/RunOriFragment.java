package com.example.al.auto_run.fragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.al.auto_run.R;
import com.example.al.auto_run.activity.CountdownActivity;
import com.example.al.auto_run.activity.HistoryRecordActivity;
import com.example.al.auto_run.activity.RecordActivity;
import com.example.al.auto_run.customanim.CircularAnim;

import at.markushi.ui.CircleButton;

/**
 * Created by windy on 2017/11/11.
 */

public class RunOriFragment extends Fragment {
    Button Btn_go;
    TextView tv_view_miles;
    TextView Tv_miles_count;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.origin_main, container, false);
        tv_view_miles=view.findViewById(R.id.txt_view_miles);
        tv_view_miles.setText("跑步总公里");
        Tv_miles_count=view.findViewById(R.id.txt_view_miles_count);
        Tv_miles_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), HistoryRecordActivity.class);
                startActivity(intent);
            }
        });
        Btn_go = view.findViewById(R.id.img_button_go);
        Btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CircularAnim.fullActivity(getActivity(),view)
                        .colorOrImageRes(R.color.colortry1qd)
                        .go(new CircularAnim.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                startActivity(new Intent(getActivity(), CountdownActivity.class));
                            }
                        });
            }
        });
        return view;
    }
}