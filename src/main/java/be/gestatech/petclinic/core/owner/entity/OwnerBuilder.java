package be.gestatech.petclinic.core.owner.entity;

import be.gestatech.petclinic.core.pet.entity.Pet;

public class OwnerBuilder {

    private Owner owner;

    public OwnerBuilder() {
        owner = new Owner();
    }

    public OwnerBuilder withPet(Pet pet) {
        owner.addPet(pet);
        return this;
    }

    public OwnerBuilder withAddress(String address) {
        owner.setAddress(address);
        return this;
    }

    public OwnerBuilder withCity(String city) {
        owner.setCity(city);
        return this;
    }

    public OwnerBuilder withTelephone(String telephone) {
        owner.setTelephone(telephone);
        return this;
    }

    public Owner build() {
        return owner;
    }
}
