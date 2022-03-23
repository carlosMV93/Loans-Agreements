package com.bbva.pzic.loansagreements.facade.v0.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.loansagreements.business.dto.DTOIntMembership;
import com.bbva.pzic.loansagreements.business.dto.InputModifyMembership;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.facade.v0.mapper.IModifyMembershipMapper;
import com.bbva.pzic.loansagreements.util.mappers.EnumMapper;
import com.bbva.pzic.loansagreements.util.mappers.Mapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 14/12/2018.
 *
 * @author Entelgy
 */
@Mapper
public class ModifyMembershipMapper implements IModifyMembershipMapper {

    private static final Log LOG = LogFactory.getLog(ModifyMembershipMapper.class);

    @Autowired
    private EnumMapper mapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public InputModifyMembership mapIn(final String membershipId,
                                       final Membership membership) {
        LOG.info("... called method ModifyMembershipMapper.mapIn ...");
        InputModifyMembership input = new InputModifyMembership();
        input.setMembershipId(membershipId);

        if (membership != null && membership.getStatus() != null) {
            input.setMembership(new DTOIntMembership());
            input.getMembership().setStatus(mapper
                    .getBackendValue("loansAgreements.status", membership.getStatus()));
        }
        return input;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public ServiceResponse<Membership> mapOut(final Membership membership) {
        LOG.info("... called method ModifyMembershipMapper.mapOut ...");
        if (membership == null) {
            return null;
        }
        return ServiceResponse.data(membership).pagination(null).build();
    }


}