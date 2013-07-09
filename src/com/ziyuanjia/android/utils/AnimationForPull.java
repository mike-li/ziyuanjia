package com.ziyuanjia.android.utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;

/**
 * 视图上下动画效果
 * @author vendor
 *
 */
public class AnimationForPull {
	
	/** 动画的持续时间 */
	private int duration_ms = 150;
	
	private int delay_ms = 0;
	
	private TranslateAnimation mStartAnimation;
	
	private TranslateAnimation mStopAnimation;
	
	public AnimationForPull(){
		
	}
	
	/**
	 * 
	 *  函数名称 : setDuration
	 *  功能描述 : 设定动画的时间
	 *  参数及返回值说明：
	 *  	@param ms
	 *
	 *  修改记录：
	 *  	日期：2012-12-16 下午03:26:54	修改人：vendor
	 *  	描述	：
	 *
	 */
	public void setDuration(int ms){
		this.duration_ms = ms;
	}
	
	/**
	 *  函数名称 : setDelay
	 *  功能描述 : 设置延时启动动画
	 *  参数及返回值说明：
	 *  	@param ms
	 *
	 *  修改记录：
	 *  	日期：2013-1-31 上午10:35:44	修改人：vendor
	 *  	描述	：
	 *
	 */
	public void setDelay(int ms){
		this.delay_ms = ms;
	}
	
	/**
	 * 
	 *  函数名称 : start
	 *  功能描述 : 开始动画效果
	 *  参数及返回值说明：
	 *  	@param view
	 *
	 *  修改记录：
	 *  	日期：2012-12-16 上午10:58:06	修改人：vendor
	 *  	描述	：
	 *
	 */
	public void start(View view){
		final View v = view;
		
		int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED); 
		int h = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED); 
		view.measure(w, h); 
		
		if(null == mStartAnimation){
			mStartAnimation = new TranslateAnimation(
					TranslateAnimation.ABSOLUTE, 0,
					TranslateAnimation.ABSOLUTE, 0,
					TranslateAnimation.ABSOLUTE, -view.getMeasuredHeight(),
					TranslateAnimation.ABSOLUTE, 0
			);
			mStartAnimation.setDuration(duration_ms);
			mStartAnimation.setStartOffset(delay_ms);
			
			mStartAnimation.setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					v.setVisibility(View.VISIBLE);
				}

				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
		
		if(null == mStopAnimation){
			mStopAnimation = new TranslateAnimation(
					TranslateAnimation.ABSOLUTE, 0,
					TranslateAnimation.ABSOLUTE, 0,
					TranslateAnimation.ABSOLUTE, 0,
					TranslateAnimation.ABSOLUTE, -view.getMeasuredHeight()
			);
			mStopAnimation.setDuration(duration_ms);
			mStopAnimation.setStartOffset(delay_ms);
			
			mStopAnimation.setAnimationListener(new AnimationListener() {
				
				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub
					v.setVisibility(View.INVISIBLE);
				}
				
				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		
		if(v.getVisibility() == View.INVISIBLE  || v.getVisibility() == View.GONE){
			v.startAnimation(mStartAnimation);
		}else{
			v.startAnimation(mStopAnimation);
		}
	}
	
	/**
	 * 
	 *  函数名称 : stop
	 *  功能描述 : 结束动画效果
	 *  参数及返回值说明：
	 *  	@param view
	 *
	 *  修改记录：
	 *  	日期：2012-12-16 上午10:58:28	修改人：vendor
	 *  	描述	：
	 *
	 */
	public void stop(View view){
		start(view);
	}
}
