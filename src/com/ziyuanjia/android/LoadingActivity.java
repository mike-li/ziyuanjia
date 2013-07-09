package com.ziyuanjia.android;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.ziyuanjia.android.db.DbConfig;
import com.ziyuanjia.android.widget.BaseActivity;

/**
 * 启动页
 * @author vendor
 *
 */
public class LoadingActivity extends BaseActivity {
	
	private Handler handler;
	
	private ImageView ivLoading;
	
	private Bitmap bitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.loading_activity);
	}

	@Override
	protected void findView() {
		// TODO Auto-generated method stub
		ivLoading = (ImageView)findViewById(R.id.ivLoading);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		//优化方案
//		bitmap = ImageLoader.readBitMap(this, R.drawable.img_luncher);
//    	
//    	if(bitmap == null){
//			startIntent(this, MainActivity.class);
//			return;
//		}
//		
//    	ivLoading.setImageBitmap(bitmap);
    	
		handler = new Handler();
		//延迟启动
		handler.postDelayed(runnable, 3000);
	}
	
	private Runnable runnable = new Runnable() {

		@Override
		public void run() {
			Activity act = LoadingActivity.this;
			
			//如果是第一次登陆
			if(new DbConfig(LoadingActivity.this).getIsFirst()){
				startIntent(act, GuideActivity.class);
			}else{
				startIntent(act, MainActivity.class);
			}
			
			finish();
		}
	};

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		//清除这个回调  防止内存泄漏
		handler.removeCallbacks(runnable);
		
		if(bitmap != null){
			bitmap.recycle();
			bitmap = null;
		}
	}
}
