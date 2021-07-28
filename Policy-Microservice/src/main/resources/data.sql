insert into Provider (name,location) values ('Medocover','Manhattan');
insert into Provider (name,location) values ('Rainbow','Hyderabad');
insert into Provider (name,location) values ('NIMS','Bangalore');
insert into Provider (name,location) values ('RR','Kurnool');


insert into Policy (benefits,premium,tenure) values ('Ambulance allowance',10000,2);
insert into Policy (benefits,premium,tenure) values ('HealthTests',100000,3);
insert into Policy (benefits,premium,tenure) values ('Operation fee reimbursement',105000,4);

create table if not exists  provider_policy (prp_id int auto_increment primary key, prp_p_id int, prp_pr_id int,
                            foreign key (prp_p_id) references policy (p_id),
                            foreign key (prp_pr_id) references Provider(pr_id));
                            
insert into provider_policy (prp_p_id,prp_pr_id) values (1,3);
insert into provider_policy (prp_p_id,prp_pr_id) values (1,1);
insert into provider_policy (prp_p_id,prp_pr_id) values (2,3);
insert into provider_policy (prp_p_id,prp_pr_id) values (3,3);
insert into provider_policy (prp_p_id,prp_pr_id) values (2,4);
insert into provider_policy (prp_p_id,prp_pr_id) values (1,4);

insert into members (memberid,firstname,lastname,age,gender,address) values (1,'venkat','saketh',21,'male','kurnool');
insert into members (memberid,firstname,lastname,age,gender,address) values (2,'tony','stark',34,'male','manhattan');
insert into members (memberid,firstname,lastname,age,gender,address) values (3,'peter','parkar',25,'male','queens');
insert into members (memberid,firstname,lastname,age,gender,address) values (4,'steve','rogers',29,'male','Brooklyn');




insert into member_policy (mp_id,p_id,m_id,sub_date,tenure,benefits,amount_for_benifits) values (1,1,1,'2021-04-25',2,'Ambulance allowance',10000);
insert into member_policy (mp_id,p_id,m_id,sub_date,tenure,benefits,amount_for_benifits) values (2,1,2,'2021-04-20',2,'Ambulance allowance',10000);
insert into member_policy (mp_id,p_id,m_id,sub_date,tenure,benefits,amount_for_benifits) values (3,2,2,'2020-06-02',3,'Health Tests',100000);
insert into member_policy (mp_id,p_id,m_id,sub_date,tenure,benefits,amount_for_benifits) values (4,3,3,'2020-04-20',4,'Operation fee reimbursement',105000);