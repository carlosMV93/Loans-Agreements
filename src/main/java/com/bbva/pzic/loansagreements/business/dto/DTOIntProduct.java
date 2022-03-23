package com.bbva.pzic.loansagreements.business.dto;

import javax.validation.constraints.NotNull;
import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * Created on 14/12/2018.
 * 
 * @author Entelgy
 */
public class DTOIntProduct {

	@Size(max = 2, groups =  ValidationGroup.CreateMembership.class)
	private String id;

	@Valid
	private DTOIntProductType productType;

	@Valid
	private DTOIntRelationType relationType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DTOIntProductType getProductType() {
		return productType;
	}

	public void setProductType(DTOIntProductType productType) {
		this.productType = productType;
	}

	public DTOIntRelationType getRelationType() {
		return relationType;
	}

	public void setRelationType(DTOIntRelationType relationType) {
		this.relationType = relationType;
	}
}