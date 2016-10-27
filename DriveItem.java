package com.tianwen.eeducation.airschool.util.office365.entity;

/**
 * <p>Title:DriveItem</p>
 * <p>Description:驱动下资源实体类</p>
 * <p>Company:天闻数媒</p> 
 * @version $ [版本号, 2016年8月3日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 * @author lqd
 * @date 2016年10月26日 下午4:50:24
 * @doc
 */
public class DriveItem
{
	private String name ;
	private String id ;
	private String webUrl ;
	private ParentReference parentReference ;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getWebUrl()
	{
		return webUrl;
	}
	public void setWebUrl(String webUrl)
	{
		this.webUrl = webUrl;
	}
	public ParentReference getParentReference()
	{
		return parentReference;
	}
	public void setParentReference(ParentReference parentReference)
	{
		this.parentReference = parentReference;
	}
}
