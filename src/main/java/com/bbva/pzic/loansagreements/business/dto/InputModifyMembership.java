package com.bbva.pzic.loansagreements.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created on 14/12/2018.
 * 
 * @author Entelgy
 */
public class InputModifyMembership {


	@NotNull(groups = ValidationGroup.ModifyMembership.class)
	@Size(max = 8, groups =  ValidationGroup.ModifyMembership.class)
	private String membershipId;

	@Valid
	private DTOIntMembership membership;

	public String getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
	}

	public DTOIntMembership getMembership() {
		return membership;
	}

	public void setMembership(DTOIntMembership membership) {
		this.membership = membership;
	}
}