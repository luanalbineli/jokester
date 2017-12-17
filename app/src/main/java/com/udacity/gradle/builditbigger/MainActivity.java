package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements FetchRandomJokeTask.FetchRandomJokeTaskListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view) {
        new FetchRandomJokeTask(this).execute();
    }

    @Override
    public void onResult(String joke) {
        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
    }
}
