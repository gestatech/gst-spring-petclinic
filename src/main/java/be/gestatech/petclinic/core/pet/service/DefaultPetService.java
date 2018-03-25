package be.gestatech.petclinic.core.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.gestatech.petclinic.core.pet.dao.PetRepository;
import be.gestatech.petclinic.core.pet.entity.Pet;
import be.gestatech.petclinic.core.pet.entity.PetType;

@Service
public class DefaultPetService implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public List<PetType> findPetTypes() {
        return petRepository.findPetTypes();
    }

    @Override
    public Pet findById(Integer id) {
        return petRepository.findById(id);
    }

    @Override
    public void save(Pet pet) {
        petRepository.save(pet);
    }
}
