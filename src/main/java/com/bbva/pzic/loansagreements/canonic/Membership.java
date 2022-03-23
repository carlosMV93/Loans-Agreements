package com.bbva.pzic.loansagreements.canonic;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "membership", namespace = "urn:com:bbva:pzic:loansagreements:canonic")
@XmlType(name = "membership", namespace = "urn:com:bbva:pzic:loansagreements:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Membership implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Internal identifier associated to the membership program for the Loans
	 * Agreement.
	 */
	private String id;
	/**
	 * Description of the membership program for the Loans Agreement.
	 */
	private String description;
	/**
	 * Type membership program for the Loans Agreement.
	 */
	private String membershipType;
	/**
	 * Delivery details for the membership program documentation.
	 */
	private List<Delivery> deliveries;
	/**
	 * Membership status program for the Loans Agreement.
	 */
	private String status;
	/**
	 * Additional products associated with the membership program for the loan.
	 */
	private List<RelatedContract> relatedContracts;

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

	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<RelatedContract> getRelatedContracts() {
		return relatedContracts;
	}

	public void setRelatedContracts(List<RelatedContract> relatedContracts) {
		this.relatedContracts = relatedContracts;
	}
}