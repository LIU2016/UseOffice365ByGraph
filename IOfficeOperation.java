package com.tianwen.eeducation.airschool.util.office365;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.tianwen.eeducation.airschool.util.office365.entity.Folder;
import com.tianwen.eeducation.airschool.util.office365.entity.OFile;

/**
 * <p>Title:IOfficeOperation</p>
 * <p>Description:office365操作类</p>
 * <p>Company:天闻数媒</p> 
 * @version $ [版本号, 2016年8月3日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 * @author lqd
 * @date 2016年10月26日 上午10:29:28
 * @doc
 */
public interface IOfficeOperation
{
	// Read only operations
	/**
	 * @Description:获取子项[方法描述]
	 * @return
	 * @throws IOException
	 * String  
	 * @exception:   [违例类型] [违例说明]
	 * @author: lqd
	 * @time:2016年10月26日 上午10:38:56
	 */
    String getDefaultDrive(HttpServletRequest request) throws IOException;

    Folder getRoot(HttpServletRequest request) throws IOException;

    String getChildren(String parent ,HttpServletRequest request) throws IOException;

    String getPath(String path ,HttpServletRequest request) throws IOException;

    // Write operations

    String replaceFile(String parent, File file ,HttpServletRequest request) throws IOException;

    OFile uploadFile(String parent, File file ,HttpServletRequest request) throws IOException;

    void download(String item,HttpServletRequest request, File target) throws IOException;

    void delete(String remoteFile ,HttpServletRequest request) throws IOException;
    
    /**
     * @Description:创建office365文件夹 [方法描述]
     * @param folder
     * @return
     * @throws IOException
     * Folder  
     * @exception:   [违例类型] [违例说明]
     * @author: lqd
     * @time:2016年10月26日 下午4:17:01
     */
    Folder createFolder(Folder folder ,HttpServletRequest request) throws IOException;
}
