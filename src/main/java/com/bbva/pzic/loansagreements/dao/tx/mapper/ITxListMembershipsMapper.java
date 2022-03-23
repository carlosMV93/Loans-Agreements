package com.bbva.pzic.loansagreements.dao.tx.mapper;

import com.bbva.pzic.loansagreements.business.dto.InputListMemberships;
import com.bbva.pzic.loansagreements.dao.model.ugoc.FormatoUGFEGOC;
import com.bbva.pzic.loansagreements.dao.model.ugoc.FormatoUGFSGOC;
import com.bbva.pzic.loansagreements.canonic.Membership;

import java.util.List;

/**
 * Created on 14/12/2018.
 * 
 * @author Entelgy
 */
public interface ITxListMembershipsMapper {

	FormatoUGFEGOC mapIn(InputListMemberships dtoIn);

	List<Membership> mapOut(FormatoUGFSGOC formatOutput);
}