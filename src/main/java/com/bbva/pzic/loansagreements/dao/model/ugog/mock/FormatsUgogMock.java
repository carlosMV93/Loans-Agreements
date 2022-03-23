package com.bbva.pzic.loansagreements.dao.model.ugog.mock;

import com.bbva.pzic.loansagreements.dao.model.ugog.FormatoUGMOGS1;
import com.bbva.pzic.loansagreements.util.mappers.ObjectMapperHelper;

import java.io.IOException;

/**
 * Created on 14/12/2018.
 *
 * @author Entelgy
 */
public final class FormatsUgogMock {

    private static final FormatsUgogMock INSTANCE = new FormatsUgogMock();
    private ObjectMapperHelper objectMapper = ObjectMapperHelper.getInstance();

    private FormatsUgogMock() {
    }

    public static FormatsUgogMock getInstance() {
        return INSTANCE;
    }

    public FormatoUGMOGS1 getFormatoUGMOGS1() throws IOException {
        return objectMapper
                .readValue(
                        Thread.currentThread()
                                .getContextClassLoader()
                                .getResourceAsStream(
                                        "com/bbva/pzic/loansagreements/dao/model/ugog/mock/formatoUGMOGS1.json"),
                        FormatoUGMOGS1.class);
    }
}