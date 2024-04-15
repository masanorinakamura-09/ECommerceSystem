/*INSERT INTO category(category_name,category_id,sub_category_name,sub_category_id)VALUES("食品",00,"肉",0001);
INSERT INTO category(category_name,category_id,sub_category_name,sub_category_id)VALUES("食品",00,"お菓子",0002);
INSERT INTO category(category_name,category_id,sub_category_name,sub_category_id)VALUES("薬剤",01,"洗剤",0001);
INSERT INTO category(category_name,category_id,sub_category_name,sub_category_id)VALUES("食品",00,"酒",0099);
INSERT INTO category(category_name,category_id,sub_category_name,sub_category_id)VALUES("文房具",02,"鉛筆",0001);
INSERT INTO category(category_name,category_id,sub_category_name,sub_category_id)VALUES("文房具",02,"紙",0001);
INSERT INTO category(category_name,category_id,sub_category_name,sub_category_id)VALUES("家電",03,"電球",0001);
INSERT INTO category(category_name,category_id,sub_category_name,sub_category_id)VALUES("家電",03,"電池",0002);
INSERT INTO category(category_name,category_id,sub_category_name,sub_category_id)VALUES("家電",03,"インク",0003);*/




INSERT INTO merchandise(name,category,price,stock)VALUES("肉","食品",500,10);
INSERT INTO merchandise(name,category,price,stock)VALUES("お菓子","食品",100,5);
INSERT INTO merchandise(name,category,price,stock)VALUES("食器洗い用洗剤","薬剤",800,20);
INSERT INTO merchandise(name,category,price,stock)VALUES("ハンドソープ","薬剤",300,8);
INSERT INTO merchandise(name,category,price,stock)VALUES("バーボン","お酒",2000,30);
INSERT INTO merchandise(name,category,price,stock)VALUES("ボンベイ","お酒",2500,21);
INSERT INTO merchandise(name,category,price,stock)VALUES("鉛筆","文房具",200,100);
INSERT INTO merchandise(name,category,price,stock)VALUES("ノート","文房具",400,60);
INSERT INTO merchandise(name,category,price,stock)VALUES("電球","家電",900,78);
INSERT INTO merchandise(name,category,price,stock)VALUES("電池","家電",1100,87);
INSERT INTO merchandise(name,category,price,stock)VALUES("インク","家電",5000,21);

INSERT INTO customer(age,name,post_code,telephone_number,address,email,prefectural,gender,cash)
VALUES(30,"吉田",8886666,0800909,"郡山市朝霞町111","emailaddress","福島県","男性",20000);
INSERT INTO customer(age,name,post_code,telephone_number,address,email,prefectural,gender,cash)
VALUES(35,"梶田",8886666,0800909,"郡山市朝霞町111","emailaddress","福島県","男性",100);

INSERT INTO authentication(login_user,password,customer_id)
VALUES("A","$2a$08$mPfQPp3PrwUABMDVnVYazezFEP5hY9AVegX.xMHSJ3E77x7JPMHOa",1);
INSERT INTO authentication(login_user,password,customer_id)
VALUES("B","$2a$08$xfPl04x/7RkiEjgGLqZqzO7MI0kg7yE5CCaKSDtuVCenAEEb.IPT.",2);