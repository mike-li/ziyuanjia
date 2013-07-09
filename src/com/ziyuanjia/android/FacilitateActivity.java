package com.ziyuanjia.android;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.ziyuanjia.android.common.LeftToolBarCommon;
import com.ziyuanjia.android.common.TitleToolBarCommon;
import com.ziyuanjia.android.utils.AnimationForUp;
import com.ziyuanjia.android.widget.BaseActivity;

/**
 * 便民服务
 * @author vendor
 *
 */
public class FacilitateActivity extends BaseActivity implements OnClickListener {
	
	private View rlHotelsDetail;
	private View rlPhoneDetail;
	private View rlTicketDetail;
	private View rlWaterPaymentDetail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.facilitate_activity);
	}
	
	@Override
	protected void findView() {
		// TODO Auto-generated method stub
		findViewById(R.id.rlHotels).setOnClickListener(this);
		findViewById(R.id.rlPhone).setOnClickListener(this);
		findViewById(R.id.rlTicket).setOnClickListener(this);
		findViewById(R.id.rlWaterPayment).setOnClickListener(this);
		
		rlHotelsDetail = findViewById(R.id.rlHotelsDetail);
		rlHotelsDetail.setOnClickListener(null);
		rlPhoneDetail = findViewById(R.id.rlPhoneDetail);
		rlPhoneDetail.setOnClickListener(null);
		rlTicketDetail = findViewById(R.id.rlTicketDetail);
		rlTicketDetail.setOnClickListener(null);
		rlWaterPaymentDetail = findViewById(R.id.rlWaterPaymentDetail);
		rlWaterPaymentDetail.setOnClickListener(null);
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
		case R.id.rlHotels:
			initOtherView(rlHotelsDetail);
			animation.start(rlHotelsDetail);
			break;
		case R.id.rlPhone:
			initOtherView(rlPhoneDetail);
			animation.start(rlPhoneDetail);	
			break;
		case R.id.rlTicket:
			initOtherView(rlTicketDetail);
			animation.start(rlTicketDetail);
			break;
		case R.id.rlWaterPayment:
			initOtherView(rlWaterPaymentDetail);
			animation.start(rlWaterPaymentDetail);
			break;

		default:
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
			if(rlHotelsDetail.getVisibility() == View.VISIBLE && rlHotelsDetail != clickView){
				rlHotelsDetail.setVisibility(View.INVISIBLE);
			}
			if(rlPhoneDetail.getVisibility() == View.VISIBLE && rlPhoneDetail != clickView){
				rlPhoneDetail.setVisibility(View.INVISIBLE);
			}
			if(rlTicketDetail.getVisibility() == View.VISIBLE && rlTicketDetail != clickView){
				rlTicketDetail.setVisibility(View.INVISIBLE);
			}
			if(rlWaterPaymentDetail.getVisibility() == View.VISIBLE && rlWaterPaymentDetail != clickView){
				rlWaterPaymentDetail.setVisibility(View.INVISIBLE);
			}
		}
	}
}
