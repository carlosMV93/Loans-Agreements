package com.bbva.pzic.loansagreements.canonic;

import com.bbva.jee.arq.spring.core.auditoria.DatoAuditable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "relatedContract", namespace = "urn:com:bbva:pzic:loansagreements:canonic")
@XmlType(name = "relatedContract", namespace = "urn:com:bbva:pzic:loansagreements:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class RelatedContract implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Identifier associated to the contract.
	 */
	@DatoAuditable(omitir = true)
	private String contractId;
	/**
	 * Contract number.
	 */
	@DatoAuditable(omitir = true)
	private String number;
	/**
	 * Contract number type based on the financial product type.
	 */
	private NumberType numberType;
	/**
	 * Financial product associated to the contract.
	 */
	private Product product;

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

	public NumberType getNumberType() {
		return numberType;
	}

	public void setNumberType(NumberType numberType) {
		this.numberType = numberType;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}