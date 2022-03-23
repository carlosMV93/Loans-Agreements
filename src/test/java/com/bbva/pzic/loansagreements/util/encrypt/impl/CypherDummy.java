package com.bbva.pzic.loansagreements.util.encrypt.impl;

import com.bbva.pzic.loansagreements.EntityMock;
import com.bbva.pzic.loansagreements.util.encrypt.AbstractCypherTool;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created on 24/05/2017.
 *
 * @author Entelgy
 */
@Primary
@Component
public class CypherDummy extends AbstractCypherTool {

    @Override
    protected boolean setUp(final String fieldName, final String registryId) {
        this.propertyAppId = "servicing.cypher.mock.app.id";
        this.propertyPassword = "servicing.cypher.mock.password";
        this.propertyContextType = "servicing.cypher.mock.context.type";
        this.propertyContextType = "servicing.cypher.mock.context.type.".concat(EntityMock.CYPHER_KEY);
        this.propertyContextEndpoint = "servicing.cypher.mock.context.endpoint";
        this.propertyContextSecurityLevel = "servicing.cypher.mock.context.security.level";
        return false;
    }

    @Override
    public String mask(String stringToEncrypt, String fieldName, String registryId) {
        setUp(fieldName, registryId);
        return stringToEncrypt;
    }

    @Override
    public String encrypt(String stringToEncrypt, String fieldName, String registryId) {
        setUp(fieldName, registryId);
        return stringToEncrypt;
    }

    @Override
    public String decrypt(String encryptedString, String fieldName, String registryId) {
        setUp(fieldName, registryId);
        return encryptedString;
    }

}
