package com.ziyuanjia.android.common;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.ziyuanjia.android.BookActivity;
import com.ziyuanjia.android.BuildingActivity;
import com.ziyuanjia.android.BuildingProvinceActivity;
import com.ziyuanjia.android.BuildingSceneryActivity;
import com.ziyuanjia.android.FacilitateActivity;
import com.ziyuanjia.android.FinalcialActivity;
import com.ziyuanjia.android.HealthActivity;
import com.ziyuanjia.android.HealthHospitalActivity;
import com.ziyuanjia.android.HealthRecuperateActivity;
import com.ziyuanjia.android.HealthRecuperateDetailActivity;
import com.ziyuanjia.android.HealthSpecialActivity;
import com.ziyuanjia.android.R;
import com.ziyuanjia.android.VipActivity;

public class LeftToolBarCommon {
	
	private Activity act;
	
	public LeftToolBarCommon(Activity act) {
		// TODO Auto-generated constructor stub
		this.act = act;
	}
	
	public void initToolBar(View view){
		View btnVip = view.findViewById(R.id.btnVip);
		btnVip.setOnClickListener(clickListener);
		
		View btnHealth = view.findViewById(R.id.btnHealth);
		btnHealth.setOnClickListener(clickListener);
		
		View btnFinalcing = view.findViewById(R.id.btnFinalcing);
		btnFinalcing.setOnClickListener(clickListener);
		
		View btnFacilitate = view.findViewById(R.id.btnFacilitate);
		btnFacilitate.setOnClickListener(clickListener);
		
		View btnBuilding = view.findViewById(R.id.btnBuilding);
		btnBuilding.setOnClickListener(clickListener);
		
		View btnBook = view.findViewById(R.id.btnBook);
		btnBook.setOnClickListener(clickListener);
		
		//设置哪个按钮不可用（选中的不可用）
		if(act != null){
			if(act instanceof VipActivity){
				btnVip.setEnabled(false);
			}else if(act instanceof HealthActivity){
				btnHealth.setEnabled(false);
			}else if(act instanceof HealthSpecialActivity){
				btnHealth.setEnabled(false);
			}else if(act instanceof HealthHospitalActivity){
				btnHealth.setEnabled(false);
			}else if(act instanceof HealthRecuperateActivity){
				btnHealth.setEnabled(false);
			}else if(act instanceof HealthRecuperateDetailActivity){
				btnHealth.setEnabled(false);
			}else if(act instanceof FinalcialActivity){
				btnFinalcing.setEnabled(false);
			}else if(act instanceof FacilitateActivity){
				btnFacilitate.setEnabled(false);
			}else if(act instanceof BuildingActivity){
				btnBuilding.setEnabled(false);
			}else if(act instanceof BuildingProvinceActivity){
				btnBuilding.setEnabled(false);
			}else if(act instanceof BuildingSceneryActivity){
				btnBuilding.setEnabled(false);
			}else if(act instanceof BookActivity){
				btnBook.setEnabled(false);
			}
		}
	}
	
	public OnClickListener getClickListener(){
		return clickListener;
	}
	
	OnClickListener clickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
				case R.id.btnVip:
					startIntentAndFinish(VipActivity.class);
					break;
				case R.id.btnHealth:
					startIntentAndFinish(HealthActivity.class);
					break;
				case R.id.btnFinalcing:
					startIntentAndFinish(FinalcialActivity.class);
					break;
				case R.id.btnFacilitate:
					startIntentAndFinish(FacilitateActivity.class);
					break;
				case R.id.btnBuilding:
					startIntentAndFinish(BuildingActivity.class);
					break;
				case R.id.btnBook:
					startIntentAndFinish(BookActivity.class);
					break;
				default :
					break;
			}
		}
	};
	
	/**
	 * 启动页面跳转并且执行页面关闭
	 * @param context
	 * @param cls
	 * @param bundle
	 */
	public void startIntentAndFinish(Class<?> cls) {
		Intent intent = new Intent(act, cls);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		act.startActivity(intent);
		
		act.overridePendingTransition(0, 0);
//		act.finish();
		act.overridePendingTransition(0, 0);
	}
}
