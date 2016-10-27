# UseOffice365ByGraph
使用Microsoft Graph调用操作Office365的案例

#1，Microsoft Graph简介
   Microsoft Graph：调用Microsoft API 的最简单方式 。Microsoft Graph（旧称“Office 365 统一 API”）通过一个 REST API 终结点从 Microsoft 云服务公开了多个 API。
您可以使用 API 访问固定实体，如用户、组、邮件、消息、日历、任务和注释（来自 Outlook、OneDrive、Azure Active Directory、Planner、OneNote 及其他服务）。您还可以获得由 Office Graph 强力驱动的计算关系（仅针对商业用户），如您要合作的用户列表或您常用的文档列表。Microsoft Graph 公开了两个终结点。公开发布的终结点 /v1.0 和预览终结点 /beta。你可以在你的生产应用程序中使用 /v1.0 但不能使用 /beta。我们通过预览终结点 /beta 提供最新功能以便开发人员进行试验并提供反馈，beta 版中的 API 可能会随时更改而且尚未准备好用于生产用途。

#2，使用流程：

2-1，	应用注册：
a),登录地址：https://apps.dev.microsoft.com/#/appList
b),添加应用：client_secret / client_id / redirect_uri / 权限 /  勾选Live SDK 支持 

2-2，	Azure AD 认证：

a),地址回调获取code，如下：
点击下面地址: 
https://login.microsoftonline.com/common/oauth2/v2.0/authorize?response_type=code&client_id=65241a86-9b8d-4856-8164-303455298a12&redirect_uri=http://localhost:8099/项目名/请求地址&scope=https://graph.microsoft.com/Files.ReadWrite
登陆后回调到自己的应用地址获取code
http://localhost:8099/airschool/OneDrive

b),请求https://login.microsoftonline.com/common/oauth2/v2.0/token地址获取token，这里必须带参数且采用https访问方式。
例如：请求代码
				String params = 															"client_id=65241a86-9b8d-4856-8164-303455298a12
				&redirect_uri=http://localhost:8099/项目名/请求地址&grant_type="+ PDConstant.GRANTTYPE + "&code=" + code + 								"&scope=https://graph.microsoft.com/Files.ReadWrite" + "&client_secret=OUMf8T5B0fSoJ4nikqbuTCS";
				String url = "https://login.microsoftonline.com/common/oauth2/v2.0/token";
				URL myURL = new URL(url);
				HttpsURLConnection httpsConn = (HttpsURLConnection) myURL
					.openConnection();
			httpsConn.addRequestProperty("Accept", "*/*");
			httpsConn.addRequestProperty("X-Requested-With", 										"XMLHttpRequest");
			httpsConn.addRequestProperty(HTTP.CONTENT_TYPE,
					"application/x-www-form-urlencoded; charset=UTF-8");
			httpsConn.setDoOutput(true);
			OutputStream os = httpsConn.getOutputStream();
			os.write(params.getBytes());
			bufferedReader = new BufferedReader(
					new InputStreamReader(httpsConn.getInputStream()));
			String text;
			while ((text = bufferedReader.readLine()) != null) 
			{
				response.getOutputStream().write(text.getBytes());
					JSONArray jsonArray = new JSONArray("["+text+"]");
					String token =  					                     					jsonArray.getJSONObject(0).getString("access_token");
				}
				
2-3，	API Restful 调用：通过令牌用https带GET/POST/PUT/DELETE等请求方式调用API操作数据。
			String iToken = "Bearer "+token ;
			BufferedReader bufferedReader1 = null;
			String url1 =  															"https://graph.microsoft.com/v1.0/me/drive/root/search(q='{名称}')";;
			//"https://graph.microsoft.com/v1.0/me/drive/root";
			URL myURL1 = new URL(url1);
			// 创建HttpsURLConnection对象，并设置其SSLSocketFactory对象
			HttpsURLConnection httpsConn1 = (HttpsURLConnection) myURL1
						.openConnection();
			httpsConn1.addRequestProperty("Accept", "*/*");
			httpsConn1.addRequestProperty("X-Requested-With", "XMLHttpRequest");
			httpsConn1.addRequestProperty(HTTP.CONTENT_TYPE,
			"application/x-www-form-urlencoded; charset=UTF-8");
				httpsConn1.addRequestProperty("Authorization", iToken);
        
#参考地址：Microsoft Graph官网地址：https://graph.microsoft.io/zh-cn 。
