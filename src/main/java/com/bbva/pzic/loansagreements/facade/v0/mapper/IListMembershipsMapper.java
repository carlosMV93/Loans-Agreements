package com.bbva.pzic.loansagreements.facade.v0.mapper;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.loansagreements.business.dto.InputListMemberships;
import java.util.List;
import com.bbva.pzic.loansagreements.canonic.Membership;

/**
 * Created on 14/12/2018.
 * 
 * @author Entelgy
 */
public interface IListMembershipsMapper {

	InputListMemberships mapIn(String membershipType);

	ServiceResponse<List<Membership>> mapOut(List<Membership> membership);
}