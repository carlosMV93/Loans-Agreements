package com.bbva.pzic.loansagreements.util.orika.converter.builtin;


import com.bbva.pzic.loansagreements.util.orika.converter.BidirectionalConverter;
import com.bbva.pzic.loansagreements.util.orika.metadata.Type;

/**
 * Created on 31/07/2015.
 *
 * @author Entelgy
 */
public class BooleanToStringConverter extends BidirectionalConverter<Boolean, String> {

    private static final String TRUE = "S";
    private static final String FALSE = "N";

    @Override
    public String convertTo(Boolean source, Type<String> destinationType) {
        return source != null ? (source ? TRUE : FALSE) : null;
    }

    @Override
    public Boolean convertFrom(String source, Type<Boolean> destinationType) {
        return source == null ? null : (TRUE.equalsIgnoreCase(source) ? Boolean.TRUE : Boolean.FALSE);
    }
}
