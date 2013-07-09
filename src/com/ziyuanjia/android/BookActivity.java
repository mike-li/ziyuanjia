package com.ziyuanjia.android;

import android.os.Bundle;

import com.ziyuanjia.android.common.LeftToolBarCommon;
import com.ziyuanjia.android.common.TitleToolBarCommon;
import com.ziyuanjia.android.widget.BaseActivity;

/**
 * 金融理财
 * @author vendor
 *
 */
public class BookActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.book_activity);
	}

	@Override
	protected void findView() {
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
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}
}
