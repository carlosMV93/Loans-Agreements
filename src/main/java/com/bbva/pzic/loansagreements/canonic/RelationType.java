package com.bbva.pzic.loansagreements.canonic;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "relationType", namespace = "urn:com:bbva:pzic:loansagreements:canonic")
@XmlType(name = "relationType", namespace = "urn:com:bbva:pzic:loansagreements:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class RelationType implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Identifier of the type of relationship between the accounts and other
	 * products. Each country selects the type depending on its need.
	 */
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}