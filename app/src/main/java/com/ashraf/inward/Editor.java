package com.ashraf.inward;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Editor extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);


        findViewById(R.id.Editor_Save).setOnClickListener(this);
        findViewById(R.id.Editor_Moutward).setOnClickListener(this);
    }


    public void onClick(View view) {
        switch (view.getId()) {
           case R.id.Editor_Save :
               startActivity(new Intent(Editor.this,Display.class));



               break;

            case R.id.Editor_Moutward:
                startActivity(new Intent(Editor.this, MainActivity.class));
                break;
        }
    }



   /* public void Set_Uneditable(){
        ((EditText) findViewById(R.id.Cust_Name)).setInputType(InputType.TYPE_NULL);
        ((EditText) findViewById(R.id.Company)).setInputType(InputType.TYPE_NULL);
        ((EditText) findViewById(R.id.Contact)).setInputType(InputType.TYPE_NULL);
        ((EditText) findViewById(R.id.Address)).setInputType(InputType.TYPE_NULL);
        ((EditText) findViewById(R.id.Brand)).setInputType(InputType.TYPE_NULL);
        ((EditText) findViewById(R.id.Model)).setInputType(InputType.TYPE_NULL);
        ((EditText) findViewById(R.id.Problem)).setInputType(InputType.TYPE_NULL);
        ((EditText) findViewById(R.id.Status)).setInputType(InputType.TYPE_NULL);
        ((EditText) findViewById(R.id.Diagnostics)).setInputType(InputType.TYPE_NULL);
        ((EditText) findViewById(R.id.Charges)).setInputType(InputType.TYPE_NULL);
        ((EditText) findViewById(R.id.Payment)).setInputType(InputType.TYPE_NULL);
        ((EditText) findViewById(R.id.Incharge)).setInputType(InputType.TYPE_NULL);
    }*/
}