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
public class DTOIntDelivery {

	@NotNull(groups = ValidationGroup.CreateMembership.class)
	@Size(max = 1, groups =  ValidationGroup.CreateMembership.class)
	private String deliveryType;

	@NotNull(groups = ValidationGroup.CreateMembership.class)
	@Size(max = 1, groups =  ValidationGroup.CreateMembership.class)
	private String documentType;

	@Valid
	@NotNull(groups = ValidationGroup.CreateMembership.class)
	private List<DTOIntContactDetail> contactDetails;

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public List<DTOIntContactDetail> getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(List<DTOIntContactDetail> contactDetails) {
		this.contactDetails = contactDetails;
	}
}