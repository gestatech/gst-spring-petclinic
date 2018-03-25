package be.gestatech.petclinic.core.owner.dao;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import be.gestatech.petclinic.core.owner.entity.Owner;

public interface OwnerRepository extends JpaRepository <Owner, Integer> {

    @Query("SELECT DISTINCT owner FROM Owner owner left join fetch owner.pets WHERE owner.lastName LIKE :lastName%")
    @Transactional(readOnly = true)
    Collection<Owner> findByLastName(@Param("lastName") String lastName);

    @Query("SELECT DISTINCT owner FROM Owner owner join owner.pets WHERE owner.lastName LIKE :lastName%")
    @Transactional(readOnly = true)
    Page<Owner> findByLastName(@Param("lastName") String lastName, Pageable pageRequest);

    @Query("SELECT owner FROM Owner owner left join fetch owner.pets WHERE owner.id =:id")
    @Transactional(readOnly = true)
    Owner findById(@Param("id") Integer id);

    @Transactional(readOnly = true)
    Owner save(Owner owner);
}
