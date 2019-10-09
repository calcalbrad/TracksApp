package com.lostanimals.tracks;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import androidx.fragment.app.ListFragment;
import com.lostanimals.tracks.tasks.GetFollowedPostsTask;
import com.lostanimals.tracks.tasks.UpdatePostsTask;
import com.lostanimals.tracks.utils.PreferencesUtility;

import java.util.List;

public class FollowedPostsFragment extends ListFragment {
	private ProgressBar mProgressBar;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.followed_posts_fragment, container, false);
		mProgressBar = view.findViewById(R.id.progress_bar);

		GetFollowedPostsTask followedPosts = new GetFollowedPostsTask();

		followedPosts.execute(PreferencesUtility.getUserInfo().getUsername());

		List<String> postIds = followedPosts.getFollowedPosts();

//		Log.d("Post Ids", postIds.toString());

//		if (!postIds.isEmpty()) {
//			for (String string : postIds) {
//				new UpdatePostsTask(this, mProgressBar).execute("", string, "");
//			}
//		}

		return view;
	}
}