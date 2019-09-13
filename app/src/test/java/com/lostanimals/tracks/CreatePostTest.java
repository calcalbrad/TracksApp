package com.lostanimals.tracks;

import android.content.Context;
import com.lostanimals.tracks.utils.ServerManager;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.net.URLEncoder;

@RunWith(MockitoJUnitRunner.class)
public class CreatePostTest {

    private static final String TEST_URL = "http://bosh.live:7536/phpmyadmin/tracks_api/";
    private static final String TEST_USER_USERNAME = "test";
    private static final String TEST_POST_TITLE = "Test Post";
    private static final String TEST_POST_DESC = "Test Desc";
    private static String postData = null;

    @Mock
    ServerManager mockServerManager;
    @Mock
    Context mockContext;

    @Before
    public void initMocks() {
        mockServerManager = new ServerManager(mockContext);
    }

    @Test
    public void AttemptLoginHelperTest_processCreatePostRequest() throws IOException, JSONException {
        postData += URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(TEST_POST_TITLE, "UTF-8") + "&";
        postData += URLEncoder.encode("description", "UTF-8") + "=" + URLEncoder.encode(TEST_POST_DESC, "UTF-8") + "&";
        postData += URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(TEST_USER_USERNAME, "UTF-8");
        // TODO: What are you testing?
        // ConnectionManager.processRequest(TEST_URL + "post.php", postData);
    }
}
