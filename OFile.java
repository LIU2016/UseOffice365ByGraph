package com.tianwen.eeducation.airschool.util.office365.entity;

/**
 * <p>Title:OFile</p>
 * <p>Description:文件</p>
 * <p>Company:天闻数媒</p> 
 * @version $ [版本号, 2016年8月3日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 * @author lqd
 * @date 2016年10月26日 下午4:45:00
 * @doc
 */
public class OFile extends DriveItem
{
	private int size ;
	
	public int getSize()
	{
		return size;
	}
	public void setSize(int size)
	{
		this.size = size;
	}
}
