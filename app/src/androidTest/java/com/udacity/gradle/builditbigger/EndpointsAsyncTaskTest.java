package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {
    private String result = null;
    private Exception error = null;
    private CountDownLatch count = null;

    @Before
    public void setUp() throws Exception {
        count = new CountDownLatch(1);
    }

    @After
    public void tearDown() throws Exception {
        count.countDown();
    }

    @Test
    public void testDoInBackground() throws InterruptedException {
        new EndpointsAsyncTask((joke, e) -> {
            result = joke;
            error = e;
            count.countDown();
        }).execute();
        count.await();

        if (error == null) {
            assertTrue(!TextUtils.isEmpty(result));
        } else {
            assertNull(result);
            assertTrue(!TextUtils.isEmpty(error.getMessage()));
        }
    }
}