package com.swarna.android.employeeinfoguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.swarna.android.employeeinfoguide.models.EmployeeInfo;
import com.swarna.android.employeeinfoguide.restservice.VolleyHelper;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

	List<EmployeeInfo> employeeInfoList;
	LayoutInflater inflater;
	Context context;

	public CustomAdapter(Context context, List<EmployeeInfo> employeeInfoList) {
		this.context = context; 
		this.employeeInfoList = employeeInfoList;
		this.inflater = LayoutInflater.from(context);
	}

	public void setData(List<EmployeeInfo> employeeInfoList) {
		this.employeeInfoList = employeeInfoList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return employeeInfoList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return employeeInfoList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.list_item,null,false);

			holder.txtGuideName = (TextView) convertView.findViewById(R.id.txt_guide);
			holder.imgGuideIcon = (NetworkImageView) convertView.findViewById(R.id.img_guide);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		ImageLoader imageLoader = VolleyHelper.getInstance(context).getImageLoader();

		EmployeeInfo guideBook = employeeInfoList.get(position);

		holder.txtGuideName.setText(guideBook.getName());
		//		imageLoader.get(guideBook.getIcon(), listener)
		holder.imgGuideIcon.setImageUrl(guideBook.getIcon(), imageLoader);

		return convertView;
	}

	class ViewHolder {
		TextView txtGuideName;
		NetworkImageView imgGuideIcon;
	}

}
