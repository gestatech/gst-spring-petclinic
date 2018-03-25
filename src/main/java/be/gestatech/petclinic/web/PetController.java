package be.gestatech.petclinic.web;

import java.util.Collection;
import java.util.Objects;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import be.gestatech.petclinic.core.owner.entity.Owner;
import be.gestatech.petclinic.core.owner.service.OwnerService;
import be.gestatech.petclinic.core.pet.entity.Pet;
import be.gestatech.petclinic.core.pet.entity.PetBuilder;
import be.gestatech.petclinic.core.pet.entity.PetType;
import be.gestatech.petclinic.core.pet.service.PetService;
import be.gestatech.petclinic.web.validation.PetValidator;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    Logger logger = LoggerFactory.getLogger(PetController.class);

    private static final String UPDATE_PETS = "pets/pets.update";

    @Autowired
    private OwnerService ownersService;

    @Autowired
    private PetService petService;

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return this.petService.findPetTypes();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") int ownerId) {
        return this.ownersService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @InitBinder("pet")
    public void initPetBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new PetValidator());
    }

    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, ModelMap model) {
        Pet pet = new PetBuilder().build();
        owner.addPet(pet);
        model.put("pet", pet);
        return UPDATE_PETS;
    }

    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, ModelMap model) {
        if (Objects.nonNull(pet.getName()) && !pet.getName().isEmpty() && pet.isNew() && Objects.nonNull(owner.getPet(pet.getName(), true))) {
            result.rejectValue("name", "duplicate", "already exists");
        }
        owner.addPet(pet);
        if (result.hasErrors()) {
            model.put("pet", pet);
            return UPDATE_PETS;
        } else {
            this.petService.save(pet);
            return "redirect:/owners/{ownerId}";
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable("petId") int petId, ModelMap model) {
        Pet pet = this.petService.findById(petId);
        model.put("pet", pet);
        return UPDATE_PETS;
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@Valid Pet pet, BindingResult result, Owner owner, ModelMap model) {
        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.put("pet", pet);
            return UPDATE_PETS;
        } else {
            owner.addPet(pet);
            this.petService.save(pet);
            return "redirect:/owners/{ownerId}";
        }
    }
}
