package com.ziyuanjia.android.common;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.ziyuanjia.android.AboutActivity;
import com.ziyuanjia.android.BookActivity;
import com.ziyuanjia.android.BuildingActivity;
import com.ziyuanjia.android.BuildingProvinceActivity;
import com.ziyuanjia.android.FacilitateActivity;
import com.ziyuanjia.android.FinalcialActivity;
import com.ziyuanjia.android.GuideActivity;
import com.ziyuanjia.android.HealthActivity;
import com.ziyuanjia.android.MainActivity;
import com.ziyuanjia.android.R;
import com.ziyuanjia.android.VipActivity;

public class TitleToolBarCommon {
	
	private Activity act;
	
	public TitleToolBarCommon(Activity act) {
		// TODO Auto-generated constructor stub
		this.act = act;
	}
	
	public void initToolBar(View view){
		initToolBar(view, null);
	}
	
	public void initToolBar(View view, String title){
		View btnHome = view.findViewById(R.id.btnHome);
		btnHome.setOnClickListener(clickListener);
		
		View btnHistory = view.findViewById(R.id.btnHistory);
		btnHistory.setOnClickListener(clickListener);
		
		View btnHelp = view.findViewById(R.id.btnHelp);
		btnHelp.setOnClickListener(clickListener);
		
		View btnAbout = view.findViewById(R.id.btnAbout);
		btnAbout.setOnClickListener(clickListener);
		
		View btnBack = view.findViewById(R.id.btnBack);
		btnBack.setOnClickListener(clickListener);
		
		TextView tvTitle = (TextView)view.findViewById(R.id.tvModelTitle);
		
		if(title == null){
			//设置标题
			if(act != null){
				if(act instanceof MainActivity){
					tvTitle.setText(act.getResources().getString(R.string.app_name));
					btnHome.setEnabled(false);
					btnBack.setVisibility(View.INVISIBLE);
				}else if(act instanceof VipActivity){
					tvTitle.setText(act.getResources().getString(R.string.vip_area));
				}else if(act instanceof HealthActivity){
					tvTitle.setText(act.getResources().getString(R.string.health));
				}else if(act instanceof FinalcialActivity){
					tvTitle.setText(act.getResources().getString(R.string.financing));
				}else if(act instanceof FacilitateActivity){
					tvTitle.setText(act.getResources().getString(R.string.facilitate));
				}else if(act instanceof BuildingActivity){
					tvTitle.setText(act.getResources().getString(R.string.building));
				}else if(act instanceof BookActivity){
					tvTitle.setText(act.getResources().getString(R.string.book));
				}
			}
		}else{
			tvTitle.setText(title);
		}
	}
	
	private OnClickListener clickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
				case R.id.btnHome:
					startIntent(MainActivity.class);
					break;
				case R.id.btnBack:
					act.finish();
					break;
				case R.id.btnAbout:
					startIntent(AboutActivity.class);
					break;
				case R.id.btnHelp:
					startIntent(GuideActivity.class);
					break;
				case R.id.btnHistory:
					startIntent(GuideActivity.class);
					break;
				default:
					break;
			}
		}
	};
	
	/**
	 * 启动页面跳转
	 * @param context
	 * @param cls
	 * @param bundle
	 */
	public void startIntent(Class<?> cls) {
		Intent intent = new Intent(act, cls);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		act.startActivity(intent);
	}
}
