package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(AndroidJUnit4.class)
public class JokeAsyncTaskTestCase {

    @Test
	public void test_get_joke() {
        FetchRandomJokeTask fetchRandomJokeTask = new FetchRandomJokeTask(null);
        fetchRandomJokeTask.execute();
        try {
            String joke = fetchRandomJokeTask.get();
            assertNotNull(joke);
            assertTrue(joke.length() > 0);
        } catch (Exception e) {
            fail("An internal error occurred: e");
        }
    }
}
