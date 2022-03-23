package com.bbva.pzic.loansagreements.util.encrypt.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.loansagreements.util.Errors;
import com.bbva.pzic.loansagreements.util.encrypt.AbstractCypherTool;
import com.bbva.pzic.loansagreements.util.encrypt.Action;
import com.bbva.secarq.caas2.core.configuration.model.CaasCredentials;
import com.bbva.secarq.caas2.core.exception.CaasConfigurationException;
import com.bbva.secarq.caas2.core.exception.CaasException;
import com.bbva.secarq.caas2.core.manager.CaasClientManager;
import com.bbva.secarq.caas2.core.manager.CaasClientManagerFactory;
import com.bbva.secarq.caas2.core.manager.model.CaasContext;
import com.bbva.secarq.caas2.core.manager.model.encData.Codification;
import com.bbva.secarq.caas2.core.manager.model.encData.DataClientInput;
import com.bbva.secarq.caas2.core.manager.model.encData.DataClientOutput;
import com.bbva.secarq.caas2.core.manager.model.encData.EncodeDataClient;
import com.bbva.secarq.caas2.core.util.logging.CaasLogLevel;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Created on 11/06/2018.
 *
 * @author Entelgy
 */
@Component
public class CypherTool extends AbstractCypherTool {

    private static final Log LOG = LogFactory.getLog(CypherTool.class);

    @Override
    public String encrypt(final String stringToEncrypt, final String fieldName, final String registryId) {
        return crypto(stringToEncrypt, fieldName, registryId, Action.ENCRYPT);
    }

    @Override
    public String mask(final String stringToMask, final String fieldName, final String registryId) {
        return crypto(stringToMask, fieldName, registryId, Action.MASK);
    }

    private String crypto(final String stringToEncrypt, final String fieldName, final String registryId, final Action action) {
        if (stringToEncrypt == null) {
            return null;
        }

        boolean hasRoutineDataProcessingActiveConfiguration = setUp(fieldName, registryId);
        LOG.info(String.format("Evaluating if have active configuration for data processing routine [%s]", hasRoutineDataProcessingActiveConfiguration));

        if (hasRoutineDataProcessingActiveConfiguration) {
            LOG.info("Cifrado interno no es requerido");
            return stringToEncrypt;
        }

        Boolean isActive = configurationManager.getBooleanProperty(cypherRequired, false);
        LOG.info(String.format("Evaluating if encrypt is required [%s = %s]", cypherRequired, isActive));

        if (!isActive) {
            LOG.info("Cifrado no es requerido");
            return stringToEncrypt;
        }

        try {
            CaasClientManagerFactory.setLoggerLevel(CaasLogLevel.Info);
            CaasCredentials caasCreds = buildCredentials();
            CaasClientManager clientManager = CaasClientManagerFactory.getInstance(caasCreds);

            LOG.info(String.format("Generando petición de cifrado del texto '%s'", stringToEncrypt));

            byte[] plaintext = stringToEncrypt.getBytes();
            EncodeDataClient encodeDataClient = new EncodeDataClient(plaintext, Codification.BYTE);
            DataClientInput input = new DataClientInput(encodeDataClient);

            DataClientOutput dataOutput = clientManager.execute(input, buildContext("DO"));

            String dataMaskedString = "";
            for (EncodeDataClient outSingle : dataOutput.getDataOutput()) {
                byte[] dataMasked = outSingle.getEncData();
                if (action == Action.MASK) {
                    dataMaskedString = StringUtils.newStringUtf8(dataMasked);
                    LOG.info("Finalizando enmascarado: " + dataMaskedString);
                } else {
                    dataMaskedString = java.util.Base64.getUrlEncoder().encodeToString(dataMasked);
                    LOG.info("Finalizando cifrado: " + dataMaskedString);
                }
            }

            return dataMaskedString;
        } catch (CaasException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }

    @Override
    public String decrypt(final String encryptedString, final String fieldName, final String registryId) {
        if (encryptedString == null) {
            return null;
        }

        boolean hasRoutineDataProcessingActiveConfiguration = setUp(fieldName, registryId);
        LOG.info(String.format("Evaluating if have active configuration for data processing routine [%s]", hasRoutineDataProcessingActiveConfiguration));

        if (hasRoutineDataProcessingActiveConfiguration) {
            LOG.info("Descifrado interno no es requerido");
            return encryptedString;
        }

        Boolean isActive = configurationManager.getBooleanProperty(cypherRequired, false);
        LOG.info(String.format("Evaluating if decrypt is required [%s = %s]", cypherRequired, isActive));

        if (!isActive) {
            LOG.info("Descifrado no es requerido");
            return encryptedString;
        }

        try {
            CaasClientManagerFactory.setLoggerLevel(CaasLogLevel.Info);
            CaasCredentials caasCreds = buildCredentials();
            CaasClientManager clientManager = CaasClientManagerFactory.getInstance(caasCreds);

            LOG.info(String.format("Generando petición de descifrado del texto '%s'", encryptedString));

            byte[] plaintext = java.util.Base64.getUrlDecoder().decode(encryptedString);
            EncodeDataClient encodeDataClient = new EncodeDataClient(plaintext, Codification.BYTE);
            DataClientInput input = new DataClientInput(encodeDataClient);

            DataClientOutput dataOutput = clientManager.execute(input, buildContext("UNDO"));

            String dataUnmaskedString = "";
            for (EncodeDataClient outSingle : dataOutput.getDataOutput()) {
                byte[] dataUnmasked = outSingle.getEncData();
                dataUnmaskedString = StringUtils.newStringUtf8(dataUnmasked);
            }

            LOG.info("Finalizando descifrado: " + dataUnmaskedString);
            return dataUnmaskedString;
        } catch (CaasException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }

    private CaasCredentials buildCredentials() throws CaasConfigurationException {
        String appId = configurationManager.getProperty(propertyAppId);
        String password = configurationManager.getProperty(propertyPassword);

        if (appId == null) {
            LOG.error("appId is null");
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR);
        } else {
            LOG.info(String.format("Building credentials with property appId (before clean) [%s = %s]", propertyAppId, appId));
            String[] splitUser = appId.split(":");
            appId = splitUser[splitUser.length - 1].trim();
            LOG.info(String.format("Building credentials with property appId (after clean) [%s = %s]", propertyAppId, appId));
        }
        LOG.info(String.format("Building credentials with property password [%s = %s]", propertyPassword, password));

        return CaasCredentials.build(appId, password);
    }

    private CaasContext buildContext(final String operation) {
        String type = configurationManager.getProperty(propertyContextType);
        String origin = configurationManager.getProperty(propertyContextOrigin);
        String endpoint = configurationManager.getProperty(propertyContextEndpoint);
        String securityLevel = configurationManager.getProperty(propertyContextSecurityLevel);

        LOG.info(String.format("Building context with property contextType [%s = %s]", propertyContextType, type));
        LOG.info(String.format("Building context with property contextOrigin [%s = %s]", propertyContextOrigin, origin));
        LOG.info(String.format("Building context with property contextEndpoint [%s = %s]", propertyContextEndpoint, endpoint));
        LOG.info(String.format("Building context with property contextSecurityLevel [%s = %s]", propertyContextSecurityLevel, securityLevel));

        CaasContext context = new CaasContext();
        context.put("operation", operation);
        context.put("type", type);
        context.put("origin", origin);
        context.put("endpoint", endpoint);
        context.put("securityLevel", securityLevel);
        return context;
    }
}
