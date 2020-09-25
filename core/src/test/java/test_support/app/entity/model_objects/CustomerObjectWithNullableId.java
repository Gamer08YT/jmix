/*
 * Copyright 2020 Haulmont.
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

package test_support.app.entity.model_objects;

import io.jmix.core.EntityEntry;
import io.jmix.core.Entity;
import io.jmix.core.entity.NullableIdEntityEntry;
import io.jmix.core.entity.annotation.JmixId;
import io.jmix.core.impl.EntityInternals;
import io.jmix.core.metamodel.annotation.ModelObject;

import javax.annotation.Nullable;

@ModelObject
public class CustomerObjectWithNullableId implements Entity {

    @JmixId
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // TODO Replace with enhancing - begin

    private static class JmixEntityEntry extends NullableIdEntityEntry {
        public JmixEntityEntry(Entity source) {
            super(source);
        }

        @Nullable
        @Override
        public Object getEntityId() {
            return ((CustomerObjectWithNullableId) getSource()).getId();
        }

        @Override
        public void setEntityId(@Nullable Object id) {
            ((CustomerObjectWithNullableId) getSource()).setId((String) id);
        }
    }

    private EntityEntry _jmixEntityEntry = new JmixEntityEntry(this);

    @Override
    public EntityEntry __getEntityEntry() {
        return _jmixEntityEntry;
    }

    @Override
    public void __copyEntityEntry() {
        JmixEntityEntry newEntry = new JmixEntityEntry(this);
        newEntry.copy(_jmixEntityEntry);
        _jmixEntityEntry = newEntry;
    }

    public boolean equals(Object var1) {
        return EntityInternals.equals(this, var1);
    }

    public int hashCode() {
        return EntityInternals.hashCode(this);
    }

    public String toString() {
        return EntityInternals.toString(this);
    }

    // TODO Replace with enhancing - end
}
