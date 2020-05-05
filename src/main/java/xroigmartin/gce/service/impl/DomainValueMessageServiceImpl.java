package xroigmartin.gce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xroigmartin.gce.model.DomainValueMessage;
import xroigmartin.gce.repository.DomainValueMessageRepository;
import xroigmartin.gce.service.DomainValueMessageService;

@Service
public class DomainValueMessageServiceImpl implements DomainValueMessageService{

	@Autowired
	private DomainValueMessageRepository domValMessageRepo;

	@Override
	public List<DomainValueMessage> findByDomainValueId(Long domainValueId) {
		return domValMessageRepo.findByDomainValueId(domainValueId);
	}

	@Override
	public DomainValueMessage findByDomainValueIdAndLang(Long domainValueId, Long lang) {
		return domValMessageRepo.findByDomainValueIdAndLang(domainValueId, lang).orElse(null);
	}

	@Override
	public void storeDomainValueMenssage(DomainValueMessage domainValueMessage) {
		domValMessageRepo.save(domainValueMessage);
	}
	
}
