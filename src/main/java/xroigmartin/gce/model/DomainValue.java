package xroigmartin.gce.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
public class DomainValue {

	@Id
	@GeneratedValue(generator="domain_value_seq")
	@SequenceGenerator(name="domain_value_seq", sequenceName="domain_value_seq", allocationSize=1)
	private Long id;
	
	@NotEmpty
	@NotNull
	@Size(min = 1, max = 10, message="{domain.value.value.size}")
	@Column(name="domainValue")
	private String value;
		
	@Column(name="id_domain")
	private Long domainId = 1L;
	
	@NotNull
	@Column(columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean enable = true;
	
	public DomainValue() {
		super();
	}
	
	public DomainValue(String value, Long domainId) {
		super();
		this.value = value;
		this.domainId = domainId;
	}


	public DomainValue(String value, Long domainId, Boolean enable) {
		super();
		this.value = value;
		this.domainId = domainId;
		this.enable = enable;
	}


	public DomainValue(Long id, String value, Long domainId, Boolean enable) {
		super();
		this.id = id;
		this.value = value;
		this.domainId = domainId;
		this.enable = enable;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getDomainId() {
		return domainId;
	}

	public void setDomainId(Long domainId) {
		this.domainId = domainId;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	@Override
	public int hashCode() {
		return Objects.hash(domainId, enable, id, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DomainValue other = (DomainValue) obj;
		return Objects.equals(domainId, other.domainId) && Objects.equals(enable, other.enable)
				&& Objects.equals(id, other.id) && Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "DomainValue [id=" + id + ", value=" + value + ", domainId=" + domainId + ", enable=" + enable + "]";
	}
	
}
