package com.example.dynamiclistview;

public class MyData {
	private int m_nID;
	private String m_strName;
	private String m_strContent;
	private boolean m_bIsSelected;
	
	public MyData(int nID, String strName, String strContent, boolean bIsSelected)
	{
		this.m_nID = nID;
		this.m_strName = strName;
		this.m_strContent = strContent;
		this.m_bIsSelected = bIsSelected;
	}

	
	public int getID()
	{
		return m_nID;
	}
	
	public String getName()
	{
		return m_strName;
	}
	
	public String getContent()
	{
		return m_strContent;
	}
	
	public boolean IsSelected()
	{
		return m_bIsSelected;
	}
	
	
	public void setID(int nID)
	{
		m_nID = nID;
	}
	
	public void setName(String strName)
	{
		m_strName = strName;
	}
	
	public void setContent(String strContent)
	{
		m_strContent = strContent;
	}
	
	public void setSelected(boolean bIsSelected)
	{
		m_bIsSelected = bIsSelected;
	}
}
