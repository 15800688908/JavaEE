虚拟主机设置  可以将项目部署到顶级域名
sever.xml 中端口修改为80 配置主机增加一个<Host>
<Host name="www.customer.com" appBase="D:\java\workspace\day19">
<Context path="" docBase="D:\java\wokspace\day19\WebRoot">

wind32下面的host设置 127.0.0.1  www.customer.com
myeclispe/web修改路径

id是vachar类型，他的获取问题  UUID工具类来获取
生日用日历组件 导入js在input组件上添加class和onclick

直接使用js操作不用表单.submit(),需要手动拼接url

select可以任意起名 option的value名称需要与customer表中的字段名称对应
特別注意sql的write

什麼是分頁分类1.物理分页  只从数据库中查询当前页的数据（靠谱）使用jdbc完成，使用滚动集， mysql:limit   sqlserver:top   oracle:rownum跨数据库性能低     使用数据库本身提供的分页操作
select * from custmer limit 0,3  第一个起始位置，第二个条数， 从0开始

创建一个分页Bean，封装相关数据如总页数，总条数等


2.逻辑分页  从数据库中将所有记录查询出来，存储到内存中    效率高，占有内存高记录多时


如何设置每页显示条数

