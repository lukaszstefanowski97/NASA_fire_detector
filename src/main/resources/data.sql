INSERT INTO user(id,name,surname,password,cell_phone_number,email,notification_range_in_meters,x,y) VALUES ('1','Tom','Kowalski','tomKowalski1','+48605673426','tomKowalski@gmail.com','30000','53.421132','14.537240');
INSERT INTO user(id,name,surname,password,cell_phone_number,email,notification_range_in_meters,x,y) VALUES ('2','Anna','Nowak','tomKowalski1','+48664679982','annaNowak@gmail.com','10000','53.421132','14.537240');

INSERT INTO unregistered_user(id ,NAME, SURNAME) VALUES (1,'Jan','Nowak');
INSERT INTO unregistered_user(id ,NAME, SURNAME) VALUES (2,'Anna','Kowalska');

INSERT INTO fire_report(id,address,are_people,description,fire_departament_description,fire_report_approve_counter,fire_team,is_active_fire,is_building,is_electricity,is_hazardous_material,is_real,is_wood,photo,start_date,reporter_Id,x,y)
                VALUES (1,'Szczecin, Potulicka 12/23', true,'kosz na moim podworku',null,1,false,true,false,false,false,null,false,null,CURRENT_TIMESTAMP ,1,53.575190, 14.546289);
INSERT INTO fire_report(id,address,are_people,description,fire_departament_description,fire_report_approve_counter,fire_team,is_active_fire,is_building,is_electricity,is_hazardous_material,is_real,is_wood,photo,start_date,reporter_Id,x,y)
                VALUES (2,'Wrocław, Kolorowa 35A',false,'Mały słomiany domek',null,4,false,true,true,true,false,false,true,null,CURRENT_TIMESTAMP,2, 51.575190, 11.546289);
INSERT INTO fire_report(id,address,are_people,description,fire_departament_description,fire_report_approve_counter,fire_team,is_active_fire,is_building,is_electricity,is_hazardous_material,is_real,is_wood,photo,start_date,unregistered_reporter_Id,x,y)
                VALUES (3,'Kraków, Zielona 13F',true,'Wielki dom','Nieduży pożar domu.',4,true,true,true,true,false,true,true,null,CURRENT_TIMESTAMP,2, 51.575190, 11.546289);
