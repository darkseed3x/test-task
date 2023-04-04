insert into bundled_products(bundled_product_id,createdate,name, deleted, calls,sms,internet) values ('cdc153c2-d216-11ed-afa1-0242ac120002',current_timestamp,'kruul',true, 1, 1,1);
insert into bundled_products(bundled_product_id,createdate,name, deleted, calls,sms,internet) values ('e4b313ea-d216-11ed-afa1-0242ac120002',current_timestamp,'aaaaaa',false, 1, 0,1);
insert into bundled_products(bundled_product_id,createdate,name, deleted, calls,sms,internet) values ('ebfc4b62-d216-11ed-afa1-0242ac120002',current_timestamp,'sssssss',true, 1, 1,0);
insert into bundled_products(bundled_product_id,createdate,name, deleted, calls,sms,internet) values ('f0429ab4-d216-11ed-afa1-0242ac120002',current_timestamp,'ddddddddd',false, 1, -1,1);
insert into bundled_products(bundled_product_id,createdate,name, deleted, calls,sms,internet) values ('ff42c65d8-d216-11ed-afa1-0242ac120002',current_timestamp,'fffffff',true, 0, -1,1);

insert into tariffs(tariff_id,createdate,name, archived, deleted,bundled_product_id) values ('69442b9e-d217-11ed-afa1-0242ac120002',current_timestamp,'mmmmm',false, false, 'e4b313ea-d216-11ed-afa1-0242ac120002');
insert into tariffs(tariff_id,createdate,name, archived, deleted,bundled_product_id) values ('6de762ba-d217-11ed-afa1-0242ac120002',current_timestamp,'nnnnnn',true, true, 'ebfc4b62-d216-11ed-afa1-0242ac120002');
insert into tariffs(tariff_id,createdate,name, archived, deleted,bundled_product_id) values ('71b862e0-d217-11ed-afa1-0242ac120002',current_timestamp,'qwartet',false, true, 'f0429ab4-d216-11ed-afa1-0242ac120002');
insert into tariffs(tariff_id,createdate,name, archived, deleted,bundled_product_id) values ('76792594-d217-11ed-afa1-0242ac120002',current_timestamp,'vvvvvv',true, false, 'ff42c65d8-d216-11ed-afa1-0242ac120002');