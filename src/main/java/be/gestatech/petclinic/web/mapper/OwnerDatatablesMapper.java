package be.gestatech.petclinic.web.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(OwnerDatatablesMapper.class);

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
        Map<String, List<Owner>> ownersPerLastName = ownerFunction.groupByOwnersLastName(input);
        logger.error("ownersPerLastName {}", ownersPerLastName.toString());
        ownersPerLastName.entrySet().forEach(owner -> {
            List<Owner> owners = owner.getValue();
            OwnerResponse ownerResponse = new OwnerResponse();
            logger.error("owner.getKey() {}", owner.getKey());
            ownerResponse.setLastName(owner.getKey());
            owners.forEach(ownerByLastNamer -> {
                logger.error("owner.getKey() {}", owner.getKey());
                logger.error(" ownerByLastNamer.getLastName() {}", ownerByLastNamer.getLastName());
                ownerResponse.setId(ownerByLastNamer.getId());
                ownerResponse.setFirstName(ownerByLastNamer.getFirstName());
                ownerResponse.setAddress(ownerByLastNamer.getAddress());
                ownerResponse.setCity(ownerByLastNamer.getCity());
                ownerResponse.setTelephone(ownerByLastNamer.getTelephone());
                ownerResponse.setPets(ownerByLastNamer.getPets());
                ownerResponse.setDateOfBirth(timestampMapper.mapToString(ownerByLastNamer.getDateOfBirth()));
                ownerResponse.setAge(ageCalculatorFunction.compute(ownerByLastNamer.getDateOfBirth()));
            });
            ownerResponses.add(ownerResponse);
        });

        DataTablesResponse<OwnerResponse> output = new DataTablesResponse<>();
        output.setData(ownerResponses);
        output.setDraw(input.getDraw());
        output.setRecordsFiltered(input.getRecordsFiltered());
        output.setRecordsTotal(input.getRecordsTotal());
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
