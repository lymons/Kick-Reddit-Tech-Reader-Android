package com.nicktee.kick;

import java.util.List;

import models.Reddit;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RedditArrayAdapter extends ArrayAdapter<Reddit> {

	List<Reddit> reddits;
	Context ctxt;
	int mLayoutResourceId;

	public RedditArrayAdapter(Context c, int layoutResourceId,
			List<Reddit> redditList) {
		super(c, layoutResourceId);
		reddits = redditList;
		ctxt = c;
		mLayoutResourceId = layoutResourceId;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return reddits.size();
	}

	@Override
	public Reddit getItem(int position) {
		// TODO Auto-generated method stub
		return reddits.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {

		View row = view;

		final Reddit currentItem = getItem(position);

		if (row == null) {
			LayoutInflater inflater = ((Activity) ctxt).getLayoutInflater();
			row = inflater.inflate(mLayoutResourceId, parent, false);
		}
		
		// set the title
		final TextView textView = (TextView) row.findViewById(R.id.title);
		textView.setText(currentItem.getTitle());
		
		// set the sub text
		final TextView textView2 = (TextView) row.findViewById(R.id.desc);
		textView2.setText(currentItem.getAuthor_flair_text());
		
		// set the image
		final ImageView iconImg = (ImageView)row.findViewById(R.id.iconImg);
		//Load the image using the Picasso by Square lib, allows for image caching
		String imgUrl = currentItem.getThumbnail().toString();
		if (!imgUrl.contains("http")) imgUrl = "http://f.thumbs.redditmedia.com/hGUWW4cj-7ix49NY.jpg";
		Picasso.with(ctxt).load(imgUrl).into(iconImg);
		
		
		return row;
	}

}
