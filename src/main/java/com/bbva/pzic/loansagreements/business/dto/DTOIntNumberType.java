package com.bbva.pzic.loansagreements.business.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created on 14/12/2018.
 * 
 * @author Entelgy
 */
public class DTOIntNumberType {

	@Size(max = 1, groups =  ValidationGroup.CreateMembership.class)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}