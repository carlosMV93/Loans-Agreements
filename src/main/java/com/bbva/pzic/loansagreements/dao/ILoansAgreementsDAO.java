package com.bbva.pzic.loansagreements.dao;

import java.util.List;
import com.bbva.pzic.loansagreements.business.dto.InputListMemberships;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.business.dto.DTOIntMembership;
import com.bbva.pzic.loansagreements.business.dto.InputModifyMembership;

/**
 * Created on 14/12/2018.
 * 
 * @author Entelgy
 */
public interface ILoansAgreementsDAO {

	List<Membership> listMemberships(InputListMemberships input);

	Membership createMembership(DTOIntMembership dtoInt);

	Membership modifyMembership(InputModifyMembership input);
}