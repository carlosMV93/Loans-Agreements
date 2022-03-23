package com.bbva.pzic.loansagreements.dao.tx.mapper.impl;

import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.dao.tx.mapper.ITxListMembershipsMapper;
import com.bbva.pzic.loansagreements.business.dto.InputListMemberships;
import com.bbva.pzic.loansagreements.dao.model.ugoc.FormatoUGFEGOC;
import com.bbva.pzic.loansagreements.dao.model.ugoc.FormatoUGFSGOC;
import com.bbva.pzic.loansagreements.util.mappers.EnumMapper;
import com.bbva.pzic.loansagreements.util.mappers.Mapper;
import com.bbva.pzic.loansagreements.util.orika.impl.ConfigurableMapper;
import com.bbva.pzic.loansagreements.util.orika.MapperFactory;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 14/12/2018.
 *
 * @author Entelgy
 */
@Mapper
public class TxListMembershipsMapper extends ConfigurableMapper
        implements ITxListMembershipsMapper {

    private static final Log LOG = LogFactory.getLog(TxListMembershipsMapper.class);

    @Autowired
    private EnumMapper enumMapper;

    @Override
    protected void configure(MapperFactory factory) {

        super.configure(factory);
        factory.classMap(InputListMemberships.class, FormatoUGFEGOC.class)
                .field("membershipType", "tipafil")
                .register();

        factory.classMap(FormatoUGFSGOC.class, Membership.class)
                .field("idafil", "id")
                .field("desafil", "description")
                .field("tipafil", "membershipType")
                .field("tipoenv", "deliveries[0].deliveryType")
                .field("conmail", "deliveries[0].documentType")
                .field("idemail", "deliveries[0].contactDetails[0].id")
                .field("estafil", "status")
                .register();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FormatoUGFEGOC mapIn(final InputListMemberships dtoIn) {
        LOG.info("... Invoking method TxListMembershipsMapper.mapIn ...");
        if (dtoIn == null) {
            return null;
        }
        return map(dtoIn, FormatoUGFEGOC.class);
    }

    @Override
    public List<Membership> mapOut(FormatoUGFSGOC formatOutput) {
        LOG.info("... Invoking method TxListMembershipsMapper.mapOut ...");
        Membership membership = map(formatOutput, Membership.class);
        if (StringUtils.isNotEmpty(formatOutput.getTipafil())) {
            membership.setMembershipType(enumMapper
                    .getEnumValue("loansAgreements.membershipType", formatOutput.getTipafil()));
        }

        if (StringUtils.isNotEmpty(formatOutput.getTipoenv())) {
            membership.getDeliveries().get(0).setDeliveryType(enumMapper
                    .getEnumValue("loansAgreements.deliveryType", formatOutput.getTipoenv()));
        }

        if (StringUtils.isNotEmpty(formatOutput.getConmail())) {
            membership.getDeliveries().get(0).setDocumentType(enumMapper
                    .getEnumValue("loansAgreements.documentType", formatOutput.getConmail()));
        }

        membership.setStatus(enumMapper
                .getEnumValue("loansAgreements.status", formatOutput.getEstafil()));
        List<Membership> listMemberships = new ArrayList<>();
        listMemberships.add(membership);
        return listMemberships;
    }


}