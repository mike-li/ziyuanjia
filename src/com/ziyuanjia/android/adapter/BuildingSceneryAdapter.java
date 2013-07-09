package com.ziyuanjia.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ziyuanjia.android.R;

public class BuildingSceneryAdapter extends BaseAdapter{
	
	private Context context;
	
	public BuildingSceneryAdapter(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 32;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		Holder holder = null;
		if(convertView == null){
			holder = new Holder();
			convertView = LayoutInflater.from(context).inflate(R.layout.building_scenery_item,null);
			convertView.setTag(holder);
		}else{
			holder = (Holder)convertView.getTag();
		}
		
		return convertView;
	}
	
	private final class Holder {
		public TextView tvTitle;
		public TextView tvContent;
	}
}
