package xroigmartin.gce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xroigmartin.gce.model.DomainValue;
import xroigmartin.gce.repository.DomainValueRepository;
import xroigmartin.gce.service.DomainValueService;

@Service
public class DomainValueServiceImpl implements DomainValueService{

	@Autowired
	private DomainValueRepository domainValueRepository;
	
	@Override
	public List<DomainValue> findAllByDomainId(Long domainId) {
		return domainValueRepository.findAllByDomainId(domainId);
	}

	@Override
	public DomainValue findById(Long id) {
		return domainValueRepository.findById(id).orElse(null);
	}

	@Override
	public void storeDomainValue(DomainValue domainValue) {
		domainValueRepository.save(domainValue);
	}

	@Override
	public void disableDomainValueById(Long id) {
		DomainValue domainValue = this.findById(id);
		domainValue.setEnable(false);
		this.storeDomainValue(domainValue);
	}

	@Override
	public void enableDomainValueById(Long id) {
		DomainValue domainValue = this.findById(id);
		domainValue.setEnable(true);
		this.storeDomainValue(domainValue);
	}

	@Override
	public boolean existsValueForDomain(String value, Long domainId) {
		return this.domainValueRepository.findByValueAndDomainId(value, domainId).isPresent();
	}

}
