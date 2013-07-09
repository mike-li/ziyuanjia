package com.ziyuanjia.android.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public abstract class BaseActivity extends Activity {
	
	private Intent intent = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void setContentView(int layoutResID) {
		// TODO Auto-generated method stub
		super.setContentView(layoutResID);
		
		this.findView();
		this.initialize();
	}



	@Override
	public void setContentView(View view) {
		// TODO Auto-generated method stub
		super.setContentView(view);
		
		this.findView();
		this.initialize();
	}



	@Override
	public void setContentView(View view, LayoutParams params) {
		// TODO Auto-generated method stub
		super.setContentView(view, params);
		
		this.findView();
		this.initialize();
	}

	/**
	 * 监听控件 调用完setContentView之后马上调用
	 */
	protected abstract void findView();
	
	/**
	 * 初始化设定 调用完跟随findView之后调用
	 */
	protected abstract void initialize();
	
	/**
	 * 启动页面跳转
	 * @param cls
	 */
	public void startIntent(Class<?> cls) {
		this.startIntent(this, cls);
	}
	
	/**
	 * 启动页面跳转
	 * @param cls
	 */
	public void startIntent(Class<?> cls, Bundle bundle) {
		this.startIntent(this, cls, bundle);
	}
	
	/**
	 * 启动页面跳转
	 * @param context
	 * @param cls
	 */
	public void startIntent(Context context, Class<?> cls) {
		this.startIntent(context, cls, null);
	}
	
	/**
	 * 启动页面跳转
	 * @param context
	 * @param cls
	 * @param bundle
	 */
	public void startIntent(Context context, Class<?> cls, Bundle bundle) {
		intent = new Intent(context, cls);

		if (bundle!=null)
			intent.putExtras(bundle);
		
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}
}
