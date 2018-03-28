package be.gestatech.petclinic.web.function;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import be.gestatech.petclinic.core.datatables.dto.DataTablesResponse;
import be.gestatech.petclinic.core.owner.entity.Owner;

@Component
public class OwnerFunction implements genericFunction<Owner, Owner> {

    public Map<String, List<Owner>> groupByOwnersLastName(DataTablesResponse<Owner> response) {
        return  response.getData().stream().collect(Collectors.groupingBy(Owner::getLastName));
    }
}
