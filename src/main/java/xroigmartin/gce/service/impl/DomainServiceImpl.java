package xroigmartin.gce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xroigmartin.gce.model.Domain;
import xroigmartin.gce.repository.DomainRepository;
import xroigmartin.gce.service.DomainService;

@Service
public class DomainServiceImpl implements DomainService {

	@Autowired
	private DomainRepository domainRepository;
	
	@Override
	public List<Domain> findAllDomains() {
		return domainRepository.findAll();
	}
	
	@Override
	public Domain findByCodeDomain(String codeDomain) {
		return domainRepository.findByCodeDomain(codeDomain).orElse(null);
	}

	@Override
	public Domain getDomainbyId(Long id) {
		return domainRepository.findById(id).orElse(null);
	}

	@Override
	public void storeDomain(Domain domain) {
		domainRepository.save(domain);
	}

	@Override
	public void deleteDomainById(Long id) {
		domainRepository.deleteById(id);
	}

	@Override
	public void disableDomainById(Long id) {
		Domain domain = this.getDomainbyId(id);
		if(domain != null) {
			domain.setEnable(false);
			this.storeDomain(domain);
		}
	}

	@Override
	public void enableDomainById(Long id) {
		Domain domain = this.getDomainbyId(id);
		if(domain != null) {
			domain.setEnable(true);
			this.storeDomain(domain);
		}
	}

}
