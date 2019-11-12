package com.sudeep.assignment.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sudeep.assignment.NavDashboardActivity;
import com.sudeep.assignment.R;
import com.sudeep.assignment.model.UserDetail;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    String username, password;
    boolean status;
    EditText uname, pass;
    Button btnLogin;



    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        uname = view.findViewById(R.id.uname);
        pass = view.findViewById(R.id.pass);
        btnLogin = view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = uname.getText().toString().trim();
                password = pass.getText().toString().trim();

                if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                    UserDetail userDetail = new UserDetail(username, password);
                    status = userDetail.loginChk();


                    if(status){
                        Toast.makeText(getActivity(), "Login Successful, Welcome: " + username, Toast.LENGTH_LONG).show();
                        uname.setText("");
                        pass.setText("");

                        /// new activity

                        Intent intent = new Intent(getActivity(), NavDashboardActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, username);
                        startActivity(intent);


                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Invalid Username & Password", Toast.LENGTH_LONG).show();
                        uname.setText("");
                        pass.setText("");
                    }
                }
                else
                {
                    if(TextUtils.isEmpty(username)){
                        uname.setError("Enter Username");}
                    if(TextUtils.isEmpty(password)){
                        pass.setError("Enter Password");}
                    return;
                }

            }
        });


        return  view;
    }


}
