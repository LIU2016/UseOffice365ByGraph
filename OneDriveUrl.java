package com.tianwen.eeducation.airschool.util.office365;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class OneDriveUrl 
{
	private static final String rootUrl = "https://graph.microsoft.com/v1.0/me";

	public OneDriveUrl(String encodedUrl)
	{
	}

	public static String defaultDrive()
	{
		return rootUrl + "/drive";
	}

	/**
	 * @Description:驱动下文件夹信息（一般为Document，特殊文件夹） [方法描述]
	 * @return
	 * String  
	 * @exception:   [违例类型] [违例说明]
	 * @author: lqd
	 * @time:2016年10月26日 下午4:52:31
	 */
	public static String driveRoot()
	{
		return rootUrl + "/drive/root";
	}
	
	/**
	 * @Description:创建文件夹 [方法描述]
	 * @return
	 * String  
	 * @exception:   [违例类型] [违例说明]
	 * @author: lqd
	 * @time:2016年10月26日 下午4:54:22
	 */
	public static String driveRootChildren()
	{
		return rootUrl + "/drive/root/children" ;
	}

	public static String children(String id)
	{
		return rootUrl + "/drive/items/" + id + "/children";
	}

	/**
	 * @Description:上传文件资源[方法描述]
	 * @param id
	 * @param name
	 * @return
	 * String  
	 * @exception:   [违例类型] [违例说明]
	 * @author: lqd
	 * @time:2016年10月26日 下午4:53:25
	 */
	public static String putContent(String id, String name)
	{
		return rootUrl + "/drive/items/" + id + ":/" + encode(name) + ":/content";
	}

	public static String postMultiPart(String id)
	{
		return rootUrl + "/drive/items/" + id + "/children";
	}

	public static String createUploadSession(String id, String name)
	{
		return rootUrl + "/drive/items/" + id + ":/" + encode(name) + ":/upload.createSession";
	}

	public static String getPath(String path)
	{
		return rootUrl + "/drive/root:/" + encode(path).replace("%5C", "/");
	}

	public static String item(String id)
	{
		return rootUrl + "/drive/items/" + id;
	}

	public static String content(String id)
	{
		return rootUrl + "/drive/items/" + id + "/content";
	}

	/**
	 * @Description:查询驱动下内容[方法描述]
	 * @param query_search
	 * @return
	 * String  
	 * @exception:   [违例类型] [违例说明]
	 * @author: lqd
	 * @time:2016年10月26日 下午5:38:30
	 */
	public static String search(String query_search)
	{
		return rootUrl + "/drive/root/search(q='{"+query_search+"}')" ;
	}
	
	private static String encode(String url)
	{
		try
		{
			return URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			return "";
		}
	}
}
