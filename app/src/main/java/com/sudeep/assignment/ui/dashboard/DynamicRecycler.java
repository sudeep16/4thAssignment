package com.sudeep.assignment.ui.dashboard;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.sudeep.assignment.R;
import com.sudeep.assignment.adapter.PersonDetailAdapter;
import com.sudeep.assignment.model.PersonDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DynamicRecycler extends Fragment implements View.OnClickListener {

    EditText etName, etAge;
    RadioButton rbMale, rbFemale, rbOthers;
    Spinner spinner;
    Button btnSave;
    RadioGroup rdoGrp;
    RecyclerView recyclerView;
    String gen;
    int img;
    List<PersonDetail> userList = new ArrayList<>();

    public DynamicRecycler(){
        //Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dynamic_recycler, container, false);
        etName = view.findViewById(R.id.name);
        etAge = view.findViewById(R.id.age);
        rbMale = view.findViewById(R.id.rdoMale);
        rbFemale = view.findViewById(R.id.rdoFemale);
        rbOthers = view.findViewById(R.id.rdoOther);
        btnSave = view.findViewById(R.id.save);
        spinner = view.findViewById(R.id.spinimage);
        rdoGrp = view.findViewById(R.id.grpGender);
        recyclerView = view.findViewById(R.id.recyclerView);


        btnSave.setOnClickListener(this);


        // Image images[]={image1,image2};

        String images[] = {
                "Select Image",
                "No Image",
                "Joker",
                "One",
                "Two"};
        final ArrayAdapter adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                images
        );
        spinner.setAdapter(adapter);

        return view;
    }


    @Override
    public void onClick(View v) {
        if (TextUtils.equals(etName.getText().toString(), "")) {
            return;
        }
        if (TextUtils.equals(etAge.getText().toString(), "")) {
            return;
        }

        if (rbMale.isChecked()) {
            gen = "Male";
        }
        if (rbFemale.isChecked()) {
            gen = "Female";
        }
        if (rbOthers.isChecked()) {
            gen = "Others";
        }
        String image = spinner.getSelectedItem().toString();
        if (image == "No Image") {
            img = R.drawable.noimage;
        }
        if (image == "One") {
            img = R.drawable.one;
        }
        if (image == "Two") {
            img = R.drawable.two;
        }
        if (image == "Joker") {
            img = R.drawable.joker;
        }

        int age = Integer.parseInt(etAge.getText().toString());

        userList.add(new PersonDetail(etName.getText().toString(), age, gen, img));
        PersonDetailAdapter personDetailAdapter = new PersonDetailAdapter(getActivity(), userList);
        recyclerView.setAdapter(personDetailAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        etName.setText("");
        etAge.setText("");
        rbFemale.clearFocus();
        rbOthers.clearFocus();
        rbMale.clearFocus();
        spinner.clearFocus();

    }
}


