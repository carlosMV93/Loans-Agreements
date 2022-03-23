package com.bbva.pzic.loansagreements.canonic;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "product", namespace = "urn:com:bbva:pzic:loansagreements:canonic")
@XmlType(name = "product", namespace = "urn:com:bbva:pzic:loansagreements:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Financial product identifier.
	 */
	private String id;
	/**
	 * Financial product associated to the contract.
	 */
	private ProductType productType;
	/**
	 * Type of relation between the related contract and the Loans Agreement.
	 */
	private RelationType relationType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public RelationType getRelationType() {
		return relationType;
	}

	public void setRelationType(RelationType relationType) {
		this.relationType = relationType;
	}
}