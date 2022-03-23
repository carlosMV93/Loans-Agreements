package com.bbva.pzic.loansagreements.business;

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
public interface ISrvIntLoansAgreements {

	/**
	 * Allows consulting the list of loan memberships of a customer.
	 * 
	 * @param input
	 *            dto with input fields to validate
	 * @return {@link List}
	 */
	List<Membership> listMemberships(InputListMemberships input);

	/**
	 * It allows to create a loan membership.
	 * 
	 * @param dtoInt
	 *            dto with input fields to validate
	 * @return {@link Membership}
	 */
	Membership createMembership(DTOIntMembership dtoInt);

	/**
	 * It allows modify a Loans Agreement membership for a customer.
	 * 
	 * @param input
	 *            dto with input fields to validate
	 * @return {@link Membership}
	 */
	Membership modifyMembership(InputModifyMembership input);
}