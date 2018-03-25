package be.gestatech.petclinic.core.datatables.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;

public class Search {

    /**
     * Global search value. To be applied to all columns which have searchable as true.
     */
    @NotNull
    private String value;

    /**
     * true if the global filter should be treated as a regular expression for advanced searching,
     * false otherwise. Note that normally server-side processing scripts will not perform regular
     * expression searching for performance reasons on large data sets, but it is technically possible
     * and at the discretion of your script.
     */
    @NotNull
    private Boolean regex;


    public Search() {
        // Intentionally left blank.
    }

    public Search(final String value, final Boolean regex) {
        this.value = value;
        this.regex = regex;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public Boolean getRegex() {
        return regex;
    }

    public void setRegex(final Boolean regex) {
        this.regex = regex;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Search)) {
            return false;
        }
        final Search search = (Search) object;
        return Objects.equals(getValue(), search.getValue()) &&
                Objects.equals(getRegex(), search.getRegex());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getRegex());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Search{");
        sb.append("value='").append(value).append('\'');
        sb.append(", regex=").append(regex);
        sb.append('}');
        return sb.toString();
    }
}
