INSERT INTO system_user(id, username, password, account_expire, credential_expire, modified_time)
VALUES ('2x9soT8812lagn9jVf79aa','jimmy','$2a$10$jgTfB/izYGkiCZ46hioDiendgXqWxDnmjtndXQFtQpHnEYIk237G.',null,null,now());
INSERT INTO system_authority(id, name, description, modified_time)
VALUES ('1sh3Jvalx5t9njiZKED77Y', 'ROLE_ADMIN', '', null);
INSERT INTO system_role (id, name, description, modified_time)
VALUES ('1mVDCOe2ZcLGVAer7UF6DE', 'ADMIN', '', null);
INSERT INTO system_role_authority(role_id, authority_id)
VALUES ('1mVDCOe2ZcLGVAer7UF6DE', '1sh3Jvalx5t9njiZKED77Y');
INSERT INTO system_user_role(system_user_id, role_id)
VALUES ('2x9soT8812lagn9jVf79aa', '1mVDCOe2ZcLGVAer7UF6DE');