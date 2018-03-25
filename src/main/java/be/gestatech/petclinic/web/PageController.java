package be.gestatech.petclinic.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;

import be.gestatech.petclinic.core.owner.entity.Owner;
import be.gestatech.petclinic.core.owner.service.OwnerService;

@Controller
public class PageController {

    private static final String OWNERS_EDIT = "owners/owners.edit";

    private static final String OWNERS_VIEW_ROOT = "owners";

    @Autowired
    private OwnerService ownerService;

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping(value = {"/", "/index", "/home"})
    String index() {
        return "index";
    }

    @GetMapping(OWNERS_VIEW_ROOT + "/new")
    public String initCreateOwnerForm(Map<String, Object> model) {
        Owner owner = new Owner();
        model.put("owner", owner);
        return OWNERS_EDIT;
    }

    @GetMapping(OWNERS_VIEW_ROOT + "/{ownerId}/edit")
    public String initEditOwnerForm(@PathVariable("ownerId") int ownerId, Model model) {
        Owner owner = this.ownerService.findById(ownerId);
        model.addAttribute(owner);
        return OWNERS_EDIT;
    }

    @GetMapping(OWNERS_VIEW_ROOT + "/find")
    public String initFindOwerForm(Map<String, Object> model) {
        model.put("owner", new Owner());
        return OWNERS_VIEW_ROOT + "/owners.find";
    }

    @GetMapping(OWNERS_VIEW_ROOT + "/list")
    public String findAllOwners() {
        return OWNERS_VIEW_ROOT + "/owners.list";
    }

    @GetMapping(OWNERS_VIEW_ROOT + "/list-custom")
    public String findOwners() {
        return OWNERS_VIEW_ROOT + "/owners.custom.list";
    }
}
