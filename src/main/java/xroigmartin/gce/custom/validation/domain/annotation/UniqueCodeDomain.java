package xroigmartin.gce.custom.validation.domain.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import xroigmartin.gce.custom.validation.domain.validator.UniqueCodeDomainValidator;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCodeDomainValidator.class)
public @interface UniqueCodeDomain {
	String message() default "{domain.codeDomain.unique}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default{};
}
