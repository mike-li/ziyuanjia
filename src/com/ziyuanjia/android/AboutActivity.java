package com.ziyuanjia.android;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.ziyuanjia.android.widget.BaseActivity;

/**
 * 关于
 * @author vendor
 *
 */
public class AboutActivity extends BaseActivity {
	
	private ImageView ivLoading;
	
	private Bitmap bitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.about_activity);
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
		
		ivLoading.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		if(bitmap != null){
			bitmap.recycle();
			bitmap = null;
		}
	}
}
