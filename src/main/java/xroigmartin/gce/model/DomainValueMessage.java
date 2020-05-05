package xroigmartin.gce.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class DomainValueMessage {

	@Id
	@GeneratedValue(generator="domain_value_message_seq")
	@SequenceGenerator(name="domain_value_message_seq", sequenceName="domain_value_message_seq", allocationSize=1)
	private Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_domain_value", nullable = false)
	private DomainValue domainValue;
	
	@NotNull
	private Long lang;
	
	@NotEmpty
	@NotNull
	private String message;
	
	@Transient
	private String langText;

	public DomainValueMessage() {
		super();
	}

	public DomainValueMessage(Long id, DomainValue domainValue, Long lang, String message) {
		super();
		this.id = id;
		this.domainValue = domainValue;
		this.lang = lang;
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DomainValue getDomainValue() {
		return domainValue;
	}

	public void setDomainValue(DomainValue domainValue) {
		this.domainValue = domainValue;
	}

	public Long getLang() {
		return lang;
	}

	public void setLang(Long lang) {
		this.lang = lang;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLangText() {
		return langText;
	}

	public void setLangText(String langText) {
		this.langText = langText;
	}

	@Override
	public int hashCode() {
		return Objects.hash(domainValue, id, lang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DomainValueMessage other = (DomainValueMessage) obj;
		return Objects.equals(domainValue, other.domainValue) && Objects.equals(id, other.id)
				&& Objects.equals(lang, other.lang);
	}

	@Override
	public String toString() {
		return "DomainValueMessage [id=" + id + ", domainValue=" + domainValue + ", lang=" + lang + ", message="
				+ message + "]";
	}
}
