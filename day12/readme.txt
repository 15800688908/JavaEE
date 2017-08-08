session的追踪
session 的创建和销毁 第一次访问资源，request.getSession()创建session
销毁	非正常关闭服务器， session 的过期，默认是30分钟  调用session.invalidate()手动销毁session
session的域对象 ServletContext :代表整个web应用，数据库连接       session：一次会话，存放个人信息  request 一次请求，存放错误处理

JSP语法  
脚本元素 <% %>  <%=%> <%!%>
页面注释 HTML的：<！--- ->              java的注释 //   /**/       /**  jsp文件阶段存在，翻译成Java文件也存在，在页面不存在        自己的注释<%----%>  之后再jsp文件阶段存在
jsp指令元素 用于指示jsp执行某些步骤，用于表现特定行为 <%@ 指令元素 属性名=属性值 %>
page  设置jsp的属性，只有import属性可以出现多次    language:jsp文件允许嵌入的语言，只支持一种Java            
extends jsp翻译成servlet文件，servlet继承的类
session 默认值是true，可以直接使用
import 引入Java的jar包
buffer 設置緩衝區的大小，默认8kb       autoflash 设置是否默认刷新缓冲区，默认true
errorpage 制定错误页面                 isErrorpage 默认是false设置值true之后，可以使用exception对象    可以配置全局的错误页面，在web.xml中进行配置
content Type服务器端输出所有内容采用的编码     pageEncoding:jsp翻译成servlet文件时采用的编码
isELIgnored="true" 是否忽略EL表达式

include  包含页面（页面布局）
<%@ include file="文件名（静态包含）"%>
taglib   引入标签库文件 <%taglib    uri="" prefix=""%>引入标签库，前缀名字

jsp内置的对象   
request   response  session   application   out  pageContext    page  config  exception
内置对象                                       真是对象													方法
request											HttpServletRequest									setAttribute() 
response										HttpServletResponse								addCookie()      getWrtier()
session                                         HtppSession											setAttribute
application									ServletContext										c
config											ServletConfig											getInitParameter()


exception										Thrownable												getMessage(0
和异常有关，前提条件把isErrorPage="true"
page												Object														一般不适用
当前页面对象
out											JSPWriter														wirte() print()
PrintWriter  response.getWriter().wirte()
out缓冲区先输出到response缓冲区
pageContext										PageContext											setAttribute
域对象 （自己可以存储值，向其他域对象中存取值）setAttribute(String name,Object value,int scope)   getAttribute(String name,int scope) findAttribute(String name)
  可以获取其他的8个对象，编写框架或者通用性较高的代码
  
  4个域对象 servletcontext  session  request  pageContext
  
  jsp标签（jsp的动作）避免直接写Java代码  jsp:useBean    jsp:setProperty   jsp:getProperty 把数据封装到Javabean中，在jsp页面完成
  jsp:forward 转发 jsp:include 页面的包含（动态包含,编译成了4个Java文件）  jsp;param  传递参数
  
  Javabean必须有一个无参的构造方法，属性私有化，通过public类型的方法暴露给其他程序，方法名字要遵循规范，封装数据的作用，对象
  
  
  內省  introspector   通過内省技术也可以访问JavaBean，基于反射的
  
  EL表达式  作用：获取域对象中的数据   执行运算 
  获取web开发中的对象
  pageScope    
  requestScope
  sessionScope
  applicationScope
  
  param 获取请求的参数 getParameter(）				 paramValues  获取请求的参数getParameterValues()
  header             headerValues
  initParam  获取初始化参数，是全局的         cookie      ${cookie.last.value}
  pageContext
  
  
    调用Java的方法