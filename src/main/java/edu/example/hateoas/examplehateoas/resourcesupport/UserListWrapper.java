package edu.example.hateoas.examplehateoas.resourcesupport;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserListWrapper extends ResourceSupport implements Page<UserWrapper>{

    private final Page<UserWrapper> page;

    private static final String PAGE_PARAM = "page";
    private static final String SIZE = "size";

    public UserListWrapper( Page<UserWrapper> page ) {
        super();
        this.page = page;
        if (page.hasPrevious()) {
            String path = createBuilder().queryParam(PAGE_PARAM, page.getNumber() - 1)
                    .queryParam(SIZE, page.getSize()).build().toUriString();
            Link link = new Link(path, Link.REL_PREVIOUS);
            add(link);
        }
        if (page.hasNext()) {
            String path = createBuilder()
                    .queryParam("page", page.getNumber() + 1)
                    .queryParam("size", page.getSize())
                    .build().toUriString();
            Link link = new Link(path, Link.REL_NEXT);
            add(link);
        }

        Link link = buildPageLink(PAGE_PARAM, 0, SIZE, page.getSize(), Link.REL_FIRST);
        add(link);

        int indexOfLastPage = page.getTotalPages() - 1;
        link = buildPageLink(PAGE_PARAM, indexOfLastPage, SIZE, page.getSize(), Link.REL_LAST);
        add(link);

        link = buildPageLink(PAGE_PARAM, page.getNumber(), SIZE, page.getSize(), Link.REL_SELF);
        add(link);
    }

    private ServletUriComponentsBuilder createBuilder() {
        return ServletUriComponentsBuilder.fromCurrentRequestUri();
    }

    private Link buildPageLink(String pageparam, int page, String pagesize, int size, String rel) {
        String path = createBuilder().queryParam(pageparam, page).queryParam(pagesize, size).build().toUriString();
        return new Link(path, rel);
    }

    @Override
    public int getNumber() {
        return page.getNumber();
    }

    @Override
    public int getSize() {
        return page.getSize();
    }

    @Override
    public int getTotalPages() {
        return page.getTotalPages();
    }

    @Override
    public int getNumberOfElements() {
        return page.getNumberOfElements();
    }

    @Override
    public long getTotalElements() {
        return page.getTotalElements();
    }

    @Override
    public <U> Page<U> map(Function<? super UserWrapper, ? extends U> function) {
        return null;
    }

    @Override
    public Iterator<UserWrapper> iterator() {
        return page.iterator();
    }

    @Override
    public List<UserWrapper> getContent() {
        return page.getContent();
    }

    @Override
    public boolean hasContent() {
        return page.hasContent();
    }

    @Override
    @JsonIgnore
    public Sort getSort() {
        return page.getSort();
    }

    @Override
    public boolean isFirst() {
        return false;
    }

    @Override
    public boolean isLast() {
        return false;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public boolean hasPrevious() {
        return true;
    }

    @Override
    public Pageable nextPageable() {
        return null;
    }

    @Override
    public Pageable previousPageable() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return this.equals(obj);
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }

    @Override
    public List<Link> getLinks() {
        return super.getLinks();
    }

}
