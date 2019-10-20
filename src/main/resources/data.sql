INSERT INTO user(id,name,surname,password,cell_phone_number,email,notification_range_in_meters,x,y) VALUES ('1','Tom','Kowalski','tomKowalski1','+48605673426','tomKowalski@gmail.com','30000','53.421132','14.537240');
INSERT INTO user(id,name,surname,password,cell_phone_number,email,notification_range_in_meters,x,y) VALUES ('2','Anna','Nowak','tomKowalski1','+48664679982','annaNowak@gmail.com','10000','53.421132','14.537240');

INSERT INTO unregistered_user(id ,NAME, SURNAME) VALUES (1,'Jan','Nowak');
INSERT INTO unregistered_user(id ,NAME, SURNAME) VALUES (2,'Anna','Kowalska');

INSERT INTO fire_report(id,reporter_Id,x,y) VALUES (1,2, 53.575190, 14.546289);
INSERT INTO fire_report(id,reporter_Id,x,y) VALUES (2,1, 51.575190, 11.546289);
INSERT INTO fire_report(id,reporter_Id,x,y) VALUES (3,1, 53.0, 14.546289);

INSERT INTO fire_report(id,unregistered_reporter_Id,x,y) VALUES (4,1, 53.0, 14.546289);
