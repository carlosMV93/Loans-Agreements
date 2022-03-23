package com.bbva.pzic.loansagreements.dao.model.ugof.mock;

import com.bbva.pzic.loansagreements.dao.model.ugof.FormatoUGMOFS1;
import com.bbva.pzic.loansagreements.util.mappers.ObjectMapperHelper;

import java.io.IOException;

/**
 * Created on 14/12/2018.
 *
 * @author Entelgy
 */
public final class FormatsUgofMock {

    private static final FormatsUgofMock INSTANCE = new FormatsUgofMock();
    private ObjectMapperHelper objectMapper = ObjectMapperHelper.getInstance();

    private FormatsUgofMock() {
    }

    public static FormatsUgofMock getInstance() {
        return INSTANCE;
    }

    public FormatoUGMOFS1 getFormatoUGMOFS1() throws IOException {
        return objectMapper
                .readValue(
                        Thread.currentThread()
                                .getContextClassLoader()
                                .getResourceAsStream(
                                        "com/bbva/pzic/loansagreements/dao/model/ugof/mock/formatoUGMOFS1.json"),
                        FormatoUGMOFS1.class);
    }

    public FormatoUGMOFS1 getFormatoUGMOFS1Empty() throws IOException {
        return objectMapper
                .readValue(
                        Thread.currentThread()
                                .getContextClassLoader()
                                .getResourceAsStream(
                                        "com/bbva/pzic/loansagreements/dao/model/ugof/mock/formatoUGMOFS1-EMPTY.json"),
                        FormatoUGMOFS1.class);
    }

}