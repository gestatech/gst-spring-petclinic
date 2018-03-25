package be.gestatech.petclinic.core.owner.service;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import be.gestatech.petclinic.core.owner.entity.Owner;

public interface OwnerService {

    Collection<Owner> findByLastName(String lastName);

    Owner findById(Integer ownerId);

    Page<Owner> findByLastName(String lastName, Pageable pageRequest);

    Owner save(Owner owner);
}
