package com.bbva.pzic.loansagreements.util.orika.converter.builtin;

import com.bbva.pzic.loansagreements.util.orika.converter.BidirectionalConverter;
import com.bbva.pzic.loansagreements.util.orika.metadata.Type;

/**
 * Created on 14/12/2015.
 *
 * @author Entelgy
 */
public class LongToIntegerConverter extends BidirectionalConverter<Long, Integer> {

    @Override
    public Integer convertTo(Long source, Type<Integer> destinationType) {
        return Integer.parseInt(source.toString());
    }

    @Override
    public Long convertFrom(Integer source, Type<Long> destinationType) {
        return source.longValue();
    }
}