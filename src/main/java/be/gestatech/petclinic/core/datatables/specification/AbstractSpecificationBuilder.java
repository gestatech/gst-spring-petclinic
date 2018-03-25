package be.gestatech.petclinic.core.datatables.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import be.gestatech.petclinic.core.datatables.dto.Column;
import be.gestatech.petclinic.core.datatables.dto.DataTablesPageRequest;
import be.gestatech.petclinic.core.datatables.dto.DataTablesRequest;
import be.gestatech.petclinic.core.datatables.dto.Order;
import be.gestatech.petclinic.core.datatables.dto.Search;
import be.gestatech.petclinic.core.datatables.filter.ColumnFilter;
import be.gestatech.petclinic.core.datatables.filter.Filter;
import be.gestatech.petclinic.core.datatables.filter.GlobalFilter;

public abstract class AbstractSpecificationBuilder<T> {

    protected final DataTablesRequest dataTablesRequest;
    final boolean hasGlobalFilter;
    final Node<Filter> tree;

    public AbstractSpecificationBuilder(DataTablesRequest dataTablesRequest) {
        this.dataTablesRequest = dataTablesRequest;
        this.hasGlobalFilter = Objects.nonNull(dataTablesRequest.getSearch()) && Objects.nonNull(dataTablesRequest.getSearch().getValue()) && dataTablesRequest.getSearch().getValue().length() > 0;
        if (this.hasGlobalFilter) {
            tree = new Node<>(null, new GlobalFilter(dataTablesRequest.getSearch().getValue()));
        } else {
            tree = new Node<>(null);
        }
        initTree(dataTablesRequest);
    }

    private void initTree(DataTablesRequest dataTablesRequest) {
        for (Column column : dataTablesRequest.getColumns()) {
            if (column.getSearchable()) {
                addChild(tree, 0, column.getData().split("\\."), column.getSearch());
            }
        }
    }

    private void addChild(Node<Filter> parent, int index, String[] names, Search search) {
        boolean isLast = Objects.equals(names.length, index + 1);
        if (isLast) {
            boolean hasColumnFilter = Objects.nonNull(search) && Objects.nonNull(search.getValue()) && search.getValue().length() > 0;
            parent.addChild(new Node<>(names[index], hasColumnFilter ? new ColumnFilter(search.getValue()) : null));
        } else {
            Node<Filter> child = parent.getOrCreateChild(names[index]);
            addChild(child, index + 1, names, search);
        }
    }

    /**
     * Creates a 'LIMIT .. OFFSET .. ORDER BY ..' clause for the given {@link DataTablesPageRequest}.
     *
     * @return a {@link Pageable}, must not be {@literal null}.
     */
    public Pageable createPageable() {
        List<Sort.Order> orders = new ArrayList<>();
        for (Order order : dataTablesRequest.getOrder()) {
            Column column = dataTablesRequest.getColumns().get(order.getColumn());
            if (column.getOrderable()) {
                String sortColumn = column.getData();
                Sort.Direction sortDirection = Sort.Direction.fromString(order.getDir());
                orders.add(new Sort.Order(sortDirection, sortColumn));
            }
        }
        Sort sort = orders.isEmpty() ? null : new Sort(orders);
        if (Objects.equals(dataTablesRequest.getLength(), -1)) {
            dataTablesRequest.setStart(0);
            dataTablesRequest.setLength(Integer.MAX_VALUE);
        }
        return new DataTablesPageRequest(dataTablesRequest.getStart(), dataTablesRequest.getLength(), sort);
    }

    public abstract T build();
}