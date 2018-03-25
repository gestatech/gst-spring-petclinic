package be.gestatech.petclinic.web.function;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import be.gestatech.petclinic.core.datatables.dto.DataTablesResponse;
import be.gestatech.petclinic.core.datatables.filter.FilterUtil;
import be.gestatech.petclinic.core.owner.entity.Owner;

@Component
public class OwnerFunction implements  genericDTOFunction<Owner, Owner> {

    public List<Owner> groupByOwnersLastName(DataTablesResponse<Owner> response) {
        //return response.getData().stream().filter(FilterUtil.distinctByKey(Owner::getLastName)).collect(Collectors.toList());
        return response.getData().stream().collect(Collectors.toList());
    }
}
