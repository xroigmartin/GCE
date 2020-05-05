package xroigmartin.gce.service;

import java.util.List;

import xroigmartin.gce.model.Domain;

public interface DomainService {

	List<Domain> findAllDomains();
	Domain getDomainbyId(Long id);
	Domain findByCodeDomain(String codeDomain);
	void storeDomain(Domain domain);
	void deleteDomainById(Long id);
	void disableDomainById(Long id);
	void enableDomainById(Long id);
}
