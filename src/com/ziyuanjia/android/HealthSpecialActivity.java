package com.ziyuanjia.android;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ziyuanjia.android.adapter.SlidingDrawerAdapter;
import com.ziyuanjia.android.common.LeftToolBarCommon;
import com.ziyuanjia.android.common.TitleToolBarCommon;
import com.ziyuanjia.android.utils.ImageLoader;
import com.ziyuanjia.android.widget.BaseActivity;

public class HealthSpecialActivity extends BaseActivity implements OnItemClickListener {
	
	private GridView gridView;
	
	private ImageView ivLargeImage;
	
	private TextView tvTitle;
	private TextView tvContext;
	
	private ScrollView scrollView;
	
	final int[] resIds = {R.drawable.health_special_01, R.drawable.health_special_02, 
			  R.drawable.health_special_03, R.drawable.health_special_04};
	
	final int[] resThumbnailIds = {R.drawable.health_special_thumbnail_01, R.drawable.health_special_thumbnail_02, 
			  R.drawable.health_special_thumbnail_03, R.drawable.health_special_thumbnail_04};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.health_special_activity);
	}

	@Override
	protected void findView() {
		// TODO Auto-generated method stub
		gridView = (GridView)findViewById(R.id.gridView);
		gridView.setOnItemClickListener(this);
		
		ivLargeImage = (ImageView)findViewById(R.id.ivLargeImage);
		
		scrollView = (ScrollView)findViewById(R.id.scrollView);
		
		tvTitle = (TextView)findViewById(R.id.tvTitle);
		tvContext = (TextView)findViewById(R.id.tvContent);
	}
	
	private SlidingDrawerAdapter adapter;
	
	private String[] arrTitle;
	private String[] arrContent;

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		//初始化头部工具栏
		TitleToolBarCommon titleBarCommon = new TitleToolBarCommon(this);
		titleBarCommon.initToolBar(findViewById(R.id.includeHead), "特色服务");
				
		//初始化左边工具栏，包含所有的单击事件处理
		//包含页面关闭代码，页面跳转效果代码
		LeftToolBarCommon barCommon = new LeftToolBarCommon(this);
		barCommon.initToolBar(findViewById(R.id.includeLeft));
		
		adapter = new SlidingDrawerAdapter(this, resThumbnailIds);
		gridView.setAdapter(adapter);
		
		arrTitle = getResources().getStringArray(R.array.health_special_title);
		arrContent = getResources().getStringArray(R.array.health_special_content);
		
		setIntro(0);
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
		// TODO Auto-generated method stub
		setIntro(position);
	}
	
	private Bitmap bitmap;
	private void setIntro(int position){
		scrollView.scrollTo(0, 0);
		
		tvTitle.setText(arrTitle[position]);
		tvContext.setText(arrContent[position]);
		
		if(bitmap != null && bitmap.isRecycled()){
			bitmap.recycle();
			bitmap = null;
		}
		bitmap = ImageLoader.readBitMap(this, resIds[position]);
		if(bitmap != null){
			ivLargeImage.setImageBitmap(bitmap);
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		if(adapter != null){
			adapter.clean();
		}
		
		if(bitmap != null && bitmap.isRecycled()){
			bitmap.recycle();
			bitmap = null;
		}
	}
}
