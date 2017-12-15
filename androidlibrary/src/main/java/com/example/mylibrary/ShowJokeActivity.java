package com.example.mylibrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {
    private static final String JOKE_INTENT_KEY = "joke_intent_key";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.show_joke_activity);

        TextView textView = findViewById(R.id.tvShowJoke);

        textView.setText(getIntent().getStringExtra(JOKE_INTENT_KEY));
    }

    public static Intent getIntent(Context context, String joke) {
        Intent intent = new Intent(context, ShowJokeActivity.class);
        intent.putExtra(JOKE_INTENT_KEY, joke);
        return intent;
    }
}
