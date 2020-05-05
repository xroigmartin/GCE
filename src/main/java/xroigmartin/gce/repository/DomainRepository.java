package xroigmartin.gce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xroigmartin.gce.model.Domain;

public interface DomainRepository extends JpaRepository<Domain, Long>{

	Optional<Domain> findByCodeDomain(String codeDomain);
}
