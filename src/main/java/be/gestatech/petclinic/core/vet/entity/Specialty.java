package be.gestatech.petclinic.core.vet.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import be.gestatech.petclinic.core.base.NamedEntity;

@Entity
@Table(name = "specialty")
public class Specialty extends NamedEntity implements Serializable {

}
