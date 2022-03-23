package com.bbva.pzic.loansagreements.dao.tx.mapper;

import com.bbva.pzic.loansagreements.business.dto.DTOIntMembership;
import com.bbva.pzic.loansagreements.dao.model.ugof.FormatoUGMOFE1;
import com.bbva.pzic.loansagreements.dao.model.ugof.FormatoUGMOFS1;
import com.bbva.pzic.loansagreements.canonic.Membership;

/**
 * Created on 14/12/2018.
 * 
 * @author Entelgy
 */
public interface ITxCreateMembershipMapper {

	FormatoUGMOFE1 mapIn(DTOIntMembership dtoIn);

	Membership mapOut(FormatoUGMOFS1 formatOutput);
}