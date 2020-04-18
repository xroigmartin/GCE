package xroigmartin.gce.service;

import java.util.List;

import xroigmartin.gce.model.DomainValue;

public interface DomainValueService {

	List<DomainValue> findAllByDomainId(Long domainId);
	DomainValue findById(Long id);
	void storeDomainValue(DomainValue domainValue);
	void disableDomainValueById(Long id);
	void enableDomainValueById(Long id);
}
