缺省servlet
在tomcat/conf/web.xml中的配置<param-value>true</param-value>
response对象,提供了重定向方法
响应：响应行 状态吗 void setStatus(int sc)
响应头：（key/value）
void setHeader()-个key对应一个value
void addHeader()对应多个value
void setIntHeader(String name,int value)
void setDateHeader(String name,long date)
void addIntHeader()
响应体
ServletOutputStream 

getOutputStream 字节
Printwriter getWriter()字符
禁用浏览器缓存（网银，页面数据一直在变化）
cache-control:no-cache
expires:-1 日期类型
pragma:no-cache
response输出中文乱码解决：字节（设置浏览器打开文件时所采用的编码） 获取字符串的byte数组采用的编码
字符（设置浏览器打开文件时所采用的编码）设置response缓冲区的编码，可以简写为一句
设置头信息：Content-Disposition  attachment;filename=文件名称以附件形式打开

验证码：先在内存中生成一张图片（画布，纸）BufferedImage(int width,int height,int imageType)
获取画笔对象Graphics getGraphics()
随机生成的，但是数据是准备好的随机生成四个字符 Random类 Math.random()
通过画笔对象把数字画到图片上drawString()
画干扰线drawLine()
把内存中图片输出到客户端ImageIO.write(RenderedImage im,String formatName,OutputStream ouput) BufferedIamge   jpg   response.getOutputStream()

request对象
servletRequest->HttpServletRequest
获取客户机的信息getRemoteAddr()获取IP地址 getMethod()获取请求方式 getContextPath()获取虚拟路径，默认是和项目名称相同 getQueryString()
请求头referer 记住当前网页的来源 user-agent 判断浏览器  if-modified-since 控制缓存
获取请求参数 getParameterValues(String name)      getParameter(String name) Map getParameterMap() Enumeration getParameterNames()

域对象servletContext    request一次请求的范围getRequestDispatcher(String path)   forward()转发  include()
重定向是两次请求 ，地址栏发生变化 ，可以定向到任何页面，甚至其他系统    转发是一次请求，所以可以使用request域对象，转发系统内部
