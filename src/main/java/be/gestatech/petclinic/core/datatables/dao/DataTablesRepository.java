package be.gestatech.petclinic.core.datatables.dao;

import java.io.Serializable;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import be.gestatech.petclinic.core.datatables.dto.DataTablesRequest;
import be.gestatech.petclinic.core.datatables.dto.DataTablesResponse;

@NoRepositoryBean
public interface DataTablesRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID>, JpaSpecificationExecutor<T> {

    DataTablesResponse<T> findAll(DataTablesRequest dataTablesRequest);

    DataTablesResponse<T> findAll(DataTablesRequest dataTablesRequest, Specification<T> additionalSpecification);

    DataTablesResponse<T> findAll(DataTablesRequest dataTablesRequest, Specification<T> additionalSpecification, Specification<T> preFilteringSpecification);

    <R> DataTablesResponse<R> findAll(DataTablesRequest dataTablesRequest, Converter<T, R> converter);

    <R> DataTablesResponse<R> findAll(DataTablesRequest dataTablesRequest, Specification<T> additionalSpecification, Specification<T> preFilteringSpecification, Converter<T, R> converter);
}
