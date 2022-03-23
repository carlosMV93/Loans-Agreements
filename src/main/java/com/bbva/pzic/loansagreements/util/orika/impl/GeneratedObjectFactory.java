package com.bbva.pzic.loansagreements.util.orika.impl;

import com.bbva.pzic.loansagreements.util.orika.BoundMapperFacade;
import com.bbva.pzic.loansagreements.util.orika.Converter;
import com.bbva.pzic.loansagreements.util.orika.MapperFacade;
import com.bbva.pzic.loansagreements.util.orika.ObjectFactory;
import com.bbva.pzic.loansagreements.util.orika.metadata.Type;

public abstract class GeneratedObjectFactory implements ObjectFactory<Object> {
    protected MapperFacade mapperFacade;
    protected Type<Object>[] usedTypes;
    protected Converter<Object,Object>[] usedConverters;
    protected BoundMapperFacade<Object, Object>[] usedMapperFacades;
    
    public void setMapperFacade(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }
    
    public void setUsedTypes(Type<Object>[] usedTypes) {
        this.usedTypes = usedTypes;
    }
    
    public void setUsedConverters(Converter<Object,Object>[] usedConverters) {
    	this.usedConverters = usedConverters;
    }
    
    public void setUsedMapperFacades(BoundMapperFacade<Object, Object>[] usedMapperFacades) {
        this.usedMapperFacades = usedMapperFacades;
    }
}
