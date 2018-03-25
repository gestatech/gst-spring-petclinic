package be.gestatech.petclinic.core.datatables.filter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;

public interface Filter {
    Predicate createPredicate(From<?, ?> from, CriteriaBuilder criteriaBuilder, String attributeName);
}
