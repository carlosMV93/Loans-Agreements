package com.bbva.pzic.loansagreements.canonic;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.List;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "delivery", namespace = "urn:com:bbva:pzic:loansagreements:canonic")
@XmlType(name = "delivery", namespace = "urn:com:bbva:pzic:loansagreements:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Delivery implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Indicates the type of document that will be send to the customer.
	 */
	private String deliveryType;
	/**
	 * Type of Document that is sent.
	 */
	private String documentType;
	/**
	 * The customer contact information.
	 */
	private List<ContactDetail> contactDetails;

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

	public List<ContactDetail> getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(List<ContactDetail> contactDetails) {
		this.contactDetails = contactDetails;
	}
}