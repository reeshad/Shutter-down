package com.example.listviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	
	
	String [] i;
	Context ctx;
	int[] img;
	
	public MyAdapter(Context ctx,String[] i, int[] img) {
		super();
		this.i = i;
		this.ctx = ctx;
		this.img = img;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return i.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return img[position];
	}
	
	public Object getItem2(int position) {
		// TODO Auto-generated method stub
		return i[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		convertView = LayoutInflater.from(ctx).inflate(R.layout.list_item,parent,false);
		

		
		TextView tv1 = (TextView) convertView.findViewById(R.id.textView1);
		tv1.setText(i[position]);
		ImageView iv1 = (ImageView) convertView.findViewById(R.id.imageView1);
		iv1.setImageResource(img[position]);
		return convertView;
	}
	

}
