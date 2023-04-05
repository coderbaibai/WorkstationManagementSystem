# <div align="center">Workstation Management System</div>
<div align="center">
    <img src=".github/imgs/workStation.png" width="850">
    <p>
        Design and Implementation of an Intelligent Workstation Management System.
    </p>
    <p>
        testing
    </p>

English | [简体中文](.github/README_cn.md)
</div>

<details open>
<summary>Dependencies</summary>

<!-- names of dependencies and websites if had -->
- [JDK: 1.8+](https://www.oracle.com/java/technologies/downloads)
- [mySQL: 8.0+](https://www.mysql.com)
- [IDEA: 2022+](https://www.jetbrains.com/idea)
- [operating system: linux/windows10]()
</details>

<details open>
<summary>Build</summary>
To test the project, you are supposed to execute the command on your shell.

Login your own mysql DBMS.
```
mysql -uroot -p
```
Then input your password.

create a user named workstationManager and set password with 1234.Then exit.
```
CREATE USER 'workstationManager'@'localhost' IDENTIFIED BY '1234';
```
create a new database.
```
create database workstationManagement;
```
grant privileges to user.
```
grant all privileges on workstationManagement.* to workstationManager;
```
reload
```
exit;
mysql -uworkstationManager -p1234
```
create a new table.
```
use workstationManagement;
CREATE TABLE Account(
    userName VARCHAR(10) primary key,
    password VARCHAR(32) NOT NULL
);
```
</details>
