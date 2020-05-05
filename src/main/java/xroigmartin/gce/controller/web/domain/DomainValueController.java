package xroigmartin.gce.controller.web.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import xroigmartin.gce.model.Domain;
import xroigmartin.gce.model.DomainValue;
import xroigmartin.gce.model.DomainValueMessage;
import xroigmartin.gce.service.DomainService;
import xroigmartin.gce.service.DomainValueService;

@Controller
@RequestMapping("/domainValue/")
public class DomainValueController {
	@Autowired
	private DomainValueService domainValueService;
	@Autowired
	private DomainService domainService;
	@Autowired
    private MessageSource messageSource;

	@GetMapping("/domain/{domainId}")
	public String getAllDomainValue(@PathVariable Long domainId, Model model) {
		List<DomainValue> domainValuesList = domainValueService.findAllByDomainId(domainId);
		model.addAttribute("domainValuesList", domainValuesList);
		model.addAttribute("domainId", domainId);
		return "domain/domain_values_list";
	}

	@GetMapping("/{id}")
	public String getDomainValueById(@PathVariable Long id, Model model) {
		DomainValue domainValue = domainValueService.findById(id);
		for(DomainValueMessage domValMes : domainValue.getMessages()) {
			String langText = domainValueService.findById(domValMes.getLang()).getValue();
			domValMes.setLangText(langText);
		}
		model.addAttribute("domainValue", domainValue);
		return "domain/form_domain_value";
	}

	@GetMapping("/new/{domainId}")
	public String newDomainValue(@PathVariable Long domainId, Model model) {		
		model.addAttribute("domainValue", initDomainValue(domainId));
		return "domain/form_domain_value";
	}

	private DomainValue initDomainValue(Long domainId) {
		DomainValue domainValue = new DomainValue();
		List<DomainValueMessage> emptyMessages = new ArrayList<>();
		
		Domain langDomain = domainService.findByCodeDomain("IDIOMA");
		List<DomainValue> valuesLangDomain = domainValueService.findAllByDomainId(langDomain.getId());
		
		for(DomainValue value : valuesLangDomain) {
			DomainValueMessage message = new DomainValueMessage();
			message.setLang(value.getId());
			message.setLangText(value.getValue());
			emptyMessages.add(message);
		}
		domainValue.setMessages(emptyMessages);
		
		Domain domainParent = domainService.getDomainbyId(domainId);
		domainValue.setDomain(domainParent);
		
		return domainValue;
	}
	
	@PostMapping("/")
	public String storeDomainValue(@Valid DomainValue domainValue, BindingResult bindingResult, Model model) {
		
		if(!this.checkModifyValueOfDomainValue(domainValue) && checkValueExistsInDomain(domainValue)) {
			FieldError uniqueDomainValueError = new FieldError("domainValue", "value", 
					messageSource.getMessage("domain.value.unique", new String[] {domainValue.getValue()}, Locale.getDefault()));			
			
			bindingResult.addError(uniqueDomainValueError);
		}

		if (bindingResult.hasErrors()) {
			for(DomainValueMessage domValMes : domainValue.getMessages()) {
				String langText = domainValueService.findById(domValMes.getLang()).getValue();
				domValMes.setLangText(langText);
			}
			return "domain/form_domain_value";
		} else {
			DomainValue domainValueStore = null;
			if (domainValue.getId() == null) {
				domainValueStore = new DomainValue();
				domainValueStore.setValue(domainValue.getValue().toUpperCase());
				domainValueStore.setMessages(domainValue.getMessages());
				Domain domainParent = domainService.getDomainbyId(domainValue.getDomain().getId());
				domainValueStore.setDomain(domainParent);
				domainValueStore.setMessages(domainValue.getMessages());
				for(DomainValueMessage message : domainValueStore.getMessages()) {
					message.setDomainValue(domainValueStore);
				}
			} else {
				domainValueStore = domainValueService.findById(domainValue.getId());
				domainValueStore.setValue(domainValue.getValue());
				for(DomainValueMessage domValMes : domainValue.getMessages()) {
					for(DomainValueMessage domValMesStore : domainValueStore.getMessages()) {
						if(domValMesStore.getId().equals(domValMes.getId())) {
							domValMesStore.setMessage(domValMes.getMessage());
							break;
						}
					}				
				}
			}
			
			domainValueService.storeDomainValue(domainValueStore);

			return "redirect:/domainValue/domain/"+ domainValueStore.getDomain().getId();
		}
	}

	private boolean checkModifyValueOfDomainValue(DomainValue domainValueModify) {
		if(domainValueModify.getId() != null) {
			DomainValue domainValueExist = domainValueService.findById(domainValueModify.getId());
			
			if(domainValueExist.getValue().equals(domainValueModify.getValue())) {
				return true;
			}
		}
		
		return false;
	}
	private boolean checkValueExistsInDomain(DomainValue domainValue) {
		boolean existsValueForDomain;
		if(domainValue.getId() != null) {
			DomainValue domainValueExist = domainValueService.findById(domainValue.getId());
			if(domainValueExist.getValue().equals(domainValue.getValue())) {
				existsValueForDomain = false;
			}
			else {
				existsValueForDomain = domainValueService.existsValueForDomain(domainValue.getValue(), domainValue.getDomain().getId());
			}
		}
		else {
			existsValueForDomain = domainValueService.existsValueForDomain(domainValue.getValue(), domainValue.getDomain().getId());
		}
		return existsValueForDomain;
	}

	@GetMapping("/disable/{id}")
	public String disableDominio(@PathVariable("id") Long id, Model model) {
		domainValueService.disableDomainValueById(id);
		DomainValue domainValue = domainValueService.findById(id);
		return "redirect:/domainValue/domain/" + domainValue.getDomain().getId();
	}

	@GetMapping("/enable/{id}")
	public String enableDominio(@PathVariable("id") Long id) {
		domainValueService.enableDomainValueById(id);
		DomainValue domainValue = domainValueService.findById(id);
		return "redirect:/domainValue/domain/" + domainValue.getDomain().getId();
	}
}
