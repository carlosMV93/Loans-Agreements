package com.bbva.pzic.loansagreements.facade.v0.mapper;

import com.bbva.pzic.loansagreements.business.dto.DTOIntMembership;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.canonic.MembershipData;

/**
 * Created on 14/12/2018.
 *
 * @author Entelgy
 */
public interface ICreateMembershipMapper {

    DTOIntMembership mapIn(Membership membership);

    MembershipData mapOut(Membership membership);
}