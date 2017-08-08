Servlet/jsp 是两种动态的web资源的两种技术
使用servlet生成HTML页面response.getWriter("<form action='' method='post'>");
response.getWriter("<input type='text'>")
jsp在服务器端执行，运行原理jsp翻译成一个servlet进行编译

jsp的脚本元素<%!  %> 定义类，方法都可以,成员变量等，不常用的原因是servlet是线程不安全的  <%=%>输出语句 ，不能有分号 <% %> 定义变量，语句
EL表達式：获取域对象中的内容request.setAttribute("xx","y")               ${xx}

两个会话技术
会话：打开浏览器，可以访问web资源，多次访问资源，关闭浏览器，整个过程是一次会话
cookie技术（客户端技术，不安全，大小个数有限制） session（服务器端技术），基于cookie的
第一次访问，输出欢迎，在服务器端记录当前时间，然后通过cookie回写到浏览器，第二次访问，会带着上次的时间，输出上次的访问时间
Cookie的構造方法Cookie(String name,String value)  getName() getValue()
void setMaxAge(int expiry) 设置有效时间   void setPath(Strig uri) 设置有效路径 ,默认路径是/day11 ,决定哪些可以使用cookie
setDomain(String pattern )设置有效域名 www.sina.com.cn sports.sina.com.cn 

session域对象，范围一次会话的范围，存个人数据String getId()获取session的唯一ID       void invalidate()销毁session 

完成简单的购物车:购物车   Map<String,Integer> cart 把购物车存入到session中