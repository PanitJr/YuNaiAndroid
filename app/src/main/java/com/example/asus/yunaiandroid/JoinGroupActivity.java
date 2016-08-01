package com.example.asus.yunaiandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.asus.yunaiandroid.action.TeamAction;
import com.example.asus.yunaiandroid.entity.Team;
import com.example.asus.yunaiandroid.entity.User;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JoinGroupActivity extends AppCompatActivity {
    AutoCompleteTextView searchBar;
    private Retrofit retrofit;
    TeamAction.Caller teamAction;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_group);
        searchBar = (AutoCompleteTextView) findViewById(R.id.search_bar);
        List<String> teamList = Arrays.asList("Red team","River club", "Pokemon Master!", "Cobra club", "Game of Throne");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,teamList);
        searchBar.setAdapter(adapter);
        searchBar.setThreshold(0);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IndexActivity.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        teamAction = retrofit.create(TeamAction.Caller.class);

    }
    public void linkJoinToMap(View view){
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }
    public void linkJoinToMap(){
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }
    private void join(String password, String teamName, User user) {
        Call<Team> call = teamAction.join(password, user.getId(), teamName);
        call.enqueue(new Callback<Team>() {
            @Override
            public void onResponse(Call<Team> call, Response<Team> response) {
                linkJoinToMap();
            }

            @Override
            public void onFailure(Call<Team> call, Throwable t) {
                Log.d("DEBUG","fail");
            }
        });
    }
}
