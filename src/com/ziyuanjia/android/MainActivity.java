package com.ziyuanjia.android;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.ziyuanjia.android.common.TitleToolBarCommon;
import com.ziyuanjia.android.widget.BaseActivity;

/**
 * 主页
 * @author vendor
 *
 */
public class MainActivity extends BaseActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main_activity);
	}

	@Override
	protected void findView() {
		// TODO Auto-generated method stub
		findViewById(R.id.rlEducation).setOnClickListener(this);
		findViewById(R.id.rlFacilitate).setOnClickListener(this);
		findViewById(R.id.rlFinancial).setOnClickListener(this);
		findViewById(R.id.rlHealth).setOnClickListener(this);
		findViewById(R.id.rlBuilding).setOnClickListener(this);
		findViewById(R.id.rlMall).setOnClickListener(this);
		findViewById(R.id.rlBook).setOnClickListener(this);
		findViewById(R.id.rlVip).setOnClickListener(this);
		
		TitleToolBarCommon titleBarCommon = new TitleToolBarCommon(this);
		titleBarCommon.initToolBar(findViewById(R.id.includeHead));
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale); 
		switch (v.getId()) {
			case R.id.rlVip:
				v.startAnimation(animation);
				startIntent(VipActivity.class);
				break;
			case R.id.rlHealth:
				v.startAnimation(animation);
				startIntent(HealthActivity.class);
				break;
			case R.id.rlFacilitate:
				v.startAnimation(animation);
				startIntent(FacilitateActivity.class);
				break;
			case R.id.rlFinancial:
				v.startAnimation(animation);
				startIntent(FinalcialActivity.class);
				break;
			case R.id.rlBuilding:
				v.startAnimation(animation);
				startIntent(BuildingActivity.class);
				break;
			case R.id.rlBook:
				v.startAnimation(animation);
				startIntent(BookActivity.class);
				break;
			default :
				
				break;
		}
	}
}
