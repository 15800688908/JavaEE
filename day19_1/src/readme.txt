tomcat内置连接池（dbcp只要创建一个context.xml配置文件，<context><Resource></Resource></context>）
1.在tomcat/conf/context.xml 这时给服务器使用
2.在Catalina/localhost下配置虚拟主机，只给虚拟主机用
3.将context.xml文件放在web/meta-info当前连接池只给本项目用 
全局设置，要把jar包放在tomact下的lib下

JNDI----->java命名目录接口   元数据（meta-data）数据库中库表列的定义信息DataBaseMetaData  ParameterMetaData参数元信息
ResutSetMetaData

dbutils工具 一个简单的jdbc封装工具
dbuitls核心：QueryRunner类 他是用于执行sql语句   ResultSetHandler接口用于定义结果集封装，它提供9个实现类，可以进行不同的封装
DbUtils提供关闭资源rollback 等