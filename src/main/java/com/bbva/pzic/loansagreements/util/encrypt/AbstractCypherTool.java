package com.bbva.pzic.loansagreements.util.encrypt;

import com.bbva.jee.arq.spring.core.servicing.configuration.ConfigurationManager;
import com.bbva.jee.arq.spring.core.servicing.context.ServiceInvocationContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Entelgy
 */
public abstract class AbstractCypherTool {

    public static final String ACCOUNT_ID = "accountId";
    public static final String CARD_ID = "cardId";

    private static final Log LOG = LogFactory.getLog(AbstractCypherTool.class);

    protected String cypherRequired;

    protected String propertyAppId;
    protected String propertyPassword;
    protected String propertyContextType;
    protected String propertyContextOrigin;
    protected String propertyContextEndpoint;
    protected String propertyContextSecurityLevel;
    @Autowired
    protected ConfigurationManager configurationManager;
    @Autowired
    private ServiceInvocationContext serviceInvocationContext;

    protected boolean setUp(final String fieldName, final String registryId) {
        String aap = serviceInvocationContext.getProperty(ServiceInvocationContext.AAP);
        LOG.debug(String.format("Se ha capturado el AAP '%s'", aap));

        if (findRoutineConfiguration(aap, registryId)) {
            return true;
        }

        this.cypherRequired = String.format("servicing.cypher.%s.cifradoRequerido", aap);
        this.propertyAppId = String.format("servicing.cypher.%s.app.id", aap);
        this.propertyPassword = String.format("servicing.cypher.%s.password", aap);
        this.propertyContextType = String.format("servicing.cypher.%s.context.type.%s", aap, fieldName);
        this.propertyContextOrigin = String.format("servicing.cypher.%s.context.origin", aap);
        this.propertyContextEndpoint = String.format("servicing.cypher.%s.context.endpoint", aap);
        this.propertyContextSecurityLevel = String.format("servicing.cypher.%s.context.security.level", aap);

        return false;
    }

    private boolean findRoutineConfiguration(final String aap, final String registryId) {
        List<String> smcsWithActiveDataProcessing =
                configurationManager.getListProperty(
                        String.format(
                                "servicing.aap.configuration.%s.routine.dataprocessingexecutor.active.smcs", aap));

        LOG.debug(String.format("Default SMC registryIds loaded %s", smcsWithActiveDataProcessing));

        if (smcsWithActiveDataProcessing != null && smcsWithActiveDataProcessing.contains(registryId)) {
            LOG.info(String.format("Routine configuration found for registryId %s", registryId));
            return true;
        }

        String aliasesKey = String.format("servicing.aap.configuration.%s.aliases", aap);
        List<String> aliases = configurationManager.getListProperty(aliasesKey);
        LOG.debug(String.format("Data processor routine aliases loaded %s = %s", aliasesKey, aliases));
        if (aliases != null) {
            for (String alias : aliases) {
                String key = String.format(
                        "servicing.aap.configuration.%s.%s.routine.dataprocessingexecutor.active.smcs", aap, alias);
                smcsWithActiveDataProcessing = configurationManager.getListProperty(key);
                LOG.debug(String.format("SMC registryIds loaded %s = %s", key, smcsWithActiveDataProcessing));
                if (smcsWithActiveDataProcessing != null && smcsWithActiveDataProcessing.contains(registryId)) {
                    LOG.info(String.format("Routine configuration found for registryId %s", registryId));
                    return true;
                }
            }
        }
        LOG.debug(String.format("Data processor routine configuration not found for SMC registryId [%s]", registryId));
        return false;
    }

    public abstract String mask(final String stringToEncrypt, final String fieldName, final String registryId);

    public abstract String encrypt(final String stringToEncrypt, final String fieldName, final String registryId);

    public abstract String decrypt(final String encryptedString, final String fieldName, final String registryId);
}
