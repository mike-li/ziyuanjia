package com.ziyuanjia.android;

import com.ziyuanjia.android.common.TitleToolBarCommon;
import com.ziyuanjia.android.utils.Network;
import com.ziyuanjia.android.widget.BaseActivity;

import android.app.Activity;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class WebViewActivity extends BaseActivity {
	private WebView webview;
	private TextView tv;
	String url = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.webview);
	}
	@Override
	protected void findView() {
		// TODO Auto-generated method stub
		// 初始化头部工具栏
		TitleToolBarCommon titleBarCommon = new TitleToolBarCommon(this);
		titleBarCommon.initToolBar(findViewById(R.id.includeHead));
		webview = (WebView) findViewById(R.id.webview);
		tv = (TextView) findViewById(R.id.tv_nonetwork);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		//判断网络情况
		if(Network.hasNetwork(WebViewActivity.this)){
			webview.setVisibility(View.VISIBLE);
		}else{
			tv.setVisibility(View.VISIBLE);
		}
		Bundle bundle = getIntent().getExtras();
		if (bundle.containsKey("url"))
			url = bundle.getString("url");
		webview.getSettings().setJavaScriptEnabled(true);
		webview.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
		webview.loadUrl(url);
	}

}
