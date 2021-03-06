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
package com.bbva.pzic.loansagreements.util.orika.converter;

import com.bbva.pzic.loansagreements.util.orika.MappedTypePair;
import com.bbva.pzic.loansagreements.util.orika.MapperFacade;
import com.bbva.pzic.loansagreements.util.orika.metadata.Type;

@Deprecated
public interface Converter<S, D> extends MappedTypePair<S, D> {
    
    boolean canConvert(Class<S> sourceClass, Class<? extends D> destinationClass);
    
    D convert(S source, Class<? extends D> destinationClass);
    
    /**
     * LegacyConverter provides back-compatible support for the older version
     * of converter.
     * 
     * @author matt.deboer@gmail.com
     *
     * @param <S>
     * @param <D>
     */
    public static class LegacyConverter<S, D> implements com.bbva.pzic.loansagreements.util.orika.Converter<S, D> {
        
        private com.bbva.pzic.loansagreements.util.orika.converter.Converter<S, D> delegate;
        
        public LegacyConverter(com.bbva.pzic.loansagreements.util.orika.converter.Converter<S, D> delegate) {
            this.delegate = delegate;
        }
        
        @SuppressWarnings("unchecked")
        public boolean canConvert(Type<?> sourceClass, Type<?> destinationType) {
            
            return delegate.canConvert((Class<S>) sourceClass.getRawType(), (Class<D>) destinationType.getRawType());
        }
        
        public D convert(S source, Type<? extends D> destinationType) {
            
            return delegate.convert(source, destinationType.getRawType());
        }

		public void setMapperFacade(MapperFacade mapper) {
			if (delegate instanceof CustomConverterBase) {
				((CustomConverterBase<?,?>)delegate).setMapperFacade(mapper);
			}
		}
		
		public String toString() {
	    	return LegacyConverter.class.getSimpleName() + "(" + delegate.toString() + ")";
	    }

        /* (non-Javadoc)
         * @see ma.glasnost.orika.MappedTypePair#getAType()
         */
        public Type<S> getAType() {
            return delegate.getAType();
        }

        /* (non-Javadoc)
         * @see ma.glasnost.orika.MappedTypePair#getBType()
         */
        public Type<D> getBType() {
            return delegate.getBType();
        }
        
    }
}
