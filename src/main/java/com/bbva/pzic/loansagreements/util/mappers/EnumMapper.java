package com.bbva.pzic.loansagreements.util.mappers;

import com.bbva.jee.arq.spring.core.servicing.configuration.ConfigurationManager;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.loansagreements.util.Errors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Entelgy
 */
@Component
public class EnumMapper {

    private static final Log LOG = LogFactory.getLog(EnumMapper.class);

    private static final String PROPERTY_INPUT_ENUMS = "servicing.enum.input.";
    private static final String PROPERTY_OUTPUT_ENUMS = "servicing.enum.output.";

    @Autowired
    private ConfigurationManager configurationManager;

    public String getBackendValue(final String field, final String enumValue) {
        return getProperty(PROPERTY_INPUT_ENUMS.concat(field), enumValue);
    }

    public String getEnumValue(final String field, final String backendValue) {
        return getProperty(PROPERTY_OUTPUT_ENUMS.concat(field), backendValue);
    }

    private String getProperty(final String base, final String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        String key = base.concat(".").concat(value);
        String propertyValue = configurationManager.getProperty(key);
        if (propertyValue == null) {
            LOG.error(String.format("Property key '%s' is not defined", key));

            if (key.startsWith(PROPERTY_INPUT_ENUMS)) {
                throw new BusinessServiceException(Errors.WRONG_PARAMETERS);
            } else {
                throw new BusinessServiceException(Errors.TECHNICAL_ERROR);
            }
        }
        LOG.debug(String.format("Loaded property '%s = %s'", key, propertyValue));
        return propertyValue;
    }
}
