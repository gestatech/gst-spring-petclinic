package be.gestatech.petclinic.core.datatables.specification;

import org.springframework.data.jpa.domain.Specification;

import be.gestatech.petclinic.core.datatables.dto.DataTablesRequest;

public class SpecificationBuilder<T> extends AbstractSpecificationBuilder<Specification<T>> {

    public SpecificationBuilder(DataTablesRequest dataTablesRequest) {
        super(dataTablesRequest);
    }

    @Override
    public Specification<T> build() {
        return new DataTablesSpecification<>(dataTablesRequest);
    }
}
