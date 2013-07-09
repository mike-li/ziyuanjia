package com.ziyuanjia.android;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.ziyuanjia.android.adapter.BuildingProvinceAdapter;
import com.ziyuanjia.android.common.LeftToolBarCommon;
import com.ziyuanjia.android.common.TitleToolBarCommon;
import com.ziyuanjia.android.widget.BaseActivity;
import com.ziyuanjia.android.widget.PullDownView;
import com.ziyuanjia.android.widget.PullDownView.OnPullDownListener;

/**
 * 省份楼盘的信息
 * @author liangjie
 *
 */
public class BuildingProvinceActivity extends BaseActivity implements OnItemClickListener, OnPullDownListener {
	
	private ListView listView1;
	
	private PullDownView pullDownView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.building_province_activity);
	}

	@Override
	protected void findView() {
		// TODO Auto-generated method stub
//		listView = (ListView)findViewById(R.id.listView);
//		listView.setOnItemClickListener(this);
		
		pullDownView = (PullDownView)findViewById(R.id.pullDownView);
		pullDownView.setDividerHeight(30);
		pullDownView.setOnItemClickListener(this);
	}

	@Override
	protected void initialize() {
		//初始化头部工具栏
		TitleToolBarCommon titleBarCommon = new TitleToolBarCommon(this);
		titleBarCommon.initToolBar(findViewById(R.id.includeHead), "北京");
				
		//初始化左边工具栏，包含所有的单击事件处理
		//包含页面关闭代码，页面跳转效果代码
		LeftToolBarCommon barCommon = new LeftToolBarCommon(this);
		barCommon.initToolBar(findViewById(R.id.includeLeft));
		
		pullDownView.setAdapter(new BuildingProvinceAdapter(this));
		pullDownView.setOnPullDownListener(this);
	}
	

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		updateData();
	}

	@Override
	public void onMore() {
		// TODO Auto-generated method stub
		/** 关闭 刷新完毕 ***/
		updateData();
	}
	
	private void updateData(){
		pullDownView.RefreshComplete();
		pullDownView.notifyDidMore();
		
		Toast.makeText(this, "暂无更新", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
		// TODO Auto-generated method stub
		
	}
}
