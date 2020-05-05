package xroigmartin.gce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xroigmartin.gce.model.DomainValueMessage;

public interface DomainValueMessageRepository extends JpaRepository<DomainValueMessage, Long>{

	List<DomainValueMessage> findByDomainValueId(Long domainValueId);
	Optional<DomainValueMessage> findByDomainValueIdAndLang(Long domainValueId, Long lang);
}
