package be.gestatech.petclinic.core.datatables.dto;

import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Order {
    /**
     * Column to which ordering should be applied. This is an index reference to the columns array of
     * information that is also submitted to the server.
     */
    @NotNull
    @Min(0)
    private Integer column;

    /**
     * Ordering direction for this column. It will be asc or desc to indicate ascending ordering or
     * descending ordering, respectively.
     */
    @NotNull
    @Pattern(regexp = "(desc|asc)")
    private String dir;

    public Order() {
        // Intentionally left blank
    }

    public Order(final Integer column, final String dir) {
        this.column = column;
        this.dir = dir;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(final Integer column) {
        this.column = column;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(final String dir) {
        this.dir = dir;
    }

    @Override
    public boolean equals(final Object object) {
        if (Objects.equals(this, object)) {
            return true;
        }
        if (!(object instanceof Order)) {
            return false;
        }
        final Order order = (Order) object;
        return Objects.equals(getColumn(), order.getColumn()) &&
                Objects.equals(getDir(), order.getDir());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColumn(), getDir());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("column=").append(column);
        sb.append(", dir='").append(dir).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
