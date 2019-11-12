package com.sudeep.assignment.ui.dashboard;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sudeep.assignment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AreaOfCircle extends Fragment {


    private Button btnCalcArea;
    private EditText etRadius;


    public AreaOfCircle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_area_of_circle, container, false);
        etRadius = view.findViewById(R.id.etRadius);
        btnCalcArea = view.findViewById(R.id.btnCalcArea);


        btnCalcArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float radius = Float.parseFloat(etRadius.getText().toString());
                float area = 3.14f * radius * radius;

                Toast.makeText(getActivity(), "Area of Circle is " + area, Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }


}
