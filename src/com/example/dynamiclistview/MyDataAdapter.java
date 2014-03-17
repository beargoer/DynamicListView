package com.example.dynamiclistview;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class MyDataAdapter extends ArrayAdapter<MyData>{

	private final String TAG = "MyDataAdapter";
	private int m_nLayoutID;
	private int m_nLayoutID2;
	private List<MyData> m_List;
	
	
	public MyDataAdapter(Context context, int nLayoutID, int nLayoutID2,List<MyData> list)
	{
		super(context, nLayoutID, list);
		this.m_nLayoutID = nLayoutID;
		this.m_nLayoutID2 = nLayoutID2;
		this.m_List = list;
	}
	
	@Override 
	public View getView(int nPosition, View convertView, ViewGroup paraent)
	{
		///< nPostion is the item pos
		///< convertView is the item view
		///< parent is the ListView
		
		
		Log.i(TAG, "List View Pos : " + String.valueOf(nPosition));
		
		///< get Activity
		Context ctx = getContext();
		
		LinearLayout view;
		
		if ( null == convertView)
		{
			view = new LinearLayout(ctx);
			
			String inFlater = Context.LAYOUT_INFLATER_SERVICE;
			
			LayoutInflater layInf = (LayoutInflater)ctx.getSystemService(inFlater);
			
			if ( 0 == nPosition%2)
				layInf.inflate(m_nLayoutID, view, true);
			else
				layInf.inflate(m_nLayoutID2, view, true);
		}
		else
		{
			view = (LinearLayout)convertView;
		}
		
		MyData data = m_List.get(nPosition);
		
		TextView txtID = (TextView)view.findViewById(R.id.id);
		TextView txtName = (TextView)view.findViewById(R.id.name);
		TextView txtContent = (TextView)view.findViewById(R.id.contents);
		
		txtID.setText(Integer.toString(data.getID()));
		txtName.setText(data.getName());
		txtContent.setText(data.getContent());
		
		if ( 0 == nPosition%2)
		{
			CheckBox chkBox = (CheckBox)view.findViewById(R.id.chk);
			chkBox.setChecked(data.IsSelected());
		}
		else
		{
			RadioButton radio = (RadioButton)view.findViewById(R.id.radio);
			radio.setChecked(data.IsSelected());
		}
		
		return view;
	}
	
	@Override
	public int getViewTypeCount() 
	{
	   return 2; 
	}
	
	@Override
	public int getItemViewType(int nPosition) 
	{
	    return (nPosition%2);
	}
	
	public void setChanged(int nIdx, MyData data)
	{
		if ( 0 <= nIdx && nIdx < m_List.size())
		{
			m_List.set(nIdx, data);
			notifyDataSetChanged();
		}
	}
	
}
