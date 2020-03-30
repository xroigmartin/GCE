package xroigmartin.gce.controller.web.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import xroigmartin.gce.model.Domain;
import xroigmartin.gce.service.DomainService;

@Controller
@RequestMapping("/domain")
public class DomainController {

	@Autowired
	private DomainService domainService;
	
	@GetMapping("/")
	public String getAllDominios(Model model){
		List<Domain> domainList = domainService.findAllDomains();
		model.addAttribute("domainList", domainList);
		return "domain/domains_list";
	}
	
	@GetMapping("/{id}")
	public String getDominioById(@PathVariable Long id, Model model) {
		Domain domain = domainService.getDomainbyId(id);
		model.addAttribute("domain", domain);
		return "domain/edit_domain";
	}
	
	@GetMapping("/new")
	public String newDomain(Model model) {
		model.addAttribute("domain", new Domain());
		return "domain/edit_domain";
	}
	
	@PostMapping("/")
	public String storeDominio(@ModelAttribute Domain domain) {
		Domain domainStore = null;
		if(domain.getId() == null) {
			domainStore = new Domain();
			domainStore.setCodeDomain(domain.getCodeDomain());
			domainStore.setDescription(domain.getDescription());
		}
		else {
			domainStore = domainService.getDomainbyId(domain.getId());
			domainStore.setCodeDomain(domain.getCodeDomain());
			domainStore.setDescription(domain.getDescription());
		}
		
		domainService.storeDomain(domainStore);
		
		return "redirect:/domain/";
	}
	
	@GetMapping("/disable/{id}")
	public String disableDominio(@PathVariable("id") Long id, Model model) {
		domainService.disableDomainById(id);
		return "redirect:/domain/";
	}
	
	@GetMapping("/enable/{id}")
	public String enableDominio(@PathVariable("id") Long id) {
		domainService.enableDomainById(id);
		return "redirect:/domain/";
	}
	
	
}
