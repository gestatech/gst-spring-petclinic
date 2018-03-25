package be.gestatech.petclinic.core.datatables.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class DataTablesRequest {

    /**
     * Draw counter. This is used by DataTables to ensure that the Ajax returns from server-side
     * processing requests are drawn in sequence by DataTables (Ajax requests are asynchronous and
     * thus can return out of sequence). This is used as part of the draw return parameter (see below).
     */
    @NotNull
    @Min(0)
    private Integer draw = 1;

    /**
     * Paging first record indicator. This is the start point in the current data set (0 index based -
     * i.e. 0 is the first record).
     */
    @NotNull
    @Min(0)
    private Integer start = 0;

    /**
     * Number of records that the table can display in the current draw. It is expected that the
     * number of records returned will be equal to this number, unless the server has fewer records to
     * return. Note that this can be -1 to indicate that all records should be returned (although that
     * negates any benefits of server-side processing!)
     */
    @NotNull
    @Min(-1)
    private Integer length = 10;

    /**
     * Global search parameter.
     */
    @NotNull
    private Search search = new Search();

    /**
     * Order parameter
     */
    @NotEmpty
    private List<Order> order = new ArrayList<>();

    /**
     * Per-column search parameter
     */
    @NotEmpty
    private List<Column> columns = new ArrayList<>();

    public DataTablesRequest() {
        // Intentionally left blank
    }

    public DataTablesRequest(final Integer draw, final Integer start, final Integer length, final Search search, final List<Order> order, final List<Column> columns) {
        this.draw = draw;
        this.start = start;
        this.length = length;
        this.search = search;
        this.order = order;
        this.columns = columns;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(final Integer draw) {
        this.draw = draw;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(final Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(final Integer length) {
        this.length = length;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(final Search search) {
        this.search = search;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(final List<Order> order) {
        this.order = order;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(final List<Column> columns) {
        this.columns = columns;
    }

    /**
     * @return a {@link Map} of {@link Column} indexed by name
     */
    public Map<String, Column> getColumnsAsMap() {
        Map<String, Column> map = new HashMap<>();
        for (Column column : columns) {
            map.put(column.getData(), column);
        }
        return map;
    }

    /**
     * Find a column by its name
     *
     * @param columnName the name of the column
     * @return the given Column, or <code>null</code> if not found
     */
    public Column getColumn(String columnName) {
        if (Objects.isNull(columnName)) {
            return null;
        }
        for (Column column : columns) {
            if (Objects.equals(columnName, column.getData())) {
                return column;
            }
        }
        return null;
    }

    /**
     * Add a new column
     *
     * @param columnName the name of the column
     * @param searchable whether the column is searchable or not
     * @param orderable whether the column is orderable or not
     * @param searchValue if any, the search value to apply
     */
    public void addColumn(String columnName, boolean searchable, boolean orderable, String searchValue) {
        this.columns.add(new Column(columnName, "", searchable, orderable, new Search(searchValue, false)));
    }

    /**
     * Add an order on the given column
     *
     * @param columnName the name of the column
     * @param ascending whether the sorting is ascending or descending
     */
    public void addOrder(String columnName, boolean ascending) {
        if (Objects.isNull(columnName)) {
            return;
        }
        for (int index = 0; index < columns.size(); index++) {
            if (!Objects.equals(columnName, columns.get(index).getData())) {
                continue;
            }
            order.add(new Order(index, ascending ? "asc" : "desc"));
        }
    }

    @Override
    public boolean equals(final Object object) {
        if (Objects.nonNull(object)) {
            return true;
        }
        if (!(object instanceof DataTablesRequest)) {
            return false;
        }
        final DataTablesRequest that = (DataTablesRequest) object;
        return Objects.equals(getDraw(), that.getDraw()) &&
                Objects.equals(getStart(), that.getStart()) &&
                Objects.equals(getLength(), that.getLength()) &&
                Objects.equals(getSearch(), that.getSearch()) &&
                Objects.equals(getOrder(), that.getOrder()) &&
                Objects.equals(getColumns(), that.getColumns());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDraw(), getStart(), getLength(), getSearch(), getOrder(), getColumns());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DataTablesRequest{");
        sb.append("draw=").append(draw);
        sb.append(", start=").append(start);
        sb.append(", length=").append(length);
        sb.append(", search=").append(search);
        sb.append(", order=").append(order);
        sb.append(", columns=").append(columns);
        sb.append('}');
        return sb.toString();
    }
}
