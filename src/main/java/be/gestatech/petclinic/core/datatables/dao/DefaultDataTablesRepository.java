package be.gestatech.petclinic.core.datatables.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import be.gestatech.petclinic.core.datatables.dto.DataTablesRequest;
import be.gestatech.petclinic.core.datatables.dto.DataTablesResponse;
import be.gestatech.petclinic.core.datatables.specification.SpecificationBuilder;

public class DefaultDataTablesRepository <T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements DataTablesRepository<T, ID> {

    public DefaultDataTablesRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    @Override
    public DataTablesResponse<T> findAll(DataTablesRequest dataTablesRequest) {
        return findAll(dataTablesRequest, null, null, null);
    }

    @Override
    public DataTablesResponse<T> findAll(DataTablesRequest dataTablesRequest, Specification<T> additionalSpecification) {
        return findAll(dataTablesRequest, additionalSpecification, null, null);
    }

    @Override
    public DataTablesResponse<T> findAll(DataTablesRequest dataTablesRequest, Specification<T> additionalSpecification, Specification<T> preFilteringSpecification) {
        return findAll(dataTablesRequest, additionalSpecification, preFilteringSpecification, null);
    }

    @Override
    public <R> DataTablesResponse<R> findAll(DataTablesRequest dataTablesRequest, Converter<T, R> converter) {
        return findAll(dataTablesRequest, null, null, converter);
    }

    @Override
    public <R> DataTablesResponse<R> findAll(DataTablesRequest dataTablesRequest, Specification<T> additionalSpecification, Specification<T> preFilteringSpecification, Converter<T, R> converter) {
        DataTablesResponse<R> output = new DataTablesResponse<>();
        output.setDraw(dataTablesRequest.getDraw());
        if (Objects.equals(0, dataTablesRequest.getLength())) {
            return output;
        }
        try {
            long recordsTotal = Objects.isNull(preFilteringSpecification) ? count() : count(preFilteringSpecification);
            if (Objects.equals(0, recordsTotal)) {
                return output;
            }
            output.setRecordsTotal(recordsTotal);
            SpecificationBuilder<T> specificationBuilder = new SpecificationBuilder<>(dataTablesRequest);
            Page<T> data = findAll(Specifications.where(specificationBuilder.build())
                            .and(additionalSpecification)
                            .and(preFilteringSpecification), specificationBuilder.createPageable());

            @SuppressWarnings("unchecked")
            List<R> content = Objects.isNull(converter) ? (List<R>) data.getContent() : data.map(converter).getContent();
            output.setData(content);
            output.setRecordsFiltered(data.getTotalElements());

        } catch (Exception exception) {
            output.setError(exception.toString());
        }
        return output;
    }

}
