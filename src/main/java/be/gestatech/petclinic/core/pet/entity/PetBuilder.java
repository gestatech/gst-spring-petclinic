package be.gestatech.petclinic.core.pet.entity;

import java.util.Date;

import be.gestatech.petclinic.core.owner.entity.Owner;
import be.gestatech.petclinic.core.visit.entity.Visit;

public class PetBuilder {

    private Pet pet;

    public PetBuilder() {
        pet = new Pet();
    }

    public PetBuilder withOwner(Owner owner) {
        pet.setOwner(owner);
        return this;
    }

    public PetBuilder withBirthDate(Date birthDate) {
        pet.setBirthDate(birthDate);
        return this;
    }

    public PetBuilder withType(PetType type) {
        pet.setType(type);
        return this;
    }

    public PetBuilder withVisits(Visit visit) {
        pet.addVisit(visit);
        return this;
    }

    public Pet build() {
        return pet;
    }
}