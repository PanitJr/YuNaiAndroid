package com.example.asus.yunaiandroid;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.asus.yunaiandroid.action.TeamAction;
import com.example.asus.yunaiandroid.action.UserAction;
import com.example.asus.yunaiandroid.entity.Team;
import com.example.asus.yunaiandroid.entity.User;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateGroupActivity extends AppCompatActivity {
    private EditText textTime;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        textTime = (EditText) findViewById(R.id.time_picker);
        textTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(CreateGroupActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        textTime.setText(i + ":" + i1);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            user = (User) extras.getSerializable(IndexActivity.USER);
        }
    }
    public void createGroup(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IndexActivity.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Team team = new Team();
        TeamAction.Caller teamAction = retrofit.create(TeamAction.Caller.class);
//        Call<Team> call = teamAction.createTeam(team);
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//
//                linkToMain();
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                Log.d("Fail",t.getMessage());
//            }
//        });
    }
    public void linkCreateToMap(){
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }
    public void linkCreateToMap(View v){
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }
}
