package be.gestatech.petclinic.web.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.gestatech.petclinic.core.datatables.dto.Column;
import be.gestatech.petclinic.core.datatables.dto.DataTablesRequest;
import be.gestatech.petclinic.core.datatables.dto.DataTablesResponse;
import be.gestatech.petclinic.core.datatables.dto.Order;
import be.gestatech.petclinic.core.owner.entity.Owner;
import be.gestatech.petclinic.web.dto.OwnerResponse;
import be.gestatech.petclinic.web.function.AgeCalculatorFunction;
import be.gestatech.petclinic.web.function.OwnerFunction;

@Component
public class OwnerDatatablesMapper implements DataTablesMapper<Owner, OwnerResponse> {

    private TimestampMapper timestampMapper;

    private OwnerFunction ownerFunction;

    private AgeCalculatorFunction ageCalculatorFunction;

    @Autowired
    public void setTimestampMapper(TimestampMapper timestampMapper) {
        this.timestampMapper = timestampMapper;
    }

    @Autowired
    public void setOwnerFunction(OwnerFunction ownerFunction) {
        this.ownerFunction = ownerFunction;
    }

    @Autowired
    public void setAgeCalculatorFunction(AgeCalculatorFunction ageCalculatorFunction) {
        this.ageCalculatorFunction = ageCalculatorFunction;
    }

    @Override
    public DataTablesResponse<OwnerResponse> mapToWebResponse(DataTablesResponse<Owner> input) {

        List<OwnerResponse> ownerResponses = new ArrayList<>();
        List<Owner> owners = ownerFunction.groupByOwnersLastName(input);
        for (Owner owner : owners) {
            OwnerResponse ownerResponse = new OwnerResponse();
            ownerResponse.setId(owner.getId());
            ownerResponse.setFirstName(owner.getFirstName());
            ownerResponse.setLastName(owner.getLastName());
            ownerResponse.setAddress(owner.getAddress());
            ownerResponse.setCity(owner.getCity());
            ownerResponse.setTelephone(owner.getTelephone());
            ownerResponse.setPets(owner.getPets());
            ownerResponse.setDateOfBirth(timestampMapper.mapToString(owner.getDateOfBirth()));
            ownerResponse.setAge(ageCalculatorFunction.compute(owner.getDateOfBirth()));
            ownerResponses.add(ownerResponse);
        }

        DataTablesResponse<OwnerResponse> output = new DataTablesResponse<>();
        output.setData(ownerResponses);
        output.setDraw(input.getDraw());
        if (Objects.equals(ownerResponses.size(), input.getRecordsFiltered())) {
            output.setRecordsFiltered(input.getRecordsFiltered());
            output.setRecordsTotal(input.getRecordsTotal());
        } else {
            output.setRecordsFiltered(ownerResponses.size());
            output.setRecordsTotal(ownerResponses.size());
        }
        output.setError(input.getError());
        return output;
    }

    @Override
    public DataTablesRequest mapToServerRequest(DataTablesRequest input) {

        DataTablesRequest output = new DataTablesRequest();

        List<Column> filteredColumns = input.getColumns().stream()
                .filter(column -> !Objects.equals(column.getData(), "age") && !Objects.equals(column.getData(), "hasPets"))
                .collect(Collectors.toList());
        List<Order> filteredOrders = input.getOrder().stream()
                .filter(order -> !Objects.equals(order.getColumn(), 7) && !Objects.equals(order.getColumn(), 8))
                .collect(Collectors.toList());

        output.setColumns(filteredColumns);
        output.setDraw(input.getDraw());
        output.setLength(input.getLength());
        output.setOrder(filteredOrders);
        output.setSearch(input.getSearch());
        output.setStart(input.getStart());

        return output;
    }
}
