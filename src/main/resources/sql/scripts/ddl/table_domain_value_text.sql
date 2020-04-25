CREATE TABLE IF NOT EXISTS gce.domain_value_text (
	id_domain_value INT(10) COMMENT 'Domain value identifier',
	lang INT(10) NOT NULL COMMENT 'id of langange in domain LANG',
	message VARCHAR(150) NOT NULL COMMENT 'Text of domain value',
    CONSTRAINT
		PRIMARY KEY (id_domain_value, lang),
	 CONSTRAINT domain_value_text_fk
		FOREIGN KEY (id_domain_value) 
			REFERENCES gce.domain_value(id)
);