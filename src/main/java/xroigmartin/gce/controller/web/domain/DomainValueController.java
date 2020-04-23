package xroigmartin.gce.controller.web.domain;

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

import xroigmartin.gce.model.DomainValue;
import xroigmartin.gce.service.DomainValueService;

@Controller
@RequestMapping("/domainValue/")
public class DomainValueController {
	@Autowired
	private DomainValueService domainValueService;
	
	@Autowired
    MessageSource messageSource;

	@GetMapping("/domain/{domainId}")
	public String getAllDomainValue(@PathVariable Long domainId, Model model) {
		List<DomainValue> domainValuesList = domainValueService.findAllByDomainId(domainId);
		model.addAttribute("domainValuesList", domainValuesList);
		return "domain/domain_values_list";
	}

	@GetMapping("/{id}")
	public String getDomainValueById(@PathVariable Long id, Model model) {
		DomainValue domainValue = domainValueService.findById(id);
		model.addAttribute("domainValue", domainValue);
		return "domain/form_domain_value";
	}

	@GetMapping("/new")
	public String newDomainValue(Model model) {
		model.addAttribute("domainValue", new DomainValue());
		return "domain/form_domain_value";
	}

	@PostMapping("/")
	public String storeDomainValue(@Valid DomainValue domainValue, BindingResult bindingResult, Model model) {
		boolean existsValueForDomain = domainValueService.existsValueForDomain(domainValue.getValue(), domainValue.getDomain().getId());
		if(existsValueForDomain) {
			FieldError uniqueDomainValueError = new FieldError("domainValue", "value", 
					messageSource.getMessage("domain.value.unique", new String[] {domainValue.getValue()}, Locale.getDefault()));
			bindingResult.addError(uniqueDomainValueError);
		}
		if (bindingResult.hasErrors()) {
			return "domain/form_domain_value";
		} else {
			DomainValue domainValueStore = null;
			if (domainValue.getId() == null) {
				domainValueStore = new DomainValue();
				domainValueStore.setValue(domainValue.getValue());
			} else {
				domainValueStore = domainValueService.findById(domainValue.getId());
				domainValueStore.setValue(domainValue.getValue());
			}

			domainValueService.storeDomainValue(domainValueStore);

			return "redirect:/domainValue/domain/1";
		}
	}

	@GetMapping("/disable/{id}")
	public String disableDominio(@PathVariable("id") Long id, Model model) {
		domainValueService.disableDomainValueById(id);
		return "redirect:/domainValue/domain/1";
	}

	@GetMapping("/enable/{id}")
	public String enableDominio(@PathVariable("id") Long id) {
		domainValueService.enableDomainValueById(id);
		return "redirect:/domainValue/domain/1";
	}
}
