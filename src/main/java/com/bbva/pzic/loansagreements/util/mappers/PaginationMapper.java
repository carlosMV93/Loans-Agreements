package com.bbva.pzic.loansagreements.util.mappers;

import com.bbva.pzic.loansagreements.canonic.Links;
import com.bbva.pzic.loansagreements.canonic.Pagination;

/**
 * @author Entelgy
 */
public final class PaginationMapper {

    private PaginationMapper() {
        // Prevent instantiation
    }

    public static Pagination build(com.bbva.jee.arq.spring.core.servicing.utils.Pagination source) {
        Links links = new Links();
        links.setFirst(source.getFirstPage());
        links.setLast(source.getLastPage());
        links.setPrevious(source.getPreviousPage());
        links.setNext(source.getNextPage());

        Pagination pagination = new Pagination();
        pagination.setLinks(links);

        if (source.getPage() != null) {
            pagination.setPage(source.getPage());
        }
        if (source.getNumPages() != null) {
            pagination.setTotalPages(source.getNumPages());
        }
        if (source.getTotal() != null) {
            pagination.setTotalElements(source.getTotal());
        }
        if (source.getPageSize() != null) {
            pagination.setPageSize(source.getPageSize());
        }
        return pagination;
    }
}