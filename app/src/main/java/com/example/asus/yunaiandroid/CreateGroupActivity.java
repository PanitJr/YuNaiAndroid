package com.example.asus.yunaiandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
    }
    public void createGroup(){}
    public void linkCreateToMap(View view){
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }
}
