CREATE TABLE IF NOT EXISTS gce.domain (
	id INT(10) COMMENT 'Domain identifier',
	code_domain VARCHAR(10) NOT NULL COMMENT 'Code of domain',
	description VARCHAR(50) COMMENT 'Description of domain',
	enable BOOLEAN default TRUE NOT NULL COMMENT 'Can use the domain',
    CONSTRAINT 
		PRIMARY KEY (id),
	CONSTRAINT code_domain_uk
		UNIQUE (code_domain),
	INDEX code_domain_idx (code_domain)
);

CREATE SEQUENCE gce.domain_seq START WITH 1 INCREMENT BY 1;