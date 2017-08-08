事务在jdbc下操作：
java.sql.connection接口中有几个方法是用于操作事务的 setAutocommit（）
mysql下操作
方式1：start transaction 开启事务
          rollback 事务回滚
          commit 事务提交
  放式2：show variables like '%commit%' 可以查看当前autocommit值
          在mysq中默认是on   在oracle中默认是off
 事务特性：原子性 一致性 隔离性  永久性
 隔离性问题：1.脏读 一个事务读取到另一个事务的提交数据
 				2.不可重复读（两次读取的数据不一致update）
 				3.虚读（幻读）两次读取的数据不一致insert
 				4.丢失更新（两个事务对同一条记录进行操作，后提交的事务，将先提交的事务的修改覆盖了）
 通过设置事务的隔离级别来解决
 	1.Serializable可避免脏读、不可重复读、虚读情况的发生（串行化）锁表性能慢
 	2.Repeatable read可避免脏读、不可重复读情况的发生（可重复读）不可以避免虚读   --mysql默认
 	3.Read committed可避免脏读情况发生（读已提交）oracle默认
 	4.Read uncommitted最低级别，以上情况均无法保证
 mysql中 查看事务隔离级别select @@tx_isolation   set session transaction isolation level (read uncommitted)
 jdbc中con.setTransactionIsolation(int level) 
 实例 1.在A事务中
 		start transaction;
        update account set money=money-5 where name='Allen';
        update account set money=money+5 where name='Tom';
        2.在B事务中
        start transaction;
        select * from account;  这时，B事务读取时，会出现，钱已经汇完，那么就出现了脏读
        
        当A 事务提交前，执行rollback，在commit,B事务在查询，就会发现钱回复原样了，也出现了两次查询结国不一样，出现了不可重复读
        
 转账案例：
 
 
 丟失更新：悲观锁 利用数据库内部锁机制，管理事务（共享锁（读锁）lock in share model      排他锁（写锁）for update）update语句默认加排他锁
 				乐观锁 采用程序中添加版本字段控制timestamp特殊的属性，自动记录插入更新时间
 				
 连接池：datasource几个connection对象放到一起管理容器，重复利用
    