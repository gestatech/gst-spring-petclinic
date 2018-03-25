package be.gestatech.petclinic.core.datatables.dto;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class DataTablesPageRequest implements Pageable {

    private final int offset;
    private final int pageSize;
    private final Sort sort;

    public DataTablesPageRequest(int offset, int pageSize, Sort sort) {
        this.offset = offset;
        this.pageSize = pageSize;
        this.sort = sort;
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public Pageable next() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Pageable previousOrFirst() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Pageable first() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasPrevious() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getPageNumber() {
        throw new UnsupportedOperationException();
    }
}
