package be.gestatech.petclinic.core.pet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.gestatech.petclinic.core.pet.entity.Pet;
import be.gestatech.petclinic.core.pet.entity.PetType;

public interface PetRepository extends Repository<Pet, Integer> {

    @Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
    @Transactional(readOnly = true)
    List<PetType> findPetTypes();

    @Transactional(readOnly = true)
    Pet findById(Integer id);

    void save(Pet pet);
}
