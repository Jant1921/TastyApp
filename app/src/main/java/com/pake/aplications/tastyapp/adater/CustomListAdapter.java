package com.pake.aplications.tastyapp.adater;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.pake.aplications.tastyapp.R;
import com.pake.aplications.tastyapp.app.AppController;
import com.pake.aplications.tastyapp.model.Recipe;

import java.util.List;


//Based on http://www.androidhive.info/2014/07/android-custom-listview-with-image-and-text-using-volley/
//Android Custom ListView with Image and Text using Volley By Ravi Tamada . on July 28, 2014
public class CustomListAdapter extends BaseAdapter {
	private Activity activity;
	private LayoutInflater inflater;
	private List<Recipe> recipeItems;
	ImageLoader imageLoader = AppController.getInstance().getImageLoader();

	public CustomListAdapter(Activity activity, List<Recipe> recipeItems) {
		this.activity = activity;
		this.recipeItems = recipeItems;
	}

	@Override
	public int getCount() {
		return recipeItems.size();
	}

	@Override
	public Recipe getItem(int location) {
		return recipeItems.get(location);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (inflater == null)
			inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null)
			convertView = inflater.inflate(R.layout.list_row, null);

		if (imageLoader == null)
			imageLoader = AppController.getInstance().getImageLoader();
		NetworkImageView thumbNail = (NetworkImageView) convertView
				.findViewById(R.id.thumbnail);
		TextView title = (TextView) convertView.findViewById(R.id.title);
		TextView description = (TextView) convertView.findViewById(R.id.recipe_description);


		// getting movie data for the row
		Recipe r = recipeItems.get(position);

		// thumbnail image
		thumbNail.setImageUrl(r.getThumbnailUrl(), imageLoader);
		
		// title
		title.setText(r.getTitle());
		
		// description
		description.setText(String.valueOf(r.getDescription()));
		
		return convertView;
	}

}