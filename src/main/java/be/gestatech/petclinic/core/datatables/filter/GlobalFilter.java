package be.gestatech.petclinic.core.datatables.filter;

import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;

/**
 * Filter which creates a basic "WHERE ... LIKE ..." clause
 */
public class GlobalFilter implements Filter {

    private final String escapedRawValue;

    public GlobalFilter(String filterValue) {
        escapedRawValue = escapeValue(filterValue);
    }

    String nullOrTrimmedValue(String value) {
        return Objects.equals("\\NULL", value) ? "NULL" : value.trim();
    }

    private String escapeValue(String filterValue) {
        return "%" + nullOrTrimmedValue(filterValue).toLowerCase()
                .replaceAll("~", "~~")
                .replaceAll("%", "~%")
                .replaceAll("_", "~_") + "%";
    }

    @Override
    public Predicate createPredicate(From<?, ?> from, CriteriaBuilder criteriaBuilder, String attributeName) {
        Expression<?> expression = from.get(attributeName);
        return criteriaBuilder.like(criteriaBuilder.lower(expression.as(String.class)), escapedRawValue, '~');
    }
}
