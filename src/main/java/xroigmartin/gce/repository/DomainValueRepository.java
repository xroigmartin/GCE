package xroigmartin.gce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xroigmartin.gce.model.DomainValue;

public interface DomainValueRepository extends JpaRepository<DomainValue, Long>{

	List<DomainValue> findAllByDomainId(Long domainId);
}
