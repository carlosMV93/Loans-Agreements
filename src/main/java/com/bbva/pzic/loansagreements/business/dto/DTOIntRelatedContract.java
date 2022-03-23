package com.bbva.pzic.loansagreements.business.dto;

import javax.validation.constraints.NotNull;
import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * Created on 14/12/2018.
 * 
 * @author Entelgy
 */
public class DTOIntRelatedContract {

	@Size(max = 20, groups =  ValidationGroup.CreateMembership.class)
	private String contractId;

	@Size(max = 20, groups =  ValidationGroup.CreateMembership.class)
	private String number;

	@Valid
	private DTOIntNumberType numberType;

	@Valid
	private DTOIntProduct product;

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public DTOIntNumberType getNumberType() {
		return numberType;
	}

	public void setNumberType(DTOIntNumberType numberType) {
		this.numberType = numberType;
	}

	public DTOIntProduct getProduct() {
		return product;
	}

	public void setProduct(DTOIntProduct product) {
		this.product = product;
	}
}