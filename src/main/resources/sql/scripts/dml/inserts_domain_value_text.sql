INSERT INTO gce.domain_value_message(id, id_domain_value, lang, message) 
VALUES (NEXTVAL(gce.domain_value_message_seq),
			(SELECT id
			FROM domain_value dom_val
			WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
			AND dom_val.domain_value = 'CAT'),
			(SELECT id
				FROM domain_value dom_val
				WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
				AND dom_val.domain_value = 'CAT'),
			'Català');
			
INSERT INTO gce.domain_value_message(id, id_domain_value, lang, message) 
VALUES (NEXTVAL(gce.domain_value_message_seq),
			(SELECT id
			FROM domain_value dom_val
			WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
			AND dom_val.domain_value = 'ESP'),
			(SELECT id
				FROM domain_value dom_val
				WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
				AND dom_val.domain_value = 'CAT'),
			'Castellà');
			
INSERT INTO gce.domain_value_message(id, id_domain_value, lang, message) 
VALUES (NEXTVAL(gce.domain_value_message_seq),
			(SELECT id
			FROM domain_value dom_val
			WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
			AND dom_val.domain_value = 'ING'),
			(SELECT id
				FROM domain_value dom_val
				WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
				AND dom_val.domain_value = 'CAT'),
			'Anglès');
			
/******************************************************************/
INSERT INTO gce.domain_value_message(id, id_domain_value, lang, message) 
VALUES (NEXTVAL(gce.domain_value_message_seq),
			(SELECT id
			FROM domain_value dom_val
			WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
			AND dom_val.domain_value = 'CAT'),
			(SELECT id
				FROM domain_value dom_val
				WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
				AND dom_val.domain_value = 'ESP'),
			'Catalan');
			
INSERT INTO gce.domain_value_message(id, id_domain_value, lang, message) 
VALUES (NEXTVAL(gce.domain_value_message_seq),
			(SELECT id
			FROM domain_value dom_val
			WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
			AND dom_val.domain_value = 'ESP'),
			(SELECT id
				FROM domain_value dom_val
				WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
				AND dom_val.domain_value = 'ESP'),
			'Castellano');
			
INSERT INTO gce.domain_value_message(id, id_domain_value, lang, message) 
VALUES (NEXTVAL(gce.domain_value_message_seq),
			(SELECT id
			FROM domain_value dom_val
			WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
			AND dom_val.domain_value = 'ING'),
			(SELECT id
				FROM domain_value dom_val
				WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
				AND dom_val.domain_value = 'ESP'),
			'Ingles');
/*****************************************************************/
INSERT INTO gce.domain_value_message(id, id_domain_value, lang, message) 
VALUES (NEXTVAL(gce.domain_value_message_seq),
			(SELECT id
			FROM domain_value dom_val
			WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
			AND dom_val.domain_value = 'CAT'),
			(SELECT id
				FROM domain_value dom_val
				WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
				AND dom_val.domain_value = 'ING'),
			'Catala');
			
INSERT INTO gce.domain_value_message(id, id_domain_value, lang, message) 
VALUES (NEXTVAL(gce.domain_value_message_seq),
			(SELECT id
			FROM domain_value dom_val
			WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
			AND dom_val.domain_value = 'ESP'),
			(SELECT id
				FROM domain_value dom_val
				WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
				AND dom_val.domain_value = 'ING'),
			'Spanish');
			
INSERT INTO gce.domain_value_message(id, id_domain_value, lang, message) 
VALUES (NEXTVAL(gce.domain_value_message_seq),
			(SELECT id
			FROM domain_value dom_val
			WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
			AND dom_val.domain_value = 'ING'),
			(SELECT id
				FROM domain_value dom_val
				WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
				AND dom_val.domain_value = 'ING'),
			'English');
			
/******************************************/
INSERT INTO gce.domain_value_message(id, id_domain_value, lang, message) 
VALUES (NEXTVAL(gce.domain_value_message_seq),
			(SELECT id
			FROM domain_value dom_val
			WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='SEXO')
			AND dom_val.domain_value = 'H'),
			(SELECT id
				FROM domain_value dom_val
				WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
				AND dom_val.domain_value = 'CAT'),
			'Home');
			
INSERT INTO gce.domain_value_message(id, id_domain_value, lang, message) 
VALUES (NEXTVAL(gce.domain_value_message_seq),
			(SELECT id
			FROM domain_value dom_val
			WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='SEXO')
			AND dom_val.domain_value = 'H'),
			(SELECT id
				FROM domain_value dom_val
				WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
				AND dom_val.domain_value = 'ESP'),
			'Hombre');
			
INSERT INTO gce.domain_value_message(id, id_domain_value, lang, message) 
VALUES (NEXTVAL(gce.domain_value_message_seq),
			(SELECT id
			FROM domain_value dom_val
			WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='SEXO')
			AND dom_val.domain_value = 'H'),
			(SELECT id
				FROM domain_value dom_val
				WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
				AND dom_val.domain_value = 'ING'),
			'Man');
			
/******************************************/
INSERT INTO gce.domain_value_message(id, id_domain_value, lang, message) 
VALUES (NEXTVAL(gce.domain_value_message_seq),
			(SELECT id
			FROM domain_value dom_val
			WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='SEXO')
			AND dom_val.domain_value = 'M'),
			(SELECT id
				FROM domain_value dom_val
				WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
				AND dom_val.domain_value = 'CAT'),
			'Dona');
			
INSERT INTO gce.domain_value_message(id, id_domain_value, lang, message) 
VALUES (NEXTVAL(gce.domain_value_message_seq),
			(SELECT id
			FROM domain_value dom_val
			WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='SEXO')
			AND dom_val.domain_value = 'M'),
			(SELECT id
				FROM domain_value dom_val
				WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
				AND dom_val.domain_value = 'ESP'),
			'Mujer');
			
INSERT INTO gce.domain_value_message(id, id_domain_value, lang, message) 
VALUES (NEXTVAL(gce.domain_value_message_seq),
			(SELECT id
			FROM domain_value dom_val
			WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='SEXO')
			AND dom_val.domain_value = 'M'),
			(SELECT id
				FROM domain_value dom_val
				WHERE dom_val.id_domain = (SELECT id FROM gce.domain dom WHERE dom.code_domain='IDIOMA')
				AND dom_val.domain_value = 'ING'),
			'Woman');