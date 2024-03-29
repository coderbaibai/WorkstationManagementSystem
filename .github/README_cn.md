# <div align="center">智能工位管理系统</div>
<div align="center">
    <img src="imgs/workStation.png" width="850">
    <p>
        智能工位管理系统的设计与实现
    </p>
    <p>
        测试中
    </p>

[English](../../..) | 简体中文
</div>
<details open>
<summary>依赖</summary>

- [JDK: 1.8+](https://www.oracle.com/java/technologies/downloads)
- [mySQL: 8.0+](https://www.mysql.com)
- [IDEA: 2022+](https://www.jetbrains.com/idea)
- [operating system: linux/windows10]()
</details>

<details open>
<summary>构建</summary>
在命令行输入以下指令来初始化数据库，以便自行测试

登录mysql
```
mysql -uroot -p
```
然后输入密码

建立一个名为workstationManager的用户，密码必须设置成1234.
```
CREATE USER 'workstationManager'@'localhost' IDENTIFIED BY '1234';
```
建立一个新的数据数据库
```
create database workstationManagement;
```
赋予用户权限
```
grant all privileges on workstationManagement.* to workstationManager;
```
重新登录mysql
```
exit;
mysql -uworkstationManager -p1234
```
建立一张新的表
```
use workstationManagement;
CREATE TABLE Account(
    userName VARCHAR(10) primary key,
    password VARCHAR(32) NOT NULL
);
```
</details>
