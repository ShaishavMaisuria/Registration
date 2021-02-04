package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

public class Department extends AppCompatActivity {

    String checkValue;
    final static public String Name_key ="Department Name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButtonComputerScience){
                    checkValue=getResources().getString(R.string.StringcomputerScience);
                }else if(checkedId == R.id.radioButtonBioInformatics){
                    checkValue=getResources().getString(R.string.StringBioInformatics);
                }else if(checkedId == R.id.radioButtonSoftware){
                    checkValue=getResources().getString(R.string.StringSoftwareInfosystem);
                }else{
                    checkValue=getResources().getString(R.string.StringDataScience);
                }
            }
        });


        findViewById(R.id.buttonSelectDepartment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent department_Intent= new Intent();

                department_Intent.putExtra(Name_key,checkValue);
                setResult(RESULT_OK,department_Intent);
                Log.d("demo","departmentSelect");
                finish();
            }
        });
    }
}