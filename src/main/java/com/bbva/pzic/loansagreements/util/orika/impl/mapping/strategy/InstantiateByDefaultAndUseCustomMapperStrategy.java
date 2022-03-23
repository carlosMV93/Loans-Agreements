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

package com.bbva.pzic.loansagreements.util.orika.impl.mapping.strategy;

import com.bbva.pzic.loansagreements.util.orika.MappingContext;
import com.bbva.pzic.loansagreements.util.orika.metadata.Type;
import com.bbva.pzic.loansagreements.util.orika.unenhance.UnenhanceStrategy;

public class InstantiateByDefaultAndUseCustomMapperStrategy extends UseCustomMapperStrategy {
    
    public InstantiateByDefaultAndUseCustomMapperStrategy(Type<Object> sourceType, Type<Object> destinationType, DirectionalCustomMapperReference customMapper, UnenhanceStrategy unenhancer) {
    	super(sourceType, destinationType, customMapper, unenhancer);
    }

    protected Object getInstance(Object sourceObject, Object destinationObject, MappingContext context) {
    	try {
            return destinationType.getRawType().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String toString() {
        StringBuilder description = new StringBuilder();
        description.append(getClass().getSimpleName() + "(");
        description.append(this.customMapper);
        description.append(")");
        return description.toString();
    }
}
