package be.gestatech.petclinic.core.owner.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import be.gestatech.petclinic.core.owner.dao.OwnerRepository;
import be.gestatech.petclinic.core.owner.entity.Owner;

@Service
public class DefaultOwnerService implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Collection<Owner> findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Page<Owner> findByLastName(String lastName, Pageable pageRequest) {
        return ownerRepository.findByLastName(lastName, pageRequest);
    }

    @Override
    public Owner findById(Integer ownerId) {
        return ownerRepository.findById(ownerId);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

}
