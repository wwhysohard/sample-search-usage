package io.github.wwhysohard.samplesearchusage.specification;

import io.github.wwhysohard.samplesearchusage.model.Author;
import io.github.wwhysohard.samplesearchusage.model.Book;
import io.github.wwhysohard.search.dto.FilterRequest;
import io.github.wwhysohard.search.dto.SearchRequest;
import io.github.wwhysohard.search.dto.SortRequest;
import io.github.wwhysohard.search.enums.QueryOperator;
import io.github.wwhysohard.search.utils.GenericCriteriaOrder;
import io.github.wwhysohard.search.utils.GenericCriteriaPredicate;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GenericSpecification<T> implements Specification<T> {

    private final SearchRequest request;
    private final Class<T> genericType;

    protected final Map<String, Join<?, ?>> joins;
    protected final List<Predicate> predicates;

    protected GenericSpecification(SearchRequest request, Class<T> genericType) {
        this.request = request;
        this.genericType = genericType;

        this.joins = new HashMap<>();
        this.predicates = new ArrayList<>();
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        initializeJoins(root);
        filter(root, criteriaBuilder);
        sort(root, query, criteriaBuilder);

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    protected void initializeJoins(Root<T> root) {
        // Initialize joins if needed
    }

    private void filter(Root<T> root, CriteriaBuilder criteriaBuilder) {
        List<FilterRequest> filters = request.getFilters();

        if (filters != null && !filters.isEmpty()) {
            Predicate predicate = GenericCriteriaPredicate.get(root, criteriaBuilder, joins, filters, QueryOperator.AND, genericType);
            predicates.add(predicate);
        }
    }

    private void sort(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<SortRequest> sorts = request.getSorts();

        if (sorts != null && !sorts.isEmpty()) {
            List<Order> orders = GenericCriteriaOrder.get(root, criteriaBuilder, joins, sorts, genericType);
            query.orderBy(orders);
        }
    }

}
