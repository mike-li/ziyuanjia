package com.ziyuanjia.android;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.ziyuanjia.android.db.DbConfig;
import com.ziyuanjia.android.widget.BaseActivity;

/**
 * 引导页
 * @author vendor
 *
 */
public class GuideActivity extends BaseActivity {
	
	private ViewPager viewPager;
	
	private ArrayList<View> pageViews;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.guide_activity);
	}

	@Override
	protected void findView() {
		// TODO Auto-generated method stub
		viewPager = (ViewPager)findViewById(R.id.viewPager);
	}
	
	private int[] guide_imgs = {R.drawable.guide_01, R.drawable.guide_02, R.drawable.guide_03, R.drawable.guide_05 };

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		pageViews = new ArrayList<View>();
		
		for(int i = 0; i < guide_imgs.length; i++){
			ImageView imageView = new ImageView(this);
			imageView.setBackgroundResource(guide_imgs[i]);
			pageViews.add(imageView);
			
			if(i == guide_imgs.length - 1){
				imageView.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						DbConfig dbConfig = new DbConfig(GuideActivity.this);
						if(dbConfig.getIsFirst()){
							dbConfig.setIsFirst(false);
							startIntent(MainActivity.class);
						}
						finish();
					}
				});
			}
		}
		
		viewPager.setAdapter(new GuidePageAdapter());
	}
	
	 /** 指引页面Adapter */
    class GuidePageAdapter extends PagerAdapter {  
    	  
        @Override  
        public int getCount() {  
            return pageViews.size();  
        }  
  
        @Override  
        public boolean isViewFromObject(View arg0, Object arg1) {  
            return arg0 == arg1;  
        }  
  
        @Override  
        public int getItemPosition(Object object) {  
            // TODO Auto-generated method stub  
            return super.getItemPosition(object);  
        }  
  
        @Override  
        public void destroyItem(View arg0, int arg1, Object arg2) {  
            // TODO Auto-generated method stub  
            ((ViewPager) arg0).removeView(pageViews.get(arg1));  
        }  
  
        @Override  
        public Object instantiateItem(View arg0, int arg1) {  
            // TODO Auto-generated method stub  
            ((ViewPager) arg0).addView(pageViews.get(arg1));  
            return pageViews.get(arg1);  
        }  
  
        @Override  
        public void restoreState(Parcelable arg0, ClassLoader arg1) {  
            // TODO Auto-generated method stub  
  
        }  
  
        @Override  
        public Parcelable saveState() {  
            // TODO Auto-generated method stub  
            return null;  
        }  
  
        @Override  
        public void startUpdate(View arg0) {  
            // TODO Auto-generated method stub  
  
        }  
  
        @Override  
        public void finishUpdate(View arg0) {  
            // TODO Auto-generated method stub  
  
        }  
    } 

}
