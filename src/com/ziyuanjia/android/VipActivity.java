package com.ziyuanjia.android;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.ziyuanjia.android.common.LeftToolBarCommon;
import com.ziyuanjia.android.common.TitleToolBarCommon;
import com.ziyuanjia.android.utils.AnimationForUp;
import com.ziyuanjia.android.widget.BaseActivity;

/**
 * 专享区
 * @author vendor
 *
 */
public class VipActivity extends BaseActivity implements OnClickListener {
	
	private View rlChannelDetail;
	private View rlEvaluatingDetail;
	private View rlClassroomDetail;
	private View rlFavorableDetail;
	private View rlFrustDetail;
	private View rlHealthDetail;
	private View rlJobDetail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.vip_activity);
	}
	
	@Override
	protected void findView() {
		// TODO Auto-generated method stub
		findViewById(R.id.rlChannel).setOnClickListener(this);
		findViewById(R.id.rlEvaluating).setOnClickListener(this);
		findViewById(R.id.rlClassroom).setOnClickListener(this);
		findViewById(R.id.rlFavorable).setOnClickListener(this);
		findViewById(R.id.rlFrust).setOnClickListener(this);
		findViewById(R.id.rlHealth).setOnClickListener(this);
		findViewById(R.id.rlJob).setOnClickListener(this);
		
		rlChannelDetail = findViewById(R.id.rlChannelDetail);
		rlChannelDetail.setOnClickListener(null);  //这里设置主要是防止误点
		rlEvaluatingDetail = findViewById(R.id.rlEvaluatingDetail);
		rlEvaluatingDetail.setOnClickListener(null);
		rlClassroomDetail = findViewById(R.id.rlClassroomDetail);
		rlClassroomDetail.setOnClickListener(null);
		rlFavorableDetail = findViewById(R.id.rlFavorableDetail);
		rlFavorableDetail.setOnClickListener(null);
		rlFrustDetail = findViewById(R.id.rlFrustDetail);
		rlFrustDetail.setOnClickListener(null);
		rlHealthDetail = findViewById(R.id.rlHealthDetail);
		rlHealthDetail.setOnClickListener(null);
		rlJobDetail = findViewById(R.id.rlJobDetail);
		rlJobDetail.setOnClickListener(null);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		//初始化头部工具栏
		TitleToolBarCommon titleBarCommon = new TitleToolBarCommon(this);
		titleBarCommon.initToolBar(findViewById(R.id.includeHead));
				
		//初始化左边工具栏，包含所有的单击事件处理
		//包含页面关闭代码，页面跳转效果代码
		LeftToolBarCommon barCommon = new LeftToolBarCommon(this);
		barCommon.initToolBar(findViewById(R.id.includeLeft));
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		AnimationForUp animation = new AnimationForUp();
		switch (v.getId()) {
			case R.id.rlChannel:
				initOtherView(rlChannelDetail);
				animation.start(rlChannelDetail);
				break;
			case R.id.rlEvaluating: 
				initOtherView(rlEvaluatingDetail);
				animation.start(rlEvaluatingDetail);
				break;
			case R.id.rlClassroom:
				initOtherView(rlClassroomDetail);
				animation.start(rlClassroomDetail);
				break;
			case R.id.rlFavorable:
				initOtherView(rlFavorableDetail);
				animation.start(rlFavorableDetail);
				break;
			case R.id.rlFrust:
				initOtherView(rlFrustDetail);
				animation.start(rlFrustDetail);
				break;
			case R.id.rlHealth:
				initOtherView(rlHealthDetail);
				animation.start(rlHealthDetail);
				break;
			case R.id.rlJob:
				initOtherView(rlJobDetail);
				animation.start(rlJobDetail);
				break;
			default :
				finish();
				break;
		}
	}
	
	/**
	 * 初始化所有的消息框的view
	 * @param oldView
	 * @param newView
	 */
	private void initOtherView(View clickView){
		if(clickView != null){
			if(rlChannelDetail.getVisibility() == View.VISIBLE && rlChannelDetail != clickView){
				rlChannelDetail.setVisibility(View.INVISIBLE);
			}
			if(rlEvaluatingDetail.getVisibility() == View.VISIBLE && rlEvaluatingDetail != clickView){
				rlEvaluatingDetail.setVisibility(View.INVISIBLE);
			}
			if(rlClassroomDetail.getVisibility() == View.VISIBLE && rlClassroomDetail != clickView){
				rlClassroomDetail.setVisibility(View.INVISIBLE);
			}
			if(rlFavorableDetail.getVisibility() == View.VISIBLE && rlFavorableDetail != clickView){
				rlFavorableDetail.setVisibility(View.INVISIBLE);
			}
			if(rlFrustDetail.getVisibility() == View.VISIBLE && rlFrustDetail != clickView){
				rlFrustDetail.setVisibility(View.INVISIBLE);
			}
			if(rlHealthDetail.getVisibility() == View.VISIBLE && rlHealthDetail != clickView){
				rlHealthDetail.setVisibility(View.INVISIBLE);
			}
			if(rlJobDetail.getVisibility() == View.VISIBLE && rlJobDetail != clickView){
				rlJobDetail.setVisibility(View.INVISIBLE);
			}
		}
	}
}
