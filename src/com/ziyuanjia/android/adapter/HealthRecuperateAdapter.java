package com.ziyuanjia.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.ziyuanjia.android.BuildingSceneryActivity;
import com.ziyuanjia.android.HealthRecuperateDetailActivity;
import com.ziyuanjia.android.R;
import com.ziyuanjia.android.widget.BaseActivity;

public class HealthRecuperateAdapter extends BaseAdapter{
	
	private Context context;
	
	public HealthRecuperateAdapter(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 8;
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
			convertView = LayoutInflater.from(context).inflate(R.layout.health_recuperate_item,null);
			holder.btnDetail = (Button)convertView.findViewById(R.id.btnDetail);
			convertView.setTag(holder);
		}else{
			holder = (Holder)convertView.getTag();
		}
		
		holder.btnDetail.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				((BaseActivity)context).startIntent(HealthRecuperateDetailActivity.class);
			}
		});
		
		return convertView;
	}
	
	private final class Holder {
		public TextView tvTitle;
		public TextView tvContent;
		public Button btnDetail;
	}
}
