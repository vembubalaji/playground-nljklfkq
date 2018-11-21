
INSERT INTO region (region_id,regionName) VALUES (1,'United States');
INSERT INTO region (region_id,regionName) VALUES (2,'Canada');

INSERT INTO team (team_Id,teamName,region_id) VALUES (1,'BATCH',1);
INSERT INTO team (team_Id,teamName,region_id) VALUES (2,'CRS',1);

INSERT INTO domain (domain_id, domainName) values (1, 'BatchDomain');
INSERT INTO domain (domain_id, domainName) values (2, 'CRSDomain');

INSERT INTO user (user_Id,name,username,isadmin,region_id,team_id,domain_id) VALUES (1,'Balaji Vembu','bvembu',true,1,1,1);
INSERT INTO user (user_Id,name,username,isadmin,region_id,team_id,domain_id) VALUES (2,'Akshat Sharma','amsharm',true,2,2,2);
INSERT INTO user (user_Id,name,username,isadmin,region_id,team_id,domain_id) VALUES (3,'abc def','aaa',true,2,2,2);


