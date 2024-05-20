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
INSERT INTO merchandise(name,category,price,stock)VALUES("お菓子","食品",100,1);
INSERT INTO merchandise(name,category,price,stock)VALUES("食器洗い用洗剤","薬剤",800,20);
INSERT INTO merchandise(name,category,price,stock)VALUES("ハンドソープ","薬剤",300,8);
INSERT INTO merchandise(name,category,price,stock)VALUES("机","家具",10000,30);
INSERT INTO merchandise(name,category,price,stock)VALUES("ベッド","家具",30000,21);
INSERT INTO merchandise(name,category,price,stock)VALUES("鉛筆","文房具",200,100);
INSERT INTO merchandise(name,category,price,stock)VALUES("ノート","文房具",400,60);
INSERT INTO merchandise(name,category,price,stock)VALUES("電球","家電",900,78);
INSERT INTO merchandise(name,category,price,stock)VALUES("電池","家電",1100,87);
INSERT INTO merchandise(name,category,price,stock)VALUES("インク","家電",5000,0);

INSERT INTO customer(age,name,telephone_number,email,gender,cash)
VALUES(38,"松沢知史","09065026846","matsuzawatomofumi@example.com","男性",20000);
INSERT INTO customer(age,name,telephone_number,email,gender,cash)
VALUES(56,"金児蒼甫","0169717934","kanekosousuke@example.com","男性",50);
INSERT INTO customer(age,name,telephone_number,email,gender,cash)
VALUES(48,"五味あおい","0406381287","gomiaoi@example.com","女性",10000);
INSERT INTO customer(age,name,telephone_number,email,gender,cash)
VALUES(18,"藤野まひる","0903646522","fujinomahiru@example.com","女性",5000);
INSERT INTO customer(age,name,telephone_number,email,gender,cash)
VALUES(45,"大塚さやか","0405763576","ootsukasayaka@example.com","女性",40000);


INSERT INTO address(customer_id,name,post_code,municipalities,prefectural,telephone_number,priority)
VALUES(1,"松沢知史","1230872","板橋区桜川3丁目314番地16号","東京都","09065026846",true);
INSERT INTO address(customer_id,name,post_code,municipalities,prefectural,telephone_number,priority)
VALUES(1,"松沢知史","4928437","稲沢市中之庄長堤町3-6-1 シャンパーニュ中之庄長堤町 14F","愛知県","0587755067",false);
INSERT INTO address(customer_id,name,post_code,municipalities,prefectural,telephone_number,priority)
VALUES(1,"吉本雅之","9392604","富山市婦中町小野島1646","富山県","07660034147",false);
INSERT INTO address(customer_id,name,post_code,municipalities,prefectural,telephone_number,priority)
VALUES(2,"金児蒼甫","1650024","黒石市若葉町282番地12号","青森県","09059025852",true);
INSERT INTO address(customer_id,name,post_code,municipalities,prefectural,telephone_number,priority)
VALUES(3,"五味あかい","8914403","二本松市中森612番地9号","福島県","08043804345",true);
INSERT INTO address(customer_id,name,post_code,municipalities,prefectural,telephone_number,priority)
VALUES(4,"藤野まひる","9590245","丹波市春日町坂527番地12号","兵庫県","0903646522",true);
INSERT INTO address(customer_id,name,post_code,municipalities,prefectural,telephone_number,priority)
VALUES(5,"大塚一輝","0300921","札幌市豊平区豊平二条1丁目702番地12号","北海道","0908197567",true);

INSERT INTO authentication(login_user,password,customer_id)
VALUES("USERA","$2a$08$Z6GEM.SanmMocAeYjW2F2e/AnKdS2e7JUkxH5RsYA.xq5gr6qdGQW",1);
INSERT INTO authentication(login_user,password,customer_id)
VALUES("USERB","$2a$08$UGnFHAgSME.UCA78wgbxMeDobgT5Cgg7bEsOHH7DwPu3t0AcxSmWC",2);
INSERT INTO authentication(login_user,password,customer_id)
VALUES("USERC","$2a$08$YwWkmPyw997OqKeEJYN53.vFJpamCRrpngPY3GDBHDF/06mytubx6",3);
INSERT INTO authentication(login_user,password,customer_id)
VALUES("USERD","$2a$08$jlV1oPZ5QqAzXPLyrKvSJuhaisklFrYyaxf1aY6kwtyjXjmVDzq72",4);
INSERT INTO authentication(login_user,password,customer_id)
VALUES("USERE","$2a$08$Hw91PC7dxjAW2Paaus5.P.6m..Hk0m.XpPujsRosLH5VZCuQlwgb.",5);