package com.ashraf.inward;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Display extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        findViewById(R.id.Display_Edit).setOnClickListener(this);
        findViewById(R.id.Display_Home).setOnClickListener(this);


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Display_Edit :
                startActivity(new Intent(Display.this,Editor.class));
                break;

            case R.id.Display_Home:
                startActivity(new Intent(Display.this, MainActivity.class));
                break;
        }
    }
}