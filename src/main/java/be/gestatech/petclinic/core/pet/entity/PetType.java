package be.gestatech.petclinic.core.pet.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import be.gestatech.petclinic.core.base.NamedEntity;

@Entity
@Table(name = "type")
public class PetType extends NamedEntity {

}