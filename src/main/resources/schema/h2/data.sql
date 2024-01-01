INSERT INTO company (company_code, company_name) VALUES ('DKH', '동국홀딩스');
INSERT INTO company (company_code, company_name) VALUES ('DKS', '동국제강');
INSERT INTO company (company_code, company_name) VALUES ('DKW', '동국씨엠');
INSERT INTO company (company_code, company_name) VALUES ('ITG', '인터지스');
INSERT INTO company (company_code, company_name) VALUES ('UNC', '동국시스템즈');
INSERT INTO company (company_code, company_name) VALUES ('FEI', '페럼인프라');

INSERT INTO admin_user (user_id, password, org_name, company_code, create_at, expired_at) VALUES ('dk_admin', '1234', '협업솔루션팀', 'UNC', now(), '2999-12-31');

INSERT INTO admin_company (admin_user_id, company_code) VALUES (1, 'DKH');
INSERT INTO admin_company (admin_user_id, company_code) VALUES (1, 'DKS');
INSERT INTO admin_company (admin_user_id, company_code) VALUES (1, 'DKW');
INSERT INTO admin_company (admin_user_id, company_code) VALUES (1, 'ITG');
INSERT INTO admin_company (admin_user_id, company_code) VALUES (1, 'UNC');
INSERT INTO admin_company (admin_user_id, company_code) VALUES (1, 'FEI');