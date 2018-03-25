package be.gestatech.petclinic.core.owner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.gestatech.petclinic.core.datatables.dto.DataTablesRequest;
import be.gestatech.petclinic.core.datatables.dto.DataTablesResponse;
import be.gestatech.petclinic.core.owner.dao.OwnerDataTablesRepository;
import be.gestatech.petclinic.core.owner.entity.Owner;

@Service
public class DefaultOwnerDataTablesService implements OwnerDataTablesService {

    @Autowired
    private OwnerDataTablesRepository ownerDataTablesRepository;

    @Override
    public DataTablesResponse<Owner> findAll(DataTablesRequest dataTablesRequest) {
        return ownerDataTablesRepository.findAll(dataTablesRequest);
    }
}
