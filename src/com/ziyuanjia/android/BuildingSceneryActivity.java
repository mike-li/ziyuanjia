package com.ziyuanjia.android;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import com.ziyuanjia.android.adapter.BuildingSceneryAdapter;
import com.ziyuanjia.android.common.LeftToolBarCommon;
import com.ziyuanjia.android.common.TitleToolBarCommon;
import com.ziyuanjia.android.utils.AnimationForUp;
import com.ziyuanjia.android.widget.BaseActivity;

/**
 * 楼盘介绍
 * @author liangjie
 *
 */
public class BuildingSceneryActivity extends BaseActivity implements OnItemClickListener, OnClickListener {
	
	private GridView gridView;
	
	private HorizontalScrollView scrollView;
	
	private AnimationForUp animation;
	
	private LinearLayout llIntro;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.building_scenery_activity);
	}

	@Override
	protected void findView() {
		// TODO Auto-generated method stub
		gridView = (GridView)findViewById(R.id.gridView);
		gridView.setOnItemClickListener(this);
		
		llIntro = (LinearLayout)findViewById(R.id.llIntro);
		
		scrollView = (HorizontalScrollView)findViewById(R.id.scrollView);
		
		findViewById(R.id.btnProject).setOnClickListener(this);
		findViewById(R.id.btnEngineering).setOnClickListener(this);
		findViewById(R.id.btnHide).setOnClickListener(this);
		findViewById(R.id.btnLeft).setOnClickListener(this);
		findViewById(R.id.btnRight).setOnClickListener(this);
	}

	@Override
	protected void initialize() {
		//初始化头部工具栏
		TitleToolBarCommon titleBarCommon = new TitleToolBarCommon(this);
		titleBarCommon.initToolBar(findViewById(R.id.includeHead), "北大科技园");
				
		//初始化左边工具栏，包含所有的单击事件处理
		//包含页面关闭代码，页面跳转效果代码
		LeftToolBarCommon barCommon = new LeftToolBarCommon(this);
		barCommon.initToolBar(findViewById(R.id.includeLeft));
		
		LayoutParams linearParams = (LayoutParams)gridView.getLayoutParams();
		linearParams.width = 32 * 100;  //只有一个分辨率可以这样设置
		gridView.setLayoutParams(linearParams);
		
		gridView.setNumColumns(32);
		gridView.setColumnWidth(93);
		gridView.setAdapter(new BuildingSceneryAdapter(this));
		
		animation = new AnimationForUp();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnProject:
		case R.id.btnEngineering:
			animation.start(llIntro);
			break;
		case R.id.btnHide:
			animation.stop(llIntro);
			break;
		case R.id.btnLeft:
			scrollView.scrollBy(-700, 0);
			break;
		case R.id.btnRight:
			scrollView.scrollBy(700, 0);
			break;
		default:
			break;
		}
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "第"+(position + 1)+"张图显示", Toast.LENGTH_SHORT).show();
	}

}
