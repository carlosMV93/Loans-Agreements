package com.bbva.pzic.loansagreements.canonic;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "contactDetail", namespace = "urn:com:bbva:pzic:loansagreements:canonic")
@XmlType(name = "contactDetail", namespace = "urn:com:bbva:pzic:loansagreements:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContactDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Contact information identifier.
	 */
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}