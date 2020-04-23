INSERT INTO gce.domain_value(id,domain_value,id_domain, enable ) 
VALUES(NEXTVAL(gce.domain_value_seq), 'H', (SELECT id FROM gce.domain where code_domain='sexo'), TRUE);

INSERT INTO gce.domain_value(id,domain_value,id_domain, enable ) 
VALUES(NEXTVAL(gce.domain_value_seq), 'M', (SELECT id FROM gce.domain where code_domain='sexo'), TRUE);