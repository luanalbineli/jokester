package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;

import java.io.IOException;


public class FetchRandomJokeTask extends AsyncTask<Void, Void, String> {
    private final FetchRandomJokeTaskListener fetchRandomJokeTaskListener;
    private JokeApi myApiService = null;

    FetchRandomJokeTask(FetchRandomJokeTaskListener fetchRandomJokeTaskListener) {
        this.fetchRandomJokeTaskListener = fetchRandomJokeTaskListener;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver
            myApiService = builder.build();
        }

        try {
            return myApiService.getRandomJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        if (fetchRandomJokeTaskListener != null) {
            fetchRandomJokeTaskListener.onResult(joke);
        }
    }

    interface FetchRandomJokeTaskListener {
        void onResult(String joke);
    }
}
