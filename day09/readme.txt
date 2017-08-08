servlet：是运行在服务器中的Java小程序
配置文件，配置servlet信息。
编译：javac -d .Helloworld.java
报软件包不存在
set classpath=%classpath%;servlet-api.jar拖过来

servlet生命周期
	实例被创建，对外提供服务，销毁。Servlet中有一个方法去初始化Servlet,调用init方法完成初始化，只有首次访问web容器才创建，web容易调用servlet的service方法
	服务请求，从客户端发送的请求进行处理，service方法，再次请求，web服务器启动一个新的线程（线程安全问题）
	服务器中销毁，destroyed方法

Servlet接口-》GenericServletl类-》HttpServlet类继承了GenericServlet类-》MyServlet
如果想重写init,重写无参数的即可，因为最终有参数的还是调用的无参数的方法,servlice同理，调用的是httpservlet，重写dopost和doget方法
在doPost方法中调用doGet方法,避免代码重复，调用那个都行

修改servlet模板
	先找到安装路径，Common\plugins\com.genuitec.eclipse.wizards.xxx.jar.千万先别解压，用压缩工具打开，找到template下的servlet.java
	
servlet自动加载
通过配置，服务器启动，创建实例。实现自动加载
init做初始化的操作，非常耗时，
在web.xml中配置<load-on-startup>1</load-on-startup>
正整数越小优先级越高

servlet虚拟路径配置
<servlet-mapping><url-pattern>/demo5</url-pattern></servlet-mapping>
完全路径配置以/开头 /demo5
目录匹配         /* /abc/*
扩展名匹配，不能以/开头   *.do *.action
优先级：完全路径匹配>目录匹配>扩展名匹配
web开发中路径的问题
相对路径
不能以/开始，./demo demo ../demo
访问1.html 和访问demo5一样 ./demo5和demo5
绝对路径(推荐使用)
以/开头 /day09/demo5
客户端的绝对路径
/day09/demo5
服务端的绝对路径 /demo5 不写项目名字
ServletConfig对象
init(ServetConfig config)
String getServletName() 获取配置文件中Servlet的名称
String getInitParamter(String name) 获取初始化参数
Enumeration getInitParamterNames() 获取初始化参数

ServletContext对象（域对象）
代表当前web应用程序的，所有servlet程序共享同一个servletContext对象
作用：获取web应用全局初始化参数
实现数据共享，setAttribute(String name,Object object)
读取资源文件getResoureAsStream(String path),String getRealPath(String path)//绝对磁盘路径
==================================================================
HTTP协议
响应头location 和302一起完成重定向的操作
refresh页面的定时刷新
last-modefied和if-modefied-since和304状态吗一起控制缓存