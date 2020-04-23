package xroigmartin.gce.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import xroigmartin.gce.custom.validation.domain.annotation.UniqueCodeDomain;

@Entity
public class Domain {

	@Id
	@GeneratedValue(generator="domain_seq")
	@SequenceGenerator(name="domain_seq", sequenceName="domain_seq", allocationSize=1)
	private Long id;
	
	@NotEmpty(message = "{domain.codeDomain.empty}")
	@NotNull(message = "{domain.codeDomain.empty}")
	@Size(min = 3, max=10, message="{domain.codeDomain.size}")
	@UniqueCodeDomain
	private String codeDomain;
	
	private String description;
	
	@Column(columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean enable = true;
	
	@OneToMany(mappedBy = "domain")
	private List<DomainValue> domainValues;

	public Domain() {
		super();
	}

	public Domain(Long id, String codeDomain, String description, Boolean enable) {
		super();
		this.id = id;
		this.codeDomain = codeDomain;
		this.description = description;
		this.enable = enable;
	}

	public Domain(Long id, String codeDomain, Boolean enable) {
		super();
		this.id = id;
		this.codeDomain = codeDomain;
		this.enable = enable;
	}
	
	public Domain(String codeDomain) {
		super();
		this.codeDomain = codeDomain;
	}

	public Domain(String codeDomain, Boolean enable) {
		super();
		this.codeDomain = codeDomain;
		this.enable = enable;
	}

	public Domain(String codeDomain, String description, Boolean enable) {
		super();
		this.codeDomain = codeDomain;
		this.description = description;
		this.enable = enable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeDomain() {
		return codeDomain;
	}

	public void setCodeDomain(String codeDomain) {
		this.codeDomain = codeDomain;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public List<DomainValue> getDomainValues() {
		return domainValues;
	}

	public void setDomainValues(List<DomainValue> domainValues) {
		this.domainValues = domainValues;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeDomain, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Domain other = (Domain) obj;
		return Objects.equals(codeDomain, other.codeDomain) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Dominio [id=" + id + ", codeDomain=" + codeDomain + ", description=" + description + ", enable="
				+ enable + "]";
	}
	
}
