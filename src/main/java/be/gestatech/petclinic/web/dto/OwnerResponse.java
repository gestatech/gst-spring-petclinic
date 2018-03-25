package be.gestatech.petclinic.web.dto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import be.gestatech.petclinic.core.pet.entity.Pet;

public class OwnerResponse {

    private Integer id;

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String telephone;

    private List<Pet> pets = Collections.EMPTY_LIST;

    private String dateOfBirth;

    private Integer age;

    private boolean hasPets;

    public OwnerResponse() {
        // Intentionally left blank
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(final String telephone) {
        this.telephone = telephone;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(final List<Pet> pets) {
        hasPet(pets);
        this.pets = pets;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public boolean getHasPets() {
        return hasPets;
    }

    public void setHasPets(final boolean hasPets) {
        this.hasPets = hasPets;
    }

    private void hasPet(List<Pet> pets) {
        this.hasPets = Objects.nonNull(this.pets) && !pets.isEmpty();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OwnerResponse{");
        sb.append("id='").append(id).append('\'');
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", telephone='").append(telephone).append('\'');
        sb.append(", pets=").append(pets);
        sb.append(", dateOfBirth='").append(dateOfBirth).append('\'');
        sb.append(", age='").append(age).append('\'');
        sb.append(", hasPets='").append(hasPets).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
