package xroigmartin.gce.service;

import java.util.List;

import xroigmartin.gce.model.DomainValueMessage;

public interface DomainValueMessageService {

	List<DomainValueMessage> findByDomainValueId(Long domainValueId);
	DomainValueMessage findByDomainValueIdAndLang(Long domainValueId, Long lang);
	void storeDomainValueMenssage(DomainValueMessage domainValueMessage);
}
