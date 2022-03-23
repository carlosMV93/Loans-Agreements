package com.bbva.pzic.loansagreements.util;

import com.bbva.pzic.routine.processing.data.DataProcessingExecutor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Map;

@Primary
@Component
public class DummyDataProcessingExecutor implements DataProcessingExecutor {

    private static final Log LOG = LogFactory.getLog(DummyDataProcessingExecutor.class);

    @Override
    public <T> void perform(String smcRegistryId, T body, Map<String, Object> pathParams, Map<String, Object> queryParams) {
        LOG.info("Executing dummy processor");
        // Do nothing
    }

}
