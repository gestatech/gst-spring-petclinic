package be.gestatech.petclinic.web.function;

import java.util.List;

import be.gestatech.petclinic.core.datatables.dto.DataTablesResponse;

public interface genericDTOFunction<T, R> {

    List<R> groupByOwnersLastName(DataTablesResponse<T> response);
}
