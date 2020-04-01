package xroigmartin.gce.custom.validation.domain.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import xroigmartin.gce.model.Domain;
import xroigmartin.gce.repository.DomainRepository;

@SpringBootTest
class UniqueCodeDomainValidatorTest {
	
	@Autowired
	private Validator validator;
	
	@Test
	void shouldValidateCodeDomainExists() {
		Domain domain = new Domain("sexo");
		Set<ConstraintViolation<Domain>> violations = validator.validate(domain);
		assertEquals(1, violations.size());
	}
	
	@Test
	void shouldValidateCodeDomainNotExists() {
		Domain domain = new Domain("sexo1");
		Set<ConstraintViolation<Domain>> violations = validator.validate(domain);
		assertEquals(0, violations.size());
	}

}
