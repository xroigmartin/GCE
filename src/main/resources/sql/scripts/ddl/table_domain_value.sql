CREATE TABLE IF NOT EXISTS gce.domain_value (
	id INT(10) COMMENT 'Domain value identifier',
	domain_value VARCHAR(10) NOT NULL COMMENT 'Value of domain',
	id_domain INT(10) COMMENT 'Identifier of the domain to which the value belongs',
	enable BOOLEAN default TRUE NOT NULL COMMENT 'Can use the value',
    CONSTRAINT
		PRIMARY KEY (id),
	CONSTRAINT domain_value_uk
		UNIQUE (domain_value, id_domain),
	CONSTRAINT domain_value_fk
		FOREIGN KEY (id_domain) 
			REFERENCES gce.domain(id),
	INDEX domain_value_idx (domain_value, id_domain)
);

CREATE SEQUENCE gce.domain_value_seq START WITH 1 INCREMENT BY 1;