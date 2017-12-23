package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.mylibrary.ShowJokeActivity;

public class BaseActivityFragment extends Fragment implements FetchRandomJokeTask.FetchRandomJokeTaskListener {
    private ProgressBar progressBar;
    private Button buttonDisplayJoke;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar = view.findViewById(R.id.progressBar);
        buttonDisplayJoke = view.findViewById(R.id.btFragmentMainTellJoke);
        buttonDisplayJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleLoadingJokeIndicator(true);
                new FetchRandomJokeTask(BaseActivityFragment.this)
                        .execute();
            }
        });
    }

    private void toggleLoadingJokeIndicator(boolean loading) {
        buttonDisplayJoke.setVisibility(loading ? View.GONE : View.VISIBLE);
        progressBar.setVisibility(loading ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onResult(String joke) {
        toggleLoadingJokeIndicator(false);
        Intent showJokeIntent = ShowJokeActivity.getIntent(getActivity(), joke);
        startActivity(showJokeIntent);
    }
}
