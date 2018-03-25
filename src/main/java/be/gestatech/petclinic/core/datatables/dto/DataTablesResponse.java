package be.gestatech.petclinic.core.datatables.dto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonView;

public class DataTablesResponse <T> {
    /**
     * The draw counter that this object is a response to - from the draw parameter sent as part of
     * the data request. Note that it is strongly recommended for security reasons that you cast this
     * parameter to an integer, rather than simply echoing back to the client what it sent in the draw
     * parameter, in order to prevent Cross Site Scripting (XSS) attacks.
     */
    @JsonView(View.class)
    private int draw;

    /**
     * Total records, before filtering (i.e. the total number of records in the database)
     */
    @JsonView(View.class)
    private long recordsTotal = 0L;

    /**
     * Total records, after filtering (i.e. the total number of records after filtering has been
     * applied - not just the number of records being returned for this page of data).
     */
    @JsonView(View.class)
    private long recordsFiltered = 0L;

    /**
     * The data to be displayed in the table. This is an array of data source objects, one for each
     * row, which will be used by DataTables. Note that this parameter's name can be changed using the
     * ajaxDT option's dataSrc property.
     */
    @JsonView(View.class)
    private List<T> data = Collections.emptyList();

    /**
     * Optional: If an error occurs during the running of the server-side processing script, you can
     * inform the user of this error by passing back the error message to be displayed using this
     * parameter. Do not include if there is no error.
     */
    @JsonView(View.class)
    private String error;


    public DataTablesResponse() {
        // Intentionally left blank
    }

    public DataTablesResponse(final int draw, final long recordsTotal, final long recordsFiltered, final List<T> data, final String error) {
        this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
        this.error = error;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(final int draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(final long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(final long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(final List<T> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(final String error) {
        this.error = error;
    }

    @Override
    public boolean equals(final Object object) {
        if (Objects.equals(this, object)) {
            return true;
        }
        if (!(object instanceof DataTablesResponse)) {
            return false;
        }
        final DataTablesResponse<?> that = (DataTablesResponse<?>) object;
        return getDraw() == that.getDraw() &&
                getRecordsTotal() == that.getRecordsTotal() &&
                getRecordsFiltered() == that.getRecordsFiltered() &&
                Objects.equals(getData(), that.getData()) &&
                Objects.equals(getError(), that.getError());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDraw(), getRecordsTotal(), getRecordsFiltered(), getData(), getError());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DataTablesResponse{");
        sb.append("draw=").append(draw);
        sb.append(", recordsTotal=").append(recordsTotal);
        sb.append(", recordsFiltered=").append(recordsFiltered);
        sb.append(", data=").append(data);
        sb.append(", error='").append(error).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
