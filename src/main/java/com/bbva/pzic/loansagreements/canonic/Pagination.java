package com.bbva.pzic.loansagreements.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "pagination", namespace = "urn:com:bbva:pzic:loansagreements:canonic")
@XmlType(name = "pagination", namespace = "urn:com:bbva:pzic:loansagreements:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pagination implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Pagination links. These links provide relative URIs to reach different
     * useful pages, such as first, last, next or previous pages.
     */
    private Links links;
    /**
     * Current page number. This attribue value is 0 when referring to the first
     * page.
     */
    private Long page;
    /**
     * Total number of pages for the provided pagination and filtering
     * parameters.
     */
    private Long totalPages;
    /**
     * Total number of items to the requested list, taking into account possible
     * filtering criteria if specified.
     */
    private Long totalElements;
    /**
     * Number of items per page. This attribute value matches pageSize query
     * parameter if provided. Otherwise, this attribute may provide the default
     * page size.
     */
    private Long pageSize;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
}