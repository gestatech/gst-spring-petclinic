package be.gestatech.petclinic.core.datatables.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Column {
    /**
     * Column's data source
     *
     * @see http://datatables.net/reference/option/columns.data
     */
    @NotBlank
    private String data;

    /**
     * Column's name
     *
     * @see http://datatables.net/reference/option/columns.name
     */
    private String name;

    /**
     * Flag to indicate if this column is searchable (true) or not (false).
     *
     * @see http://datatables.net/reference/option/columns.searchable
     */
    @NotNull
    private Boolean searchable;

    /**
     * Flag to indicate if this column is orderable (true) or not (false).
     *
     * @see http://datatables.net/reference/option/columns.orderable
     */
    @NotNull
    private Boolean orderable;

    /**
     * Search value to apply to this specific column.
     */
    @NotNull
    private Search search;

    public Column() {
        // Intentionally left blank
    }

    public Column(final String data, final String name, final Boolean searchable, final Boolean orderable, final Search search) {
        this.data = data;
        this.name = name;
        this.searchable = searchable;
        this.orderable = orderable;
        this.search = search;
    }

    public String getData() {
        return data;
    }

    public void setData(final String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Boolean getSearchable() {
        return searchable;
    }

    public void setSearchable(final Boolean searchable) {
        this.searchable = searchable;
    }

    public Boolean getOrderable() {
        return orderable;
    }

    public void setOrderable(final Boolean orderable) {
        this.orderable = orderable;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(final Search search) {
        this.search = search;
    }

    /**
     * Set the search value to apply to this column
     * @param searchValue if any, the search value to apply
     */
    public void setSearchValue(String searchValue) {
        this.search.setValue(searchValue);
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Column)) {
            return false;
        }
        final Column column = (Column) object;
        return Objects.equals(getData(), column.getData()) &&
                Objects.equals(getName(), column.getName()) &&
                Objects.equals(getSearchable(), column.getSearchable()) &&
                Objects.equals(getOrderable(), column.getOrderable()) &&
                Objects.equals(getSearch(), column.getSearch());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getName(), getSearchable(), getOrderable(), getSearch());
    }
}