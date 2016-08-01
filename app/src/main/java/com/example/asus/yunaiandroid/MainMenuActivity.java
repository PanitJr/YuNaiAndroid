package com.example.asus.yunaiandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.asus.yunaiandroid.entity.User;

public class MainMenuActivity extends AppCompatActivity {

    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            user = (User) extras.getSerializable(IndexActivity.USER);
        }
        TextView username = (TextView) findViewById(R.id.username);
        username.setText(user.getName());
    }
    public void linkToCreateGroup(View view){
        Intent intent = new Intent(this,CreateGroupActivity.class);
        intent.putExtra(IndexActivity.USER,user);
        startActivity(intent);
    }
    public void linkToJoinGroup(View view){
        Intent intent = new Intent(this,JoinGroupActivity.class);
        startActivity(intent);
    }
}
