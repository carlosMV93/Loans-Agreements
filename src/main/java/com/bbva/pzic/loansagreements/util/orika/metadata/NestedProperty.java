/*
 * Orika - simpler, better and faster Java bean mapping
 * 
 * Copyright (C) 2011 Orika authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bbva.pzic.loansagreements.util.orika.metadata;

import com.bbva.pzic.loansagreements.util.orika.property.PropertyResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NestedProperty extends Property {

    private final Property[] path;
    private final Property tail;
    private Property owningProperty;

    public NestedProperty(String expression, Property property, Property[] path, Property owningProperty) {
        this(expression, property, path);
        this.owningProperty = owningProperty;
    }

    public NestedProperty(String expression, Property property, Property[] path) {
        super(expression, property.getName(), property.getGetter(), property.getSetter(), property.getType(), property.getElementType());
        this.path = collapse(property.getPath(), path);
        this.tail = property;
    }

    //Obtiene la propiedad de un item y listado (v1.4.5)
    private Property[] collapse(Property[] primaryPath, Property[] path) {
        List<Property> collapsed = new ArrayList<>();
        collapsed.addAll(Arrays.asList(path));
        collapsed.addAll(Arrays.asList(primaryPath));
        int i = 0;
        while (i < collapsed.size()) {
            Property p = collapsed.get(i);
            if (p instanceof NestedProperty) {
                collapsed.remove(i);
                for (Property element : p.getPath()) {
                    collapsed.add(i++, element);
                }
                Property tail = ((NestedProperty) p).tail;
                collapsed.add(i, tail);
            }
            ++i;
        }
        return collapsed.toArray(path);
    }

    @Override
    public NestedProperty copy() {

        Property[] copyPath = new Property[path.length];
        for (int i = 0, count = path.length; i < count; ++i) {
            copyPath[i] = path[i].copy();
        }
        NestedProperty copy = new NestedProperty(this.getExpression(), super.copy(), copyPath);
        return copy;
    }

    @Override
    public Property[] getPath() {
        return path;
    }

    @Override
    public boolean hasPath() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }

        final NestedProperty nestedProperty = (NestedProperty) o;
        return Objects.equals(owningProperty, nestedProperty.owningProperty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), owningProperty);
    }

    public boolean isListElement() {
        return tail.isListElement();
    }

    public boolean isArrayElement() {
        return tail.isArrayElement();
    }

    public boolean isMapKey() {
        return tail.isMapKey();
    }

    static class Builder extends Property.Builder {

        private Property.Builder parent;

        /**
         * @param parent
         * @param name
         */
        Builder(Property.Builder parent, String name) {
            super(null, name);
            this.parent = parent;
        }

        public Property build(PropertyResolver propertyResolver) {
            Property parentProperty = parent.build(propertyResolver);

            Property[] path;
            if (parentProperty instanceof NestedProperty) {
                path = ((NestedProperty) parentProperty).getPath();
                System.arraycopy(path, 0, path, 0, path.length + 1);
                path[path.length - 1] = parentProperty;
            } else {
                path = new Property[]{parentProperty};
            }
            this.owningType = parentProperty.getType();

            Property p = super.build(propertyResolver);
            return new NestedProperty("", p, path);
        }

    }

    @Override
    public Property getOwningProperty() {
        return owningProperty;
    }
}
