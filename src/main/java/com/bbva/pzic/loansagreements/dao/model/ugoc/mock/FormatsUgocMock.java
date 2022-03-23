package com.bbva.pzic.loansagreements.dao.model.ugoc.mock;

import com.bbva.pzic.loansagreements.dao.model.ugoc.FormatoUGFSGOC;
import com.bbva.pzic.loansagreements.util.mappers.ObjectMapperHelper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.List;

/**
 * Created on 14/12/2018.
 *
 * @author Entelgy
 */
public final class FormatsUgocMock {

    private static final FormatsUgocMock INSTANCE = new FormatsUgocMock();
    private ObjectMapperHelper objectMapper = ObjectMapperHelper.getInstance();

    private FormatsUgocMock() {
    }

    public static FormatsUgocMock getInstance() {
        return INSTANCE;
    }

    public List<FormatoUGFSGOC> getFormatoUGFSGOC() throws IOException {
        return objectMapper
                .readValue(
                        Thread.currentThread()
                                .getContextClassLoader()
                                .getResourceAsStream(
                                        "com/bbva/pzic/loansagreements/dao/model/ugoc/mock/formatosUGFSGOC.json"),
                        new TypeReference<List<FormatoUGFSGOC>>() {
                        });
    }

}