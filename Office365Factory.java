package com.tianwen.eeducation.airschool.util.office365;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.protocol.HTTP;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Title:Office365Factory
 * </p>
 * <p>
 * Description:office365-RESTFUL http REQUEST操作类
 * </p>
 * <p>
 * Company:天闻数媒
 * </p>
 * 
 * @version $ [版本号, 2016年8月3日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 * @author lqd
 * @date 2016年10月26日 上午10:18:36
 * @doc
 */
@Service("office365Factory")
public class Office365Factory
{
	private static final String	TOKEN_PREFIXX	= "Bearer ";

	private final static Log	logger			= LogFactory.getLog(Office365Factory.class);

	/**
	 * @Description:GET操作 [方法描述]
	 * @param token
	 *            获取登录时token
	 * @return String
	 * @exception: [违例类型]
	 *                 [违例说明]
	 * @author: lqd
	 * @time:2016年10月26日 上午10:14:34
	 */
	public String executeGet(String token, String url) throws IOException
	{
		HttpsURLConnection httpsConn = httpRequest(token, url);
		httpsConn.addRequestProperty(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=UTF-8");
		httpsConn.setDoOutput(true);
		int responseCode = httpsConn.getResponseCode();
		if (responseCode != 200)
		{
			logger.debug("responseCode:" + responseCode);

		} else
		{
			logger.warn("responseCode:" + responseCode);
		}
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsConn.getInputStream()));
		String text;
		StringBuilder sbuf = new StringBuilder();
		while ((text = bufferedReader.readLine()) != null)
		{
			sbuf.append(text);
		}
		return text;
	}

	/**
	 * @Description:设置请求公共参数 [方法描述]
	 * @param token
	 * @return
	 * @throws IOException
	 *             String
	 * @exception: [违例类型]
	 *                 [违例说明]
	 * @author: lqd
	 * @time:2016年10月26日 下午3:48:15
	 */
	private HttpsURLConnection httpRequest(String token, String url) throws MalformedURLException, IOException
	{
		URL myURL = new URL(url);
		HttpsURLConnection httpsConn = (HttpsURLConnection) myURL.openConnection();
		httpsConn.addRequestProperty("Accept", "*/*");
		httpsConn.addRequestProperty("X-Requested-With", "XMLHttpRequest");
		httpsConn.addRequestProperty("Authorization", TOKEN_PREFIXX + token);
		return httpsConn;
	}

	/**
	 * @Description:POST [方法描述]
	 * @param token
	 * @return
	 * @throws IOException
	 *             String
	 * @exception: [违例类型]
	 *                 [违例说明]
	 * @author: lqd
	 * @time:2016年10月26日 下午3:48:15
	 */
	public String executePost(String token, String url, String data) throws IOException
	{
		HttpsURLConnection httpsConn = httpRequest(token, url);
		httpsConn.setRequestProperty("Content-Length", String.valueOf(data.length()));
		httpsConn.setRequestProperty("Content-Type", "application/json");
		httpsConn.setRequestMethod("POST");
		httpsConn.setDoOutput(true);
		DataOutputStream out = new DataOutputStream(httpsConn.getOutputStream());
		out.writeBytes(data);
		int responseCode = httpsConn.getResponseCode();
		if (responseCode != 200)
		{
			logger.debug("responseCode:" + responseCode);

		} else
		{
			logger.warn("responseCode:" + responseCode);
		}
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsConn.getInputStream()));
		String text;
		StringBuilder sbuilder = new StringBuilder();
		while ((text = bufferedReader.readLine()) != null)
		{
			sbuilder.append(text);
		}
		return sbuilder.toString();
	}

	/**
	 * @Description:PUT [方法描述]
	 * @param token
	 * @return
	 * @throws IOException
	 *             String
	 * @exception: [违例类型]
	 *                 [违例说明]
	 * @author: lqd
	 * @time:2016年10月26日 下午3:48:15
	 */
	@SuppressWarnings("resource")
	public String executePut(String token, String url, File file) throws IOException
	{
		HttpsURLConnection httpsConn = httpRequest(token, url);
		httpsConn.setRequestProperty("Content-Type", "text/plain");
		httpsConn.setRequestMethod("PUT");
		httpsConn.setDoOutput(true);
		DataOutputStream out = new DataOutputStream(httpsConn.getOutputStream());
		FileInputStream fileInput = new FileInputStream(file);
		byte buffer[] = new byte[1024];
		int readBytes = 0;
		while ((readBytes = fileInput.read(buffer)) != -1)
		{
			out.write(buffer, 0, readBytes);
		}
		out.flush();
		out.close();
		int responseCode = httpsConn.getResponseCode();
		if (responseCode != 200)
		{
			logger.debug("responseCode:" + responseCode);

		} else
		{
			logger.warn("responseCode:" + responseCode);
		}
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsConn.getInputStream()));
		String text;
		StringBuilder sbuilder = new StringBuilder();
		while ((text = bufferedReader.readLine()) != null)
		{
			sbuilder.append(text);
		}
		return sbuilder.toString();
	}
}
