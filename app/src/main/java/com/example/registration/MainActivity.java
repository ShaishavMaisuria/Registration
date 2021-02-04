package com.example.registration;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView department_value;
    final static public int REQ_CODE =100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView name=findViewById(R.id.textViewName);

        department_value=findViewById(R.id.textViewDepartmentValue);

        findViewById(R.id.buttonSelect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this,Department.class);

                startActivityForResult(intent,REQ_CODE); //s
            }
        });





//        if(getIntent()!=null && getIntent().getExtras()!=null && getIntent().hasExtra(Department.Name_key)){
//            String department =getIntent().getStringExtra(Department.Name_key);
//            department_value.setText(String.valueOf(department));
//            Log.d("demo","Mainactivity intent");
//        }
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

                department_value.setText(String.valueOf(dept_data));

            }
        }
        else if(resultCode==RESULT_CANCELED){
            Log.d("demo","OnactivityResult NOT OKAY");
        }
    }
}