package com.sudeep.assignment.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sudeep.assignment.R;
import com.sudeep.assignment.model.UserDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment {
    private EditText uname, pass, cpass;
    private Button btnRegister;
    String username, password, cpassword;
    boolean status;

   static List<UserDetail> userList = new ArrayList<>();

    public SignupFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_signup, container, false);

        uname = view.findViewById(R.id.uname);
        pass = view.findViewById(R.id.pass);
        cpass = view.findViewById(R.id.cpass);
        btnRegister = view.findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = uname.getText().toString().trim();
                password = pass.getText().toString().trim();
                cpassword = cpass.getText().toString().trim();


                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(cpassword)) {
                    if (!password.equals(cpassword)) {
                        cpass.setError("Password Do Not Match");
                        Toast.makeText(getActivity(), "Enter the password again", Toast.LENGTH_LONG).show();
                        onStop();
                    } else {
                        UserDetail userDetail = new UserDetail(username, password, cpassword);
                        userList.add(userDetail);

//                        status = userDetail.loginChk();
                          userDetail.setUserList(userList);



                        for (int i = 0; i < userDetail.getUserList().size(); i++) {
                            userDetail.getUserList().get(i);
                            Toast.makeText(getActivity(), "" + userDetail.getUname(), Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(getActivity(), "Signup Sucessful : " + username, Toast.LENGTH_LONG).show();
                        uname.setText("");
                        pass.setText("");
                        cpass.setText("");
                    }
                } else {
                    if (TextUtils.isEmpty(username)) {
                        uname.setError("Enter Username");
                    }
                    if (TextUtils.isEmpty(password)) {
                        pass.setError("Enter Password");
                    }
                    if (TextUtils.isEmpty(cpassword)) {
                        cpass.setError("Conform Password");
                    }
                    return;
                }

            }

        });

        return view;
    }


}
