package com.example.asus.yunaiandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
    public void linkToCreateGroup(View view){
        Intent intent = new Intent(this,CreateGroupActivity.class);
        startActivity(intent);
    }
    public void linkToJoinGroup(View view){
        Intent intent = new Intent(this,JoinGroupActivity.class);
        startActivity(intent);
    }
}
