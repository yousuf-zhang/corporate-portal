USE mysql;
-- 为mysql创建用户：case_dev 密码为：pass123
CREATE USER 'society'@'localhost' IDENTIFIED BY 'szdaxh';
CREATE USER 'society'@'%' IDENTIFIED BY 'szdaxh';
-- 查看下用户case_dev的权限
SELECT *  FROM user  where user='society';
-- 删除用户
drop user 'society'@'localhost';
-- 给用户case_dev在数据库名
GRANT ALL ON *.* TO 'society'@'localhost';
GRANT ALL ON *.* TO 'society'@'%';
-- 生效
FLUSH PRIVILEGES;
-- 再次查询 下权限
SELECT *  FROM user WHERE user='society' ;
SHOW GRANTS FOR society;

-- 创建数据库
create database sina default character set utf8mb4 collate utf8mb4_unicode_ci;