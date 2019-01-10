## mysql> alter table tbl_photofile change PFNO PFNO INT(11) not null auto_increment;
Query OK, 2 rows affected (0.10 sec)
Records: 2  Duplicates: 0  Warnings: 0

## mysql> show table status where name = 'tbl_photofile';
+---------------+--------+---------+------------+------+----------------+-------------+-----------------+--------------+-----------+----------------+---------------------+---------------------+------------+-----------------+----------+----------------+--------------+
| Name          | Engine | Version | Row_format | Rows | Avg_row_length | Data_length | Max_data_length | Index_length | Data_free | Auto_increment | Create_time         | Update_time         | Check_time | Collation       | Checksum | Create_options | Comment      |
+---------------+--------+---------+------------+------+----------------+-------------+-----------------+--------------+-----------+----------------+---------------------+---------------------+------------+-----------------+----------+----------------+--------------+
| tbl_photofile | InnoDB |      10 | Dynamic    |    2 |           8192 |       16384 |               0 |        16384 |         0 |            101 | 2019-01-09 15:37:02 | 2019-01-09 16:05:38 | NULL       | utf8_general_ci |     NULL |                | 포토파일     |
+---------------+--------+---------+------------+------+----------------+-------------+-----------------+--------------+-----------+----------------+---------------------+---------------------+------------+-----------------+----------+----------------+--------------+
1 row in set (0.00 sec)


## mysql> delete from tbl_photofile where pfno=100;
Query OK, 1 row affected (0.01 sec)

## mysql> select*from tbl_photofile;
Empty set (0.00 sec)


## > alter table tbl_photofile AUTO_INCREMENT=1;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0

## mysql> show table status where name = 'tbl_photofile';
+---------------+--------+---------+------------+------+----------------+-------------+-----------------+--------------+-----------+----------------+---------------------+---------------------+------------+-----------------+----------+----------------+--------------+
| Name          | Engine | Version | Row_format | Rows | Avg_row_length | Data_length | Max_data_length | Index_length | Data_free | Auto_increment | Create_time         | Update_time         | Check_time | Collation       | Checksum | Create_options | Comment      |
+---------------+--------+---------+------------+------+----------------+-------------+-----------------+--------------+-----------+----------------+---------------------+---------------------+------------+-----------------+----------+----------------+--------------+
| tbl_photofile | InnoDB |      10 | Dynamic    |    1 |          16384 |       16384 |               0 |        16384 |         0 |              1 | 2019-01-09 16:15:28 | 2019-01-09 16:15:05 | NULL       | utf8_general_ci |     NULL |                | 포토파일     |
+---------------+--------+---------+------------+------+----------------+-------------+-----------------+--------------+-----------+----------------+---------------------+---------------------+------------+-----------------+----------+----------------+--------------+
1 row in set (0.00 sec)

## mysql> insert into tbl_photofile(PLNO,PHOTO) values(15,'aaa');
Query OK, 1 row affected (0.01 sec)

mysql> select*from tbl_photofile;
+------+------+-------+
| PFNO | PLNO | PHOTO |
+------+------+-------+
|    1 |   15 | aaa   |
+------+------+-------+
1 row in set (0.00 sec)

## mysql> insert into tbl_photofile(PLNO,PHOTO) values(3,'aaa');
Query OK, 1 row affected (0.01 sec)

mysql> select*from tbl_photofile;
+------+------+-------+
| PFNO | PLNO | PHOTO |
+------+------+-------+
|    1 |   15 | aaa   |
|    2 |    3 | aaa   |
+------+------+-------+
2 rows in set (0.00 sec)