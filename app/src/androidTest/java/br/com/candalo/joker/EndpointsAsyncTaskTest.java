package br.com.candalo.joker;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EndpointsAsyncTaskTest {

    @Test
    public void testAsyncTaskJoke() {
        String result = null;
        try {
            result = new EndpointsAsyncTask(new EndpointsAsyncTask.OnResultListener() {
                @Override
                public void onResult(String joke) {
                }
            }).execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}