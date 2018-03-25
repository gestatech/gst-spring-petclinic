package be.gestatech.petclinic.core.owner.service;

import be.gestatech.petclinic.core.datatables.dto.DataTablesRequest;
import be.gestatech.petclinic.core.datatables.dto.DataTablesResponse;
import be.gestatech.petclinic.core.owner.entity.Owner;

public interface OwnerDataTablesService {

    DataTablesResponse<Owner> findAll(DataTablesRequest dataTablesRequest);
}
