package be.gestatech.petclinic.web.mapper;

import be.gestatech.petclinic.core.datatables.dto.DataTablesRequest;
import be.gestatech.petclinic.core.datatables.dto.DataTablesResponse;

public interface DataTablesMapper<T, R> {

    DataTablesResponse<R> mapToWebResponse(DataTablesResponse<T> input);

    DataTablesRequest mapToServerRequest(DataTablesRequest input);
}
