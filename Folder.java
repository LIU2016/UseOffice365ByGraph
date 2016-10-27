package com.tianwen.eeducation.airschool.util.office365.entity;

/**
 * <p>Title:Folder</p>
 * <p>Description:office365文件夹</p>
 * <p>Company:天闻数媒</p> 
 * @version $ [版本号, 2016年8月3日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 * @author lqd
 * @date 2016年10月26日 下午12:19:05
 * @doc
 */
public class Folder
{
	private ChildCount folder ;
	private SpecialFolder specialFolder ;
	
	public SpecialFolder getSpecialFolder()
	{
		return specialFolder;
	}
	public void setSpecialFolder(SpecialFolder specialFolder)
	{
		this.specialFolder = specialFolder;
	}
	public ChildCount getFolder()
	{
		return folder;
	}
	public void setFolder(ChildCount folder)
	{
		this.folder = folder;
	}
}
