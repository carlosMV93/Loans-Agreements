package com.bbva.pzic.loansagreements.facade.v0.mapper;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.business.dto.InputModifyMembership;

/**
 * Created on 14/12/2018.
 * 
 * @author Entelgy
 */
public interface IModifyMembershipMapper {

	InputModifyMembership mapIn(String membershipId, Membership membership);

	ServiceResponse<Membership> mapOut(Membership membership);
}