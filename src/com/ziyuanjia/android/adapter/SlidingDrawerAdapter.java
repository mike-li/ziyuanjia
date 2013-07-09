package com.ziyuanjia.android.adapter;

import java.lang.ref.SoftReference;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.ziyuanjia.android.R;
import com.ziyuanjia.android.utils.ImageLoader;

public class SlidingDrawerAdapter extends BaseAdapter {
	
	/**
	 * 图片缓存
	 */
	private SparseArray<SoftReference<Bitmap>> sparseArray = new SparseArray<SoftReference<Bitmap>>();
	
	private Context context;
	private int[] resIds;
	
	public SlidingDrawerAdapter(Context context, int[] resIds) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.resIds = resIds;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return resIds.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		Holder holder = null;
		if(convertView == null){
			holder = new Holder();
			convertView = LayoutInflater.from(context).inflate(R.layout.building_item,null);
			holder.ivThumbnail = (ImageView)convertView.findViewById(R.id.ivBackground);
			convertView.setTag(holder);
		}else{
			holder = (Holder)convertView.getTag();
		}
		
		Bitmap bitmap = ImageLoader.readBitMap(context, resIds[position]);
		if(bitmap != null){
			sparseArray.append(resIds[position], new SoftReference<Bitmap>(bitmap));
			holder.ivThumbnail.setImageBitmap(bitmap);
		}
			
		return convertView;
	}
	
	public void clean(){
		try {
			for(int i = 0; i < sparseArray.size(); i++){
				Bitmap bitmap = sparseArray.valueAt(i).get();
				if(bitmap != null && !bitmap.isRecycled()){
					bitmap.recycle();
					bitmap = null;
				}
				sparseArray.removeAt(i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private final class Holder {
		private ImageView ivThumbnail;
	}
}
