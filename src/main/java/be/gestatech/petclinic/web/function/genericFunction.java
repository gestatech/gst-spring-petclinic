package be.gestatech.petclinic.web.function;

import java.util.List;
import java.util.Map;

import be.gestatech.petclinic.core.datatables.dto.DataTablesResponse;

public interface genericFunction<T, R> {

    Map<String, List<R>> groupByOwnersLastName(DataTablesResponse<T> response);
}
