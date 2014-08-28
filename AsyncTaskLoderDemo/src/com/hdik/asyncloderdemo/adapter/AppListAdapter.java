package com.hdik.asyncloderdemo.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hdik.asyncloderdemo.R;
import com.hdik.asyncloderdemo.models.AppEntry;

public class AppListAdapter extends ArrayAdapter<AppEntry> {
	private final LayoutInflater mInflater;

	public AppListAdapter(Context context) {
		super(context, android.R.layout.simple_list_item_2);
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public void setData(List<AppEntry> data) {
		clear();
		if (data != null) {
			for (AppEntry appEntry : data) {
				add(appEntry);
			}
		}
	}

	/**
	 * Populate new items in the list.
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;

		if (convertView == null) {
			view = mInflater.inflate(R.layout.list_items, parent, false);
		} else {
			view = convertView;
		}

		AppEntry item = getItem(position);
		((ImageView) view.findViewById(R.id.icon)).setImageDrawable(item
				.getIcon());
		((TextView) view.findViewById(R.id.text)).setText(item.getLabel());

		return view;
	}
}