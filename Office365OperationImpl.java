package com.tianwen.eeducation.airschool.util.office365.impl;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.tianwen.eeducation.airschool.util.office365.IOfficeOperation;
import com.tianwen.eeducation.airschool.util.office365.Office365Factory;
import com.tianwen.eeducation.airschool.util.office365.OneDriveUrl;
import com.tianwen.eeducation.airschool.util.office365.entity.Folder;
import com.tianwen.eeducation.airschool.util.office365.entity.OFile;

/**
 * <p>
 * Title:Office365OperationImpl
 * </p>
 * <p>
 * Description:OFFICE365
 * </p>
 * <p>
 * Company:天闻数媒
 * </p>
 * 
 * @version $ [版本号, 2016年8月3日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 * @author lqd
 * @date 2016年10月26日 下午3:46:24
 * @doc
 */
@Service("office365Api")
public class Office365OperationImpl implements IOfficeOperation
{
	@Resource(name = "office365Factory")
	private Office365Factory office365Factory;

	@Override
	public String getDefaultDrive(HttpServletRequest request) throws IOException
	{
		return null;
	}

	@Override
	public Folder getRoot(HttpServletRequest request) throws IOException
	{
		Object tokenObj = getToken(request);
		if (null != tokenObj)
		{
			String iToken = tokenObj.toString();
			String result = office365Factory.executeGet(iToken,OneDriveUrl.driveRoot());
			return JSON.parseObject(result, Folder.class);
		}
		return null;
	}

	@Override
	public String getChildren(String parent, HttpServletRequest request) throws IOException
	{
		return null;
	}

	@Override
	public String getPath(String path, HttpServletRequest request) throws IOException
	{
		return null;
	}

	@Override
	public String replaceFile(String parent, File file, HttpServletRequest request) throws IOException
	{
		return null;
	}

	@Override
	public OFile uploadFile(String parent, File file, HttpServletRequest request) throws IOException
	{
		Object tokenObj = getToken(request);
		if (null != tokenObj && null != file)
		{
			String fileName = file.getName() ;
			String iToken = tokenObj.toString();
			String result = office365Factory.executePut(iToken,OneDriveUrl.putContent(parent,fileName), file);
			return JSON.parseObject(result, OFile.class);
		}
		return null;
	}

	@Override
	public void download(String item, HttpServletRequest request, File target) throws IOException
	{

	}

	@Override
	public void delete(String remoteFile, HttpServletRequest request) throws IOException
	{

	}

	@Override
	public Folder createFolder(Folder folder, HttpServletRequest request) throws IOException
	{
		Object tokenObj = getToken(request);
		if (null != tokenObj && null != folder)
		{
			String data = JSON.toJSONString(folder);
			String iToken = tokenObj.toString();
			String result = office365Factory.executePost(iToken, OneDriveUrl.driveRootChildren(), data);
			return JSON.parseObject(result, Folder.class);
		}
		return null;
	}

	/**
	 * @Description:获取token[方法描述]
	 * @param request
	 * @return Object
	 * @exception: [违例类型]
	 *                 [违例说明]
	 * @author: lqd
	 * @time:2016年10月26日 下午4:38:04
	 */
	private Object getToken(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Object tokenObj = session.getAttribute("iToken");
		return tokenObj;
	}
}
