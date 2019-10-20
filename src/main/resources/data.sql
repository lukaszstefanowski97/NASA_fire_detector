INSERT INTO user(id,name,surname,password,cell_phone_number,email,notification_range_in_meters,x,y) VALUES ('1','Tom','Kowalski','tomKowalski1','+48605673426','tomKowalski@gmail.com','30000','53.421132','14.537240');
INSERT INTO user(id,name,surname,password,cell_phone_number,email,notification_range_in_meters,x,y) VALUES ('2','Anna','Nowak','tomKowalski1','+48664679982','annaNowak@gmail.com','10000','53.421132','14.537240');

INSERT INTO unregistered_user(id ,NAME, SURNAME) VALUES (1,'Jan','Nowak');
INSERT INTO unregistered_user(id ,NAME, SURNAME) VALUES (2,'Anna','Kowalska');

INSERT INTO fire_report(id,address,are_people,description,fire_departament_description,fire_report_approve_counter,fire_team,is_active_fire,is_building,is_electricity,is_hazardous_material,is_real,is_wood,photo,start_date,reporter_Id,x,y)
                VALUES (1,'Szczecin, Brama Portowa', true,'Trash bin in front of big house',null,5,false,true,false,false,false,null,false,null,CURRENT_TIMESTAMP ,1,53.575190, 14.546289);
INSERT INTO fire_report(id,address,are_people,description,fire_departament_description,fire_report_approve_counter,fire_team,is_active_fire,is_building,is_electricity,is_hazardous_material,is_real,is_wood,photo,start_date,reporter_Id,x,y)
                VALUES (2,null,false,'Small straw house',null,10,false,true,true,true,false,false,true,null,CURRENT_TIMESTAMP,2, 52.575190, 10.546289);
INSERT INTO fire_report(id,address,are_people,description,fire_departament_description,fire_report_approve_counter,fire_team,is_active_fire,is_building,is_electricity,is_hazardous_material,is_real,is_wood,photo,start_date,unregistered_reporter_Id,x,y)
                VALUES (3,'Kraków, Zielona 13F',true,'Villa','Huge fire',1,true,true,true,true,false,true,true,null,CURRENT_TIMESTAMP,2, 50.0198786,19.9481919);
INSERT INTO fire_report(id,address,are_people,description,fire_departament_description,fire_report_approve_counter,fire_team,is_active_fire,is_building,is_electricity,is_hazardous_material,is_real,is_wood,photo,start_date,unregistered_reporter_Id,x,y)
                VALUES (4,'Berlin, Brandenburger Tor',true,'Trees',null,3,true,true,true,false,false,true,true,null,CURRENT_TIMESTAMP,1, 52.5162746,13.3755154);
