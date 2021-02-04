package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.Serializable;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView name=findViewById(R.id.textViewNameProfie);
        TextView id=findViewById(R.id.textViewIDprofile);
        TextView email=findViewById(R.id.textViewEmailProfile);
        TextView  department=findViewById(R.id.textViewDeptprofile);

            if(getIntent()!=null && getIntent().getExtras()!=null && getIntent().hasExtra(MainActivity.Main_key)){
               User user= (User) getIntent().getSerializableExtra(MainActivity.Main_key);

               name.setText(String.valueOf(user.getName()));
               id.setText(String.valueOf(user.getID()));
               email.setText(String.valueOf(user.getEmail()));
               department.setText(user.getDepartment());
                Log.d("demo profile","profile worked"+user.getDepartment());
            }else{
                Log.d("demo profile","profile failed");
            }

    }
}