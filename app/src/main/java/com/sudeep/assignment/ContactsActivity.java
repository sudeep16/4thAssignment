package com.sudeep.assignment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactsActivity extends AppCompatActivity {
    CircleImageView circleimg;
    TextView tvName, tvGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        circleimg = findViewById(R.id.imgProfile);
        tvName = findViewById(R.id.name);
        tvGender = findViewById(R.id.gender);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            circleimg.setImageResource(bundle.getInt("image"));
            tvName.setText(bundle.getString("name"));
            tvGender.setText(bundle.getString("gender"));

        }
    }
}
