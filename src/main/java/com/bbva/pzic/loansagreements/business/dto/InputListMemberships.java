package com.bbva.pzic.loansagreements.business.dto;

import javax.validation.constraints.Size;

/**
 * Created on 14/12/2018.
 * 
 * @author Entelgy
 */
public class InputListMemberships {

	@Size(max = 2, groups =  ValidationGroup.ListMemberships.class)
	private String membershipType;

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
}