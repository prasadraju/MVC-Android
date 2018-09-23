package com.prasad.mvc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.prasad.mvc.R;
import com.prasad.mvc.pojo.MoviesPostersData;
import com.prasad.mvc.servicemanger.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesDataAdapter extends BaseAdapter {

	private Context context;
	List<MoviesPostersData.Inner> moviePosterList;

	private class ViewHolder {
		ImageView gridIcon;
	}

	public MoviesDataAdapter(Context context, List<MoviesPostersData.Inner> moviePosterList) {

		this.moviePosterList=moviePosterList;
		this.context = context;

	}

	@Override
	public int getCount() {
		return moviePosterList.size();
	}

	@Override
	public Object getItem(int position) {
		return moviePosterList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {

		MoviesPostersData.Inner moviesData=moviePosterList.get(position);

		ViewHolder holder = null;
		if (view == null) {
			holder = new ViewHolder();
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.adapter_moviesdata,  parent,false);
			holder.gridIcon = (ImageView) view.findViewById(R.id.grid_icon);

			view.setTag(holder);

		} else
			holder = (ViewHolder) view.getTag();


		Picasso.with(context).load(Constants.POSTERMAIN_PATH + moviesData.getPoster_path())
				.placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(holder.gridIcon);

		return view;
	}
}
