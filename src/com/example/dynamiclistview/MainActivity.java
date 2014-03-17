package com.example.dynamiclistview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private ListView m_ListView;
	private MyDataAdapter m_DataAdap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		m_ListView = (ListView)findViewById(R.id.list_view);
		
		initUI();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
        switch (item.getItemId()) 
        {
        	case R.id.action_change:
        	{
          
        		if ( null != m_DataAdap)
        		{
        			MyData data = m_DataAdap.getItem(7);
        			data.setContent("Focus on IOS, Android, Linux");
        			data.setName("~~~~~~~SW8 for Tainan~~~~~~~~");
        			data.setSelected(true);
        			
        			m_DataAdap.setChanged(7, data);
        		}
        		
                return true;
            }
           
        	default:
        		return super.onOptionsItemSelected(item);
        }
    } 
	
	
	/*@Override
	public Object onRetainNonConfigurationInstance() 
	{
		
	}*/
	
	public void initUI()
	{
		List<MyData> list = new ArrayList<MyData>();
		m_DataAdap = new MyDataAdapter(this, R.layout.listview_cell_1, R.layout.listview_cell_2, list);
		
		if ( null == list || null == m_DataAdap || null == m_ListView)
			return;
		
		list.add(new MyData(1, "SW1", "Windows Driver", false));
		list.add(new MyData(2, "SW2", "Windows UI", false));
		list.add(new MyData(3, "SW3", "Windows Streaming", false));
		list.add(new MyData(4, "SW4", "IOS", false));
		list.add(new MyData(5, "SW5", "Android", false));
		list.add(new MyData(6, "SW6", "ARM Driver", false));
		list.add(new MyData(7, "SW7", "MIPS Driver", false));
		list.add(new MyData(8, "SW8", "Linux AP", false));
		list.add(new MyData(9, "SW9", "Linux Daemon", false));
		list.add(new MyData(10, "SW10", "Linux driver", false));
		list.add(new MyData(11, "SW11", "Linux Streaming", false));
		list.add(new MyData(12, "SW12", "Linux Kernel", false));
		list.add(new MyData(13, "SW13", "UEC", false));
		list.add(new MyData(14, "SW14", "MIPS Driver", false));
		list.add(new MyData(15, "HW1", "HW Windows Driver", false));
		list.add(new MyData(16, "HW2", "HW Windows UI", false));
		list.add(new MyData(17, "HW3", "HW Windows Streaming", false));
		list.add(new MyData(18, "HW4", "HW IOS", false));
		list.add(new MyData(19, "HW5", "HW Android", false));
		list.add(new MyData(20, "HW6", "HW ARM Driver", false));
		list.add(new MyData(21, "HW7", "HW MIPS Driver", false));
		list.add(new MyData(22, "HW8", "HW Linux AP", false));
		list.add(new MyData(23, "HW9", "HW Linux Daemon", false));
		list.add(new MyData(24, "HW10", "HW Linux driver", false));
		list.add(new MyData(25, "HW11", "HW Linux Streaming", false));
		list.add(new MyData(26, "HW12", "HW Linux Kernel", false));
		list.add(new MyData(27, "HW13", "HW UEC", false));
		list.add(new MyData(28, "HW14", "HW MIPS Driver", false));
		
		m_ListView.setAdapter(m_DataAdap);
		m_ListView.setOnItemClickListener(new MyCellClick());
	}
	
	private class MyCellClick implements AdapterView.OnItemClickListener
	{
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int nPosition, long lId)
		{
			if ( null == m_DataAdap)
				return;
			
			MyData data = m_DataAdap.getItem(nPosition);
			
			if ( null != data)
			{
				data.setSelected(!data.IsSelected());
				m_DataAdap.setChanged(nPosition, data);
			}
		}
	}

}
