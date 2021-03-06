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

import com.bbva.pzic.loansagreements.util.orika.Converter;
import com.bbva.pzic.loansagreements.util.orika.MappingContext;
import com.bbva.pzic.loansagreements.util.orika.metadata.Type;
import com.bbva.pzic.loansagreements.util.orika.unenhance.UnenhanceStrategy;

public class UseConverterStrategy implements MappingStrategy {
    
    private final Converter<Object,Object> converter;
    private final Type<Object> sourceType;
    private final Type<?> destinationType;
    private final UnenhanceStrategy unenhancer;
    
    @SuppressWarnings("unchecked")
    public UseConverterStrategy(Type<?> sourceType, Type<?> destinationType, Converter<Object,Object> converter, UnenhanceStrategy unenhancer) {
        this.sourceType = (Type<Object>) sourceType;
        this.destinationType = destinationType;
        this.converter = converter;
        this.unenhancer = unenhancer;
    }

    public Object map(Object sourceObject, Object destinationObject, MappingContext context) {
        // TODO: mappingContext is not passed to converters, which could 
        //       be a problem with converters now (recently) having access
        //       to the MapperFacade; 
        return converter.convert(unenhancer.unenhanceObject(sourceObject, sourceType), destinationType);
    }
}
