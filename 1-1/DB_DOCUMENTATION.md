### items 
name|type|attribute
:---|:---|:---
id|bigint(20)|PK, Auto Increment, Not Null
title|varchar(255)|Not Null
price|int unsigned(11)|Not Null
description|varchar(255)| 
image_url|varchar(255)| 
updated_at | timestamp |Not Null, on update current_timestamp default current_timestamp
created_at|timestamp|default 0, Not Null

