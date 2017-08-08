c.tld 核心标签库   fn.tld  el表达式标签库  sq.tld 数据库标签库

jstl标签
<c:out>

<:import> var引入页面保存到变量中
<c:url>在jsp页面中构造一个URL地址，目的是实现URL重写。就是将会话标示号以参数形式附加在URL地址后面（追踪）cookie被禁用的情况下

<c:forTokens> 分割字符串

EL函数（操作字符串的）
自定义EL函数  编写一个Java类，方法必须是静态方法，在web-inf下创建tld文件，配置（）
自定义标签用于移除jsp页面中的Java代码，提高代码复用
实现simpleTag接口重写5个方法void setJspContext(JSPcONTEXT PC)        void  setParent（JSPTag parent） void setJspBody(jspFragment jspBody)   void doTag()
JSpTag getParent()
带有标签主题的自定义标签
jsp开发模式jsp+javabean jsp显示页面，使用Javabean封装和处理数据(model1时代)-----》jsp+servlet+javabean servlet处理请求，jsp显示数据，javabean封装数据和处理数据（model2）MVC
完成注册需求