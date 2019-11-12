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
public class AddTwoNumber extends Fragment implements View.OnClickListener {

    EditText etFirst, etSecond;
    Button btnCalc;

    public AddTwoNumber() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_two_number, container, false);

        etFirst = view.findViewById(R.id.etFirst);
        etSecond = view.findViewById(R.id.etSecond);
        btnCalc = view.findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        int first = Integer.parseInt(etFirst.getText().toString());
        int second = Integer.parseInt(etSecond.getText().toString());
        int result = first + second;

        Toast.makeText(getActivity(), "The Sum is " + result, Toast.LENGTH_SHORT).show();


    }
}
