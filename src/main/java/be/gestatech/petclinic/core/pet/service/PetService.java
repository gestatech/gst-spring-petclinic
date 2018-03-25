package be.gestatech.petclinic.core.pet.service;

import java.util.List;

import be.gestatech.petclinic.core.pet.entity.Pet;
import be.gestatech.petclinic.core.pet.entity.PetType;

public interface PetService {

    List<PetType> findPetTypes();

    Pet findById(Integer id);

    void save(Pet pet);
}
