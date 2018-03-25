package be.gestatech.petclinic.web;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import be.gestatech.petclinic.core.datatables.dto.DataTablesRequest;
import be.gestatech.petclinic.core.datatables.dto.DataTablesResponse;
import be.gestatech.petclinic.core.owner.entity.Owner;
import be.gestatech.petclinic.core.owner.service.OwnerDataTablesService;
import be.gestatech.petclinic.core.owner.service.OwnerService;
import be.gestatech.petclinic.web.dto.OwnerResponse;
import be.gestatech.petclinic.web.mapper.OwnerDatatablesMapper;

@Controller
public class OwnerController extends AbstractController {

    private static final String OWNERS_EDIT = "owners/owners.edit";

    private static final String OWNERS_DATA = "owners";

    private OwnerDataTablesService ownerDataTablesService;

    private OwnerService ownerService;

    private OwnerDatatablesMapper ownerDatatablesDTOMapper;


    @Autowired
    public void setOwnerDataTablesService(OwnerDataTablesService ownerDataTablesService) {
        this.ownerDataTablesService = ownerDataTablesService;
    }

    @Autowired
    public void setOwnerService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Autowired
    public void setOwnerDatatablesDTOMapper(OwnerDatatablesMapper ownerDatatablesDTOMapper) {
        this.ownerDatatablesDTOMapper = ownerDatatablesDTOMapper;
    }


    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @PostMapping(OWNERS_DATA + "/new")
    public String create(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return OWNERS_EDIT;
        } else {
            this.ownerService.save(owner);
            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping(OWNERS_DATA + "/{ownerId}")
    public ModelAndView findOne(@PathVariable("ownerId") int ownerId) {
        ModelAndView modelAndView = new ModelAndView("owners/owners.details");
        modelAndView.addObject(this.ownerService.findById(ownerId));
        return modelAndView;
    }


    @GetMapping(OWNERS_DATA + "/list-request")
    @ResponseBody
    public DataTablesResponse<OwnerResponse> findAllGroupByLastName(@Valid DataTablesRequest dataTablesRequest) {
        DataTablesRequest serverRequest = ownerDatatablesDTOMapper.mapToServerRequest(dataTablesRequest);
        DataTablesResponse<Owner> serverResponse = ownerDataTablesService.findAll(serverRequest);
        if (Objects.nonNull(serverResponse.getError())) {
            throw new IllegalArgumentException(serverResponse.getError());
        }
        return ownerDatatablesDTOMapper.mapToWebResponse(serverResponse);
    }

    @PostMapping(OWNERS_DATA + "/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, @PathVariable("ownerId") int ownerId) {
        if (result.hasErrors()) {
            return OWNERS_EDIT;
        } else {
            owner.setId(ownerId);
            this.ownerService.save(owner);
            return "redirect:/owners/{ownerId}";
        }
    }

}