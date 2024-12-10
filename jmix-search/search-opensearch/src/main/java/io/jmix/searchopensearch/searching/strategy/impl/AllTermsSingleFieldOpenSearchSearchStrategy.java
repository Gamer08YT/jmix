/*
 * Copyright 2024 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.jmix.searchopensearch.searching.strategy.impl;

import io.jmix.search.searching.SearchContext;
import io.jmix.search.searching.SearchStrategy;
import io.jmix.search.searching.SearchUtils;
import io.jmix.search.searching.impl.AbstractSearchStrategy;
import io.jmix.searchopensearch.searching.strategy.OpenSearchSearchStrategy;
import org.opensearch.client.opensearch._types.query_dsl.Operator;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Set;

/**
 * Describes {@link SearchStrategy} that searches documents with at least one field matches all input terms in any order.
 * Fields with partial match a not suitable.
 */
@Deprecated(since = "2.4", forRemoval = true)
@Component("search_AllTermsSingleFieldOpenSearchSearchStrategy")
public class AllTermsSingleFieldOpenSearchSearchStrategy extends AbstractSearchStrategy
        implements OpenSearchSearchStrategy {

    protected final SearchUtils searchUtils;

    public AllTermsSingleFieldOpenSearchSearchStrategy(SearchUtils searchUtils) {
        this.searchUtils = searchUtils;
    }

    @Override
    public String getName() {
        return "allTermsSingleField";
    }

    @Override
    public void configureRequest(SearchRequest.Builder requestBuilder, SearchContext searchContext) {
        Set<String> effectiveFieldsToSearch = searchUtils.resolveEffectiveSearchFields(searchContext.getEntities());
        requestBuilder.query(queryBuilder ->
                queryBuilder.multiMatch(multiMatchQueryBuilder ->
                        multiMatchQueryBuilder.fields(new ArrayList<>(effectiveFieldsToSearch))
                                .query(searchContext.getEscapedSearchText())
                                .operator(Operator.And)
                )
        );
    }
}
