package com.ziyuanjia.android.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.Settings.Secure;


/************************************************************
 *  内容摘要	：<p> 获取用户的配置
 *
 *  作者	：vendor
 *  创建时间	：2013-1-31 下午4:13:05 
 *
 *  历史记录	:
 *  	日期	: 2013-1-31 下午4:13:05 	修改人：vendor
 *  	描述	:
 ************************************************************/
public class DbConfig {
	
	private final String DB_NAME = "config";
	
	private Context context;
	
	private SharedPreferences preferences;
	
	public DbConfig(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
		
		 preferences = context.getSharedPreferences(DB_NAME,Context.MODE_PRIVATE);
		
		init();
	}
	
	private void init(){
		if (preferences.getInt("sys_version", 0) == 0){
			Editor sharedata = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE).edit();
			sharedata.clear();
			sharedata.putInt("sys_version", android.os.Build.VERSION.SDK_INT);
			sharedata.putString("android_id", Secure.getString(context.getContentResolver(), Secure.ANDROID_ID));
			sharedata.putInt("ignore_version_code", 0);
			sharedata.putBoolean("isFirst", true);
			sharedata.putString("user", "");
			sharedata.putString("psw", "");
			sharedata.putString("nick", "");
			sharedata.putString("upload", "");
			sharedata.commit();
		}
	}
	
	/**
	 * 获取系统的版本 
	 * @return
	 */
	public int getSysVersion(){
		return preferences.getInt("sys_version", 0);
	}
	
	/**
	 * 获取手机唯一标识码 
	 * @return
	 */
	public int getAndroidId(){
		return preferences.getInt("android_id", 0);
	}
	
	/**
	 * 获取是否第一次进入app
	 * @return
	 */
	public Boolean getIsFirst(){
		return preferences.getBoolean("isFirst", false);
	}
	
	/**
	 * 设置是否第一次进入app
	 * @param b
	 */
	public void setIsFirst(Boolean b){
		Editor sharedata = preferences.edit();
		sharedata.putBoolean("isFirst", b);

		sharedata.commit();
	}
	
	/**
	 * 获取是用户名
	 * @return
	 */
	public String getUserName(){
		return preferences.getString("user", "");
	}
	
	/**
	 * 获取用户密码
	 * @return
	 */
	public String getPassword(){
		return preferences.getString("psw", "");
	}
	
	/**
	 * 获取是否第一次进入app
	 * @return
	 */
	public String getUpload(){
		return preferences.getString("upload", "");
	}
	
	/**
	 * 设置用户名密码
	 * @param b
	 */
	public void setUserConfig(String user, String psw){
		Editor sharedata = preferences.edit();
		sharedata.putString("user", user);
		sharedata.putString("psw", psw);

		sharedata.commit();
	}
	
	/**
	 * 设置头像上传
	 * @param b
	 */
	public void setUpload(String upload){
		Editor sharedata = preferences.edit();
		sharedata.putString("upload", upload);

		sharedata.commit();
	}
	
	/**
	 * 设置头像上传
	 * @param b
	 */
	public void setNick(String nick){
		Editor sharedata = preferences.edit();
		sharedata.putString("nick", nick);

		sharedata.commit();
	}
	
	/**
	 * 获取被忽略的版本号（只保存最新的版本） 
	 * @return
	 */
	public int getVersionIgnoreCode(){
		return preferences.getInt("ignore_version_code", 0);
	}
	
	/**
	 * 设置忽略的版本号 
	 * @param code
	 */
	public void setVersionIgnoreCode(int code){
		Editor sharedata = preferences.edit();
		sharedata.putInt("ignore_version_code", code);

		sharedata.commit();
	}
}
