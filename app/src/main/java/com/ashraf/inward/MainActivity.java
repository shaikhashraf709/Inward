package com.ashraf.inward;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         findViewById(R.id.Create_new).setOnClickListener(this);
         findViewById(R.id.Main_Search_exist).setOnClickListener(this);
    }
    public void onClick(View view){
        switch(view.getId()){
            case R.id.Create_new :
                startActivity(new Intent(MainActivity.this,Create_new.class));
                break;

            case R.id.Main_Search_exist:
                startActivity(new Intent(MainActivity.this,Display.class));

            break;

        }
    }


}