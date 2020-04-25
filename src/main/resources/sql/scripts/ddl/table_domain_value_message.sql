CREATE TABLE IF NOT EXISTS gce.domain_value_message (
	id INT(10) COMMENT 'Id of message in domain',
	id_domain_value INT(10) NOT NULL COMMENT 'Domain value identifier',
	lang INT(10) NOT NULL COMMENT 'id of langange in domain LANG',
	message VARCHAR(150) NOT NULL COMMENT 'Text of domain value',
    CONSTRAINT
		PRIMARY KEY (id),
	 CONSTRAINT domain_value_message_uk
		UNIQUE (id_domain_value, lang),
	 CONSTRAINT domain_value_message_fk
		FOREIGN KEY (id_domain_value) 
			REFERENCES gce.domain_value(id),
	 INDEX domain_value_message_idx (id_domain_value, lang)
);

CREATE SEQUENCE gce.domain_value_message_seq START WITH 1 INCREMENT BY 1;