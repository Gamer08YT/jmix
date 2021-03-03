/*
 * Copyright 2021 Haulmont.
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

package io.jmix.hibernate.impl.metadata;

import io.jmix.core.Metadata;
import io.jmix.core.MetadataTools;
import io.jmix.core.metamodel.model.MetaClass;
import io.jmix.core.metamodel.model.MetaProperty;
import io.jmix.core.metamodel.model.Range;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.internal.FilterConfiguration;
import org.hibernate.mapping.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.lang.reflect.AnnotatedElement;
import java.util.List;

import static io.jmix.hibernate.impl.SoftDeletionFilterDefinition.SOFT_DELETION_FILTER;

//@Component("hibernate_SoftDeletionMetadataEnhancer")
public class SoftDeletionMetadataEnhancer implements MetadataEnhancer {

    private static final String IS_NOT_DELETED_CONDITION = " is null";

    @Autowired
    private MetadataTools metadataTools;

    @Autowired
    private Metadata jmixMetadata;

    @Override
    public void enhance(MetadataImplementor metadata) {
        addSoftDeletionFilters(metadata);
    }

    private void addSoftDeletionFilters(MetadataImplementor metadata) {
        for (PersistentClass entityBinding : metadata.getEntityBindings()) {
            if (isSoftDeletable(entityBinding) && !hasFilter(entityBinding.getFilters(), SOFT_DELETION_FILTER)) {
                if (entityBinding instanceof RootClass) {
                    addSoftDeletionFilter((RootClass) entityBinding);
                }
            }
            applyFilterToCollections(entityBinding);
        }
    }

    private void applyFilterToCollections(PersistentClass entityBinding) {
        MetaClass metaClass = jmixMetadata.getClass(entityBinding.getMappedClass());
        for (MetaProperty metaProperty : metaClass.getProperties()) {
            Range range = metaProperty.getRange();
            if (range.isClass()) {
                MetaClass propertyClass = range.asClass();
                if (metadataTools.isSoftDeletable(propertyClass.getJavaClass())) {
                    if (entityBinding.hasProperty(metaProperty.getName())) {
                        String columnName = getSoftDeletionPropertyColumn(propertyClass.getJavaClass());
                        if (columnName != null) {
                            Property property = entityBinding.getProperty(metaProperty.getName());
                            if (property.getValue() instanceof Filterable) {
                                Filterable bag = (Filterable) property.getValue();
                                if (isManyToMany(metaProperty)) {
                                    addManyToManyFilter(columnName, bag);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void addManyToManyFilter(String columnName, Filterable bag) {
        if (bag instanceof Collection) {
            Collection collection = (Collection) bag;
            if (!hasFilter(collection.getManyToManyFilters(), SOFT_DELETION_FILTER)) {
                collection.setManyToManyWhere(columnName + IS_NOT_DELETED_CONDITION);
            }
        }
    }

    private boolean isManyToMany(MetaProperty metaProperty) {
        return Range.Cardinality.MANY_TO_MANY == metaProperty.getRange().getCardinality();
    }

    private boolean hasFilter(List filters, String name) {
        return filters.stream().anyMatch(f -> ((FilterConfiguration) f).getName().equals(name));
    }

    private void addSoftDeletionFilter(RootClass entityBinding) {
        Class<?> mappedClass = entityBinding.getMappedClass();
        String columnName = getSoftDeletionPropertyColumn(mappedClass);
        if (columnName != null) {
            entityBinding.setWhere(columnName + IS_NOT_DELETED_CONDITION);
        }
    }

    private String getSoftDeletionPropertyColumn(Class mappedClass) {
        String deleteProperty = metadataTools.findDeletedDateProperty(mappedClass);
        if (deleteProperty != null) {
            MetaClass metaClass = jmixMetadata.getClass(mappedClass);
            AnnotatedElement annotatedElement = metaClass.findProperty(deleteProperty).getAnnotatedElement();
            Column annotation = annotatedElement.getAnnotation(Column.class);
            if (annotation != null) {
                return annotation.name();
            }
        }
        return null;
    }

    private boolean isSoftDeletable(PersistentClass entityBinding) {
        return metadataTools.isSoftDeletable(entityBinding.getMappedClass());
    }
}
