package com.example.registration;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    final static public int REQ_CODE =100;
    final static public String Main_key ="MainSubmitValue";
    EditText name;
    EditText email;
    EditText id;
    TextView department_value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        department_value=findViewById(R.id.textViewDepartmentValue);
        name=findViewById(R.id.editTextPersonName);
        email=findViewById(R.id.editTextEmailAddress);
        id=findViewById(R.id.editTextID);


/*

*/

        findViewById(R.id.buttonSelect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this,Department.class);

                startActivityForResult(intent,REQ_CODE); //s
            }
        });





findViewById(R.id.buttonSubmitMain).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent main_Intent= new Intent(MainActivity.this,profile.class);
        String userName=name.getText().toString();
        String userEmail=email.getText().toString();
        String userID=id.getText().toString();
        String userDepartment=department_value.getText().toString();

        //validation of input

        if(userName.isEmpty()){
            Toast.makeText(MainActivity.this,"Please enter User Name",Toast.LENGTH_SHORT).show();
        }
        else if(userEmail.isEmpty()){
            Toast.makeText(MainActivity.this,"Please enter User Email",Toast.LENGTH_SHORT).show();
        }else if(userID.isEmpty()){
            Toast.makeText(MainActivity.this,"Please enter User ID",Toast.LENGTH_SHORT).show();
        }else if(userDepartment.isEmpty()){
            Toast.makeText(MainActivity.this,"Please enter User Department",Toast.LENGTH_SHORT).show();
        }else {

            User userObject = new User(userName, userEmail, userID, userDepartment);
            main_Intent.putExtra(MainActivity.Main_key,userObject);
            startActivity(main_Intent);
        }

    }
});




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("demo","OnactivityResult "+data.toString());
        if(resultCode==RESULT_OK ) {
            Log.d("demo", "OnactivityResult OKAY ");

            if(data!=null && data.hasExtra(Department.Name_key)){

                String dept_data=data.getStringExtra(Department.Name_key);
                Log.d("demo", "data "+dept_data);

                if (dept_data != null) {
                    department_value.setText(String.valueOf(dept_data));
                }


            else{
                Toast.makeText(MainActivity.this,getResources().getString(R.string.StringToastValue),Toast.LENGTH_SHORT).show();

            }
            }
        }
        else if(resultCode==RESULT_CANCELED){
            Log.d("demo","OnactivityResult NOT OKAY");
        }
    }
}