package com.ziyuanjia.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.ziyuanjia.android.R;

public class BuildingGridAdapter extends BaseAdapter {
	
	private Context context;
	private int[] resIds = new int[] {R.drawable._building_beijing, R.drawable._building_shanghai, R.drawable._building_wuhan, R.drawable._building_guangzhou,
										R.drawable._building_beijing, R.drawable._building_shanghai, R.drawable._building_wuhan, R.drawable._building_guangzhou}; // 图片ID
	
	public BuildingGridAdapter(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return resIds.length;
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
			convertView = LayoutInflater.from(context).inflate(R.layout.building_item,null);
			holder.ivBackground = (ImageView)convertView.findViewById(R.id.ivBackground);
			convertView.setTag(holder);
		}else{
			holder = (Holder)convertView.getTag();
		}
		
		holder.ivBackground.setBackgroundResource(resIds[position]);
		
			
		return convertView;
	}
	
	private final class Holder {
		private ImageView ivBackground;
	}
}
