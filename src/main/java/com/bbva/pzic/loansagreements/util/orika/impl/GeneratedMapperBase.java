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

package com.bbva.pzic.loansagreements.util.orika.impl;

import com.bbva.pzic.loansagreements.util.orika.BoundMapperFacade;
import com.bbva.pzic.loansagreements.util.orika.Converter;
import com.bbva.pzic.loansagreements.util.orika.CustomMapper;
import com.bbva.pzic.loansagreements.util.orika.Mapper;
import com.bbva.pzic.loansagreements.util.orika.MappingContext;
import com.bbva.pzic.loansagreements.util.orika.impl.mapping.strategy.MappingStrategy;
import com.bbva.pzic.loansagreements.util.orika.metadata.Type;

import java.util.ArrayList;
import java.util.List;

public abstract class GeneratedMapperBase extends CustomMapper<Object, Object> {
    
    protected Mapper<Object, Object> customMapper;
    protected Type<?>[] usedTypes;
    protected Converter<Object, Object>[] usedConverters;
    protected BoundMapperFacade<Object, Object>[] usedMapperFacades;
    private Mapper<Object, Object>[] usedMappers;
    private Type<Object> aType;
    private Type<Object> bType;
    private boolean fromAutoMapping;
    
    public Type<Object> getAType() {
        return aType;
    }
    
    public Type<Object> getBType() {
        return bType;
    }
    
    @SuppressWarnings("unchecked")
    public void setAType(Type<?> aType) {
        this.aType = (Type<Object>) aType;
    }
    
    @SuppressWarnings("unchecked")
    public void setBType(Type<?> bType) {
        this.bType = (Type<Object>) bType;
    }
    
    public boolean isFromAutoMapping() {
        return fromAutoMapping;
    }
    
    public void setFromAutoMapping(boolean fromAutoMapping) {
        this.fromAutoMapping = fromAutoMapping;
    }
    
    public void setCustomMapper(Mapper<Object, Object> customMapper) {
        this.customMapper = customMapper;
        this.customMapper.setMapperFacade(mapperFacade);
    }
    
    protected Mapper<Object, Object>[] getUsedMappers() {
        return usedMappers;
    }
    
    @Override
    public void setUsedMappers(Mapper<Object, Object>[] usedMappers) {
        this.usedMappers = usedMappers;
    }
    
    public void setUsedTypes(Type<Object>[] types) {
        this.usedTypes = types;
    }
    
    public void setUsedConverters(Converter<Object, Object>[] usedConverters) {
        this.usedConverters = usedConverters;
    }
    
    public void setUsedMapperFacades(BoundMapperFacade<Object, Object>[] usedMapperFacades) {
        this.usedMapperFacades = usedMapperFacades;
    }
    
    @Override
    public void mapAtoB(Object a, Object b, MappingContext context) {
        if (usedMappers == null) {
            return;
        }
        for (Mapper<Object, Object> mapper : usedMappers) {
            mapper.mapAtoB(a, b, context);
        }
    }
    
    @Override
    public void mapBtoA(Object b, Object a, MappingContext context) {
        if (usedMappers == null) {
            return;
        }
        for (Mapper<Object, Object> mapper : usedMappers) {
            mapper.mapBtoA(b, a, context);
        }
    }
    
    protected int min(int... sizes) {
        
        int min = Integer.MAX_VALUE;
        for (int size : sizes) {
            if (size < min) {
                min = size;
            }
        }
        return min;
    }
    
    protected static <T> List<T> asList(Iterable<T> iterable) {
        ArrayList<T> ts = new ArrayList<T>();
        for (T i : iterable) {
            ts.add(i);
        }
        return ts;
    }
    
    protected static List<Object> asList(Object[] iterable) {
        ArrayList<Object> ts = new ArrayList<Object>();
        for (Object i : iterable) {
            ts.add(i);
        }
        return ts;
    }
    
    protected static List<Object> asList(byte[] iterable) {
        ArrayList<Object> ts = new ArrayList<Object>();
        for (Object i : iterable) {
            ts.add(i);
        }
        return ts;
    }
    
    protected static List<Object> asList(int[] iterable) {
        ArrayList<Object> ts = new ArrayList<Object>();
        for (Object i : iterable) {
            ts.add(i);
        }
        return ts;
    }
    
    protected static List<Object> asList(char[] iterable) {
        ArrayList<Object> ts = new ArrayList<Object>();
        for (Object i : iterable) {
            ts.add(i);
        }
        return ts;
    }
    
    protected static List<Object> asList(long[] iterable) {
        ArrayList<Object> ts = new ArrayList<Object>();
        for (Object i : iterable) {
            ts.add(i);
        }
        return ts;
    }
    
    protected static List<Object> asList(float[] iterable) {
        ArrayList<Object> ts = new ArrayList<Object>();
        for (Object i : iterable) {
            ts.add(i);
        }
        return ts;
    }
    
    protected static List<Object> asList(double[] iterable) {
        ArrayList<Object> ts = new ArrayList<Object>();
        for (Object i : iterable) {
            ts.add(i);
        }
        return ts;
    }
    
    protected static List<Object> asList(boolean[] iterable) {
        ArrayList<Object> ts = new ArrayList<Object>();
        for (Object i : iterable) {
            ts.add(i);
        }
        return ts;
    }
    
    protected static List<Object> asList(short[] iterable) {
        ArrayList<Object> ts = new ArrayList<Object>();
        for (Object i : iterable) {
            ts.add(i);
        }
        return ts;
    }
    
    protected void mapArray(byte[] destination, List<Object> source, Class<?> clazz, MappingContext mappingContext) {
        if (source == null) {
            return;
        }
        
        MappingStrategy strategy = null;
        Class<?> entryClass = null;
        int i = 0;
        for (final Object s : source) {
            if (strategy == null || !s.getClass().equals(entryClass)) {
                strategy = mapperFacade.resolveMappingStrategy(s, null, clazz, false, mappingContext);
                entryClass = s.getClass();
            }
            destination[i++] = (Byte) strategy.map(s, null, mappingContext);
        }
    }
    
    protected void mapArray(boolean[] destination, List<Object> source, Class<?> clazz, MappingContext mappingContext) {
        if (source == null) {
            return;
        }
        
        MappingStrategy strategy = null;
        Class<?> entryClass = null;
        int i = 0;
        for (final Object s : source) {
            if (strategy == null || !s.getClass().equals(entryClass)) {
                strategy = mapperFacade.resolveMappingStrategy(s, null, clazz, false, mappingContext);
                entryClass = s.getClass();
            }
            destination[i++] = (Boolean) strategy.map(s, null, mappingContext);
        }
        
    }
    
    protected void mapArray(char[] destination, List<Object> source, Class<?> clazz, MappingContext mappingContext) {
        if (source == null) {
            return;
        }
        
        MappingStrategy strategy = null;
        Class<?> entryClass = null;
        int i = 0;
        for (final Object s : source) {
            if (strategy == null || !s.getClass().equals(entryClass)) {
                strategy = mapperFacade.resolveMappingStrategy(s, null, clazz, false, mappingContext);
                entryClass = s.getClass();
            }
            destination[i++] = (Character) strategy.map(s, null, mappingContext);
        }
        
    }
    
    protected void mapArray(short[] destination, List<Object> source, Class<?> clazz, MappingContext mappingContext) {
        if (source == null) {
            return;
        }
        
        MappingStrategy strategy = null;
        Class<?> entryClass = null;
        int i = 0;
        for (final Object s : source) {
            if (strategy == null || !s.getClass().equals(entryClass)) {
                strategy = mapperFacade.resolveMappingStrategy(s, null, clazz, false, mappingContext);
                entryClass = s.getClass();
            }
            destination[i++] = (Short) strategy.map(s, null, mappingContext);
        }
        
    }
    
    protected void mapArray(int[] destination, List<Object> source, Class<?> clazz, MappingContext mappingContext) {
        if (source == null) {
            return;
        }
        
        MappingStrategy strategy = null;
        Class<?> entryClass = null;
        int i = 0;
        for (final Object s : source) {
            if (strategy == null || !s.getClass().equals(entryClass)) {
                strategy = mapperFacade.resolveMappingStrategy(s, null, clazz, false, mappingContext);
                entryClass = s.getClass();
            }
            destination[i++] = (Integer) strategy.map(s, null, mappingContext);
        }
        
    }
    
    protected void mapArray(long[] destination, List<Object> source, Class<?> clazz, MappingContext mappingContext) {
        if (source == null) {
            return;
        }
        
        MappingStrategy strategy = null;
        Class<?> entryClass = null;
        int i = 0;
        for (final Object s : source) {
            if (strategy == null || !s.getClass().equals(entryClass)) {
                strategy = mapperFacade.resolveMappingStrategy(s, null, clazz, false, mappingContext);
                entryClass = s.getClass();
            }
            destination[i++] = (Long) strategy.map(s, null, mappingContext);
        }
        
    }
    
    protected void mapArray(float[] destination, List<Object> source, Class<?> clazz, MappingContext mappingContext) {
        if (source == null) {
            return;
        }
        
        MappingStrategy strategy = null;
        Class<?> entryClass = null;
        int i = 0;
        for (final Object s : source) {
            if (strategy == null || !s.getClass().equals(entryClass)) {
                strategy = mapperFacade.resolveMappingStrategy(s, null, clazz, false, mappingContext);
                entryClass = s.getClass();
            }
            destination[i++] = (Float) strategy.map(s, null, mappingContext);
        }
        
    }
    
    protected void mapArray(double[] destination, List<Object> source, Class<?> clazz, MappingContext mappingContext) {
        if (source == null) {
            return;
        }
        
        MappingStrategy strategy = null;
        Class<?> entryClass = null;
        int i = 0;
        for (final Object s : source) {
            if (strategy == null || !s.getClass().equals(entryClass)) {
                strategy = mapperFacade.resolveMappingStrategy(s, null, clazz, false, mappingContext);
                entryClass = s.getClass();
            }
            destination[i++] = (Double) strategy.map(s, null, mappingContext);
        }
        
    }

    protected Object getSafe(int index, List<Object> list) {
        assurePosition(index, list);

        return list.size() > index ?  list.get(index) : null;
    }

    private void assurePosition(int index, List<Object> list){
        int initialSize = list.size();
        for(int i = initialSize; i < index; i++){
            list.add(i, null);
        }
    }

}