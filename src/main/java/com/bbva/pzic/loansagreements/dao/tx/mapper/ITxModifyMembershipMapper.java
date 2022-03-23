package com.bbva.pzic.loansagreements.dao.tx.mapper;

import com.bbva.pzic.loansagreements.business.dto.InputModifyMembership;
import com.bbva.pzic.loansagreements.dao.model.ugog.FormatoUGMOGE1;
import com.bbva.pzic.loansagreements.dao.model.ugog.FormatoUGMOGS1;
import com.bbva.pzic.loansagreements.canonic.Membership;

/**
 * Created on 14/12/2018.
 * 
 * @author Entelgy
 */
public interface ITxModifyMembershipMapper {

	FormatoUGMOGE1 mapIn(InputModifyMembership dtoIn);

	Membership mapOut(FormatoUGMOGS1 formatOutput);
}