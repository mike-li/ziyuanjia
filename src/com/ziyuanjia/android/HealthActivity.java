package com.ziyuanjia.android;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.ziyuanjia.android.adapter.HealthAdapter;
import com.ziyuanjia.android.common.LeftToolBarCommon;
import com.ziyuanjia.android.common.TitleToolBarCommon;
import com.ziyuanjia.android.widget.BaseActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

/**
 * 健康
 * @author vendor
 *
 */
public class HealthActivity extends BaseActivity implements OnClickListener {
	
	private ViewPager viewPager;
	
	private List<ImageView> imageViews; // 滑动的图片集合

	private int[] imageResId = new int[] {R.drawable.health_banner, R.drawable.health_banner_02, R.drawable.health_banner}; // 图片ID
	private List<View> dots; // 图片标题正文的那些点

	private int currentItem = 0; // 当前图片的索引号
	
	// An ExecutorService that can schedule commands to run after a given delay,
	// or to execute periodically.
	private ScheduledExecutorService scheduledExecutorService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.health_activity);
	}

	@Override
	protected void findView() {
		// TODO Auto-generated method stub
		viewPager = (ViewPager)findViewById(R.id.viewPager);
		viewPager.setOnClickListener(this);
		findViewById(R.id.rlTest).setOnClickListener(this);
		findViewById(R.id.rlVip).setOnClickListener(this);
		findViewById(R.id.rlSpecial).setOnClickListener(this);
		findViewById(R.id.rlHospital).setOnClickListener(this);
		findViewById(R.id.rlDrug).setOnClickListener(this);
		findViewById(R.id.rlRecuperate).setOnClickListener(this);
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
		
		// 设置一个监听器，当ViewPager中的页面改变时调用
		viewPager.setOnPageChangeListener(new MyPageChangeListener());
		
		imageViews = new ArrayList<ImageView>();
		dots = new ArrayList<View>();

		LinearLayout linearLayout = (LinearLayout)findViewById(R.id.llDot);  //标记点存放的容器
		
		// 初始化图片资源
		for (int i = 0; i < imageResId.length; i++) {
			ImageView imageView = new ImageView(this);
			imageView.setImageResource(imageResId[i]);
			imageView.setScaleType(ScaleType.CENTER_CROP);
			imageViews.add(imageView);
			
			ImageView imageDot = new ImageView(this);
			if(i != 0){
				imageDot.setBackgroundResource(R.drawable.health_doc_unselect);
			}else{
				imageDot.setBackgroundResource(R.drawable.health_doc_select);
			}
			imageDot.setScaleType(ScaleType.CENTER_CROP);
			linearLayout.addView(imageDot);
			dots.add(imageDot);
		}

		viewPager.setAdapter(new HealthAdapter(imageResId, imageViews));// 设置填充ViewPager页面的适配器
		// 设置一个监听器，当ViewPager中的页面改变时调用
		viewPager.setOnPageChangeListener(new MyPageChangeListener());
	}
	
	@Override
	protected void onStart() {
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		// 当Activity显示出来后，每两秒钟切换一次图片显示
		scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 3, TimeUnit.SECONDS);
		super.onStart();
	}

	@Override
	protected void onStop() {
		// 当Activity不可见的时候停止切换
		scheduledExecutorService.shutdown();
		super.onStop();
	}
	
	/**
	 * 换行切换任务
	 * 
	 * @author Administrator
	 * 
	 */
	private class ScrollTask implements Runnable {

		public void run() {
			synchronized (viewPager) {
				System.out.println("currentItem: " + currentItem);
				currentItem = (currentItem + 1) % imageViews.size();
				handler.obtainMessage().sendToTarget(); // 通过Handler切换图片
			}
		}
	}
	
	// 切换当前显示的图片
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			viewPager.setCurrentItem(currentItem);// 切换当前显示的图片
		};
	};
	
	/**
	 * 当ViewPager中页面的状态发生改变时调用
	 * 
	 * @author Administrator
	 */
	private class MyPageChangeListener implements OnPageChangeListener {
		private int oldPosition = 0;

		/**
		 * This method will be invoked when a new page becomes selected.
		 * position: Position index of the new selected page.
		 */
		public void onPageSelected(int position) {
			currentItem = position;
			dots.get(oldPosition).setBackgroundResource(R.drawable.health_doc_unselect);
			dots.get(position).setBackgroundResource(R.drawable.health_doc_select);
			oldPosition = position;
		}

		public void onPageScrollStateChanged(int arg0) {

		}

		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale); 
		v.startAnimation(animation);
		switch (v.getId()) {
		case R.id.viewPager:
			if(currentItem==0){
				Bundle bundle = new Bundle();
				bundle.putString("url", "www.sina.com.cn");
				startIntent(this, WebViewActivity.class, bundle);
			}else if(currentItem==1){
				Bundle bundle = new Bundle();
				bundle.putString("url", "www.sohu.com");
				startIntent(this, WebViewActivity.class, bundle);
			}else{
				Bundle bundle = new Bundle();
				bundle.putString("url", "www.163.com");
				startIntent(this, WebViewActivity.class, bundle);
			}
			break;
		case R.id.rlTest:
			
			break;
		case R.id.rlVip:
			
			break;
		case R.id.rlSpecial:
			startIntent(HealthSpecialActivity.class);
			break;
		case R.id.rlHospital:
			startIntent(HealthHospitalActivity.class);
			break;
		case R.id.rlDrug:
			
			break;
		case R.id.rlRecuperate:
			startIntent(HealthRecuperateActivity.class);
			break;
		default:
			break;
		}
	}
}
