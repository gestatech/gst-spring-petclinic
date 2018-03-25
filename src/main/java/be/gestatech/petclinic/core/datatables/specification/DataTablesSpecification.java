package be.gestatech.petclinic.core.datatables.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.FetchParent;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.jpa.criteria.path.AbstractPathImpl;
import org.springframework.data.jpa.domain.Specification;

import be.gestatech.petclinic.core.datatables.dto.DataTablesRequest;
import be.gestatech.petclinic.core.datatables.filter.Filter;

public class DataTablesSpecification<S> extends AbstractSpecificationBuilder<Specification<S>> implements Specification<S> {

    private List<Predicate> columnPredicates = new ArrayList<>();
    private List<Predicate> globalPredicates = new ArrayList<>();

    public DataTablesSpecification(final DataTablesRequest dataTablesRequest) {
        super(dataTablesRequest);
    }

    @Override
    public Predicate toPredicate(Root<S> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        initPredicatesRecursively(tree, root, root, criteriaBuilder);

        boolean isCountQuery = Objects.equals(Long.class, query.getResultType());
        if (isCountQuery) {
            root.getFetches().clear();
        }

        return createFinalPredicate(criteriaBuilder);
    }

    private void initPredicatesRecursively(Node<Filter> node,
                                           From<S, S> from,
                                           FetchParent<S, S> fetch,
                                           CriteriaBuilder criteriaBuilder) {
        if (node.isLeaf()) {
            boolean hasColumnFilter = Objects.nonNull(node.getData());
            if (hasColumnFilter) {
                Filter columnFilter = node.getData();
                columnPredicates.add(columnFilter.createPredicate(from, criteriaBuilder, node.getName()));
            } else if (hasGlobalFilter) {
                Filter globalFilter = tree.getData();
                globalPredicates.add(globalFilter.createPredicate(from, criteriaBuilder, node.getName()));
            }
        }
        for (Node<Filter> child : node.getChildren()) {
            Path<Object> path = from.get(child.getName());
            if (path instanceof AbstractPathImpl) {
                if (((AbstractPathImpl) path).getAttribute().isCollection()) {
                    // ignore OneToMany and ManyToMany relationships
                    continue;
                }
            }
            if (child.isLeaf()) {
                initPredicatesRecursively(child, from, fetch, criteriaBuilder);
            } else {
                Join<S, S> join = from.join(child.getName(), JoinType.LEFT);
                Fetch<S, S> childFetch = fetch.fetch(child.getName(), JoinType.LEFT);
                initPredicatesRecursively(child, join, childFetch, criteriaBuilder);
            }
        }
    }

    private Predicate createFinalPredicate(CriteriaBuilder criteriaBuilder) {
        List<Predicate> allPredicates = new ArrayList<>(columnPredicates);
        if (!globalPredicates.isEmpty()) {
            allPredicates.add(criteriaBuilder.or(globalPredicates.toArray(new Predicate[0])));
        }
        return allPredicates.isEmpty() ? criteriaBuilder.conjunction()
                : criteriaBuilder.and(allPredicates.toArray(new Predicate[0]));
    }

    @Override
    public Specification<S> build() {
        return this;
    }
}