package com.bbva.pzic.loansagreements.business.dto;

import javax.validation.constraints.NotNull;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * Created on 14/12/2018.
 * 
 * @author Entelgy
 */
public class DTOIntMembership {

	private String id;

	private String description;

	@NotNull(groups = ValidationGroup.CreateMembership.class)
	@Size(max = 2, groups =  ValidationGroup.CreateMembership.class)
	private String membershipType;

	@Valid
	@NotNull(groups = ValidationGroup.CreateMembership.class)
	private List<DTOIntDelivery> deliveries;

	@Size(max = 1, groups =  ValidationGroup.ModifyMembership.class)
	private String status;

	@Valid
	private List<DTOIntRelatedContract> relatedContracts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public List<DTOIntDelivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<DTOIntDelivery> deliveries) {
		this.deliveries = deliveries;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<DTOIntRelatedContract> getRelatedContracts() {
		return relatedContracts;
	}

	public void setRelatedContracts(List<DTOIntRelatedContract> relatedContracts) {
		this.relatedContracts = relatedContracts;
	}
}