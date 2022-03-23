package com.bbva.pzic.loansagreements.util.mappers;

import com.bbva.pzic.loansagreements.canonic.Pagination;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Entelgy
 */
public class PaginationMapperTest {

    private com.bbva.jee.arq.spring.core.servicing.utils.Pagination pagination;

    @Before
    public void setUp() {
        pagination = new com.bbva.jee.arq.spring.core.servicing.utils.Pagination();
        pagination.setFirstPage("/service/V01/service?customerId=A9244758");
        pagination.setLastPage("/service/V01/service?customerId=A9244758&paginationKey=LAST");
        pagination.setNextPage("/service/V01/service?customerId=A9244758&paginationKey=facb4747f&pageSize=20");
        pagination.setPreviousPage("/service/V01/service?customerId=A9244758&paginationKey=facb4747f&pageSize=19");
        pagination.setPage(1L);
        pagination.setNumPages(2L);
        pagination.setTotal(3L);
        pagination.setPageSize(4L);
    }

    @Test
    public void paginationBuilderTest() {
        Pagination result = PaginationMapper.build(pagination);

        assertNotNull(result);
        assertNotNull(result.getLinks().getFirst());
        assertNotNull(result.getLinks().getLast());
        assertNotNull(result.getLinks().getPrevious());
        assertNotNull(result.getLinks().getNext());
        assertNotNull(result.getPage());
        assertNotNull(result.getTotalPages());
        assertNotNull(result.getTotalElements());
        assertNotNull(result.getPageSize());

        assertEquals(pagination.getFirstPage(), result.getLinks().getFirst());
        assertEquals(pagination.getLastPage(), result.getLinks().getLast());
        assertEquals(pagination.getPreviousPage(), result.getLinks().getPrevious());
        assertEquals(pagination.getNextPage(), result.getLinks().getNext());
        assertEquals(pagination.getPage(), result.getPage());
        assertEquals(pagination.getNumPages(), result.getTotalPages());
        assertEquals(pagination.getTotal(), result.getTotalElements());
        assertEquals(pagination.getPageSize(), result.getPageSize());
    }

    @Test
    public void paginationBuilderWithPagePaginationNullTest() {
        pagination.setPage(null);
        Pagination result = PaginationMapper.build(pagination);

        assertNotNull(result);
        assertNotNull(result.getLinks().getFirst());
        assertNotNull(result.getLinks().getLast());
        assertNotNull(result.getLinks().getPrevious());
        assertNotNull(result.getLinks().getNext());
        assertNull(result.getPage());
        assertNotNull(result.getTotalPages());
        assertNotNull(result.getTotalElements());
        assertNotNull(result.getPageSize());

        assertEquals(pagination.getFirstPage(), result.getLinks().getFirst());
        assertEquals(pagination.getLastPage(), result.getLinks().getLast());
        assertEquals(pagination.getPreviousPage(), result.getLinks().getPrevious());
        assertEquals(pagination.getNextPage(), result.getLinks().getNext());
        assertEquals(pagination.getNumPages(), result.getTotalPages());
        assertEquals(pagination.getTotal(), result.getTotalElements());
        assertEquals(pagination.getPageSize(), result.getPageSize());
    }

    @Test
    public void paginationBuilderWithNumPagesPaginationNullTest() {
        pagination.setNumPages(null);
        Pagination result = PaginationMapper.build(pagination);

        assertNotNull(result);
        assertNotNull(result.getLinks().getFirst());
        assertNotNull(result.getLinks().getLast());
        assertNotNull(result.getLinks().getPrevious());
        assertNotNull(result.getLinks().getNext());
        assertNotNull(result.getPage());
        assertNull(result.getTotalPages());
        assertNotNull(result.getTotalElements());
        assertNotNull(result.getPageSize());

        assertEquals(pagination.getFirstPage(), result.getLinks().getFirst());
        assertEquals(pagination.getLastPage(), result.getLinks().getLast());
        assertEquals(pagination.getPreviousPage(), result.getLinks().getPrevious());
        assertEquals(pagination.getNextPage(), result.getLinks().getNext());
        assertEquals(pagination.getPage(), result.getPage());
        assertEquals(pagination.getTotal(), result.getTotalElements());
        assertEquals(pagination.getPageSize(), result.getPageSize());
    }

    @Test
    public void paginationBuilderWithTotalPaginationNullTest() {
        pagination.setTotal(null);
        Pagination result = PaginationMapper.build(pagination);

        assertNotNull(result);
        assertNotNull(result.getLinks().getFirst());
        assertNotNull(result.getLinks().getLast());
        assertNotNull(result.getLinks().getPrevious());
        assertNotNull(result.getLinks().getNext());
        assertNotNull(result.getPage());
        assertNotNull(result.getTotalPages());
        assertNull(result.getTotalElements());
        assertNotNull(result.getPageSize());

        assertEquals(pagination.getFirstPage(), result.getLinks().getFirst());
        assertEquals(pagination.getLastPage(), result.getLinks().getLast());
        assertEquals(pagination.getPreviousPage(), result.getLinks().getPrevious());
        assertEquals(pagination.getNextPage(), result.getLinks().getNext());
        assertEquals(pagination.getPage(), result.getPage());
        assertEquals(pagination.getNumPages(), result.getTotalPages());
        assertEquals(pagination.getPageSize(), result.getPageSize());
    }

    @Test
    public void paginationBuilderWithPageSizePaginationNullTest() {
        pagination.setPageSize(null);
        Pagination result = PaginationMapper.build(pagination);

        assertNotNull(result);
        assertNotNull(result.getLinks().getFirst());
        assertNotNull(result.getLinks().getLast());
        assertNotNull(result.getLinks().getPrevious());
        assertNotNull(result.getLinks().getNext());
        assertNotNull(result.getPage());
        assertNotNull(result.getTotalPages());
        assertNotNull(result.getTotalElements());
        assertNull(result.getPageSize());

        assertEquals(pagination.getFirstPage(), result.getLinks().getFirst());
        assertEquals(pagination.getLastPage(), result.getLinks().getLast());
        assertEquals(pagination.getPreviousPage(), result.getLinks().getPrevious());
        assertEquals(pagination.getNextPage(), result.getLinks().getNext());
        assertEquals(pagination.getPage(), result.getPage());
        assertEquals(pagination.getNumPages(), result.getTotalPages());
        assertEquals(pagination.getTotal(), result.getTotalElements());
    }

    @Test
    public void paginationBuilderWithPreviousPaginationNullTest() {
        pagination.setPreviousPage(null);
        Pagination result = PaginationMapper.build(pagination);

        assertNotNull(result);
        assertNotNull(result.getLinks().getFirst());
        assertNotNull(result.getLinks().getLast());
        assertNull(result.getLinks().getPrevious());
        assertNotNull(result.getLinks().getNext());
        assertNotNull(result.getPage());
        assertNotNull(result.getTotalPages());
        assertNotNull(result.getTotalElements());
        assertNotNull(result.getPageSize());

        assertEquals(pagination.getFirstPage(), result.getLinks().getFirst());
        assertEquals(pagination.getLastPage(), result.getLinks().getLast());
        assertEquals(pagination.getNextPage(), result.getLinks().getNext());
        assertEquals(pagination.getPage(), result.getPage());
        assertEquals(pagination.getNumPages(), result.getTotalPages());
        assertEquals(pagination.getTotal(), result.getTotalElements());
        assertEquals(pagination.getPageSize(), result.getPageSize());
    }

    @Test
    public void paginationBuilderWithNextPaginationNullTest() {
        pagination.setNextPage(null);
        Pagination result = PaginationMapper.build(pagination);

        assertNotNull(result);
        assertNotNull(result.getLinks().getFirst());
        assertNotNull(result.getLinks().getLast());
        assertNotNull(result.getLinks().getPrevious());
        assertNull(result.getLinks().getNext());
        assertNotNull(result.getPage());
        assertNotNull(result.getTotalPages());
        assertNotNull(result.getTotalElements());
        assertNotNull(result.getPageSize());

        assertEquals(pagination.getFirstPage(), result.getLinks().getFirst());
        assertEquals(pagination.getLastPage(), result.getLinks().getLast());
        assertEquals(pagination.getPreviousPage(), result.getLinks().getPrevious());
        assertEquals(pagination.getPage(), result.getPage());
        assertEquals(pagination.getNumPages(), result.getTotalPages());
        assertEquals(pagination.getTotal(), result.getTotalElements());
        assertEquals(pagination.getPageSize(), result.getPageSize());
    }
}
