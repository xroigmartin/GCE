package xroigmartin.gce.custom.validation.domain.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import xroigmartin.gce.custom.validation.domain.annotation.UniqueCodeDomain;
import xroigmartin.gce.model.Domain;
import xroigmartin.gce.repository.DomainRepository;

public class UniqueCodeDomainValidator implements ConstraintValidator<UniqueCodeDomain, String>{
	
	@Autowired
	private DomainRepository domainRepository;
	
	public void initialize(UniqueCodeDomain constraint) {
		
	}
	
	public boolean isValid(String codeDomain, ConstraintValidatorContext context) {
		Optional<Domain> optional = domainRepository.findByCodeDomain(codeDomain);
		return !optional.isPresent();
	}
}
