package be.gestatech.petclinic.core.datatables.filter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;

import static java.util.Collections.unmodifiableSet;

public class ColumnFilter extends GlobalFilter {

    private Set<String> values = new HashSet<>();
    private Set<Boolean> booleanValues = new HashSet<>();
    private boolean addNullCase;
    private boolean isBooleanComparison;

    public ColumnFilter(String filterValue) {
        super(filterValue);

        isBooleanComparison = true;
        for (String value : filterValue.split("\\+")) {
            if (Objects.equals("NULL", value)) {
                addNullCase = true;
            } else {
                isBooleanComparison &= isBoolean(value);
                values.add(nullOrTrimmedValue(value));
            }
        }
        values = unmodifiableSet(values);

        if (isBooleanComparison) {
            for (String value : values) {
                booleanValues.add(Boolean.valueOf(value));
            }
            booleanValues = unmodifiableSet(booleanValues);
        }
    }

    private boolean isBoolean(String filterValue) {
        return "TRUE".equalsIgnoreCase(filterValue) || "FALSE".equalsIgnoreCase(filterValue);
    }

    @Override
    public Predicate createPredicate(From<?, ?> from, CriteriaBuilder criteriaBuilder, String attributeName) {
        Expression<?> expression = from.get(attributeName);
        if (values.isEmpty()) {
            return addNullCase ? expression.isNull() : criteriaBuilder.conjunction();
        } else if (isBasicFilter()) {
            return super.createPredicate(from, criteriaBuilder, attributeName);
        }
        Predicate predicate;
        if (isBooleanComparison) {
            predicate = expression.in(booleanValues);
        } else {
            predicate = expression.as(String.class).in(values);
        }
        if (addNullCase) {
            predicate = criteriaBuilder.or(predicate, expression.isNull());
        }
        return predicate;
    }

    private boolean isBasicFilter() {
        return values.size() == 1 && !addNullCase && !isBooleanComparison;
    }
}