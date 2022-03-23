package com.bbva.pzic.loansagreements.canonic;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "membershipData", namespace = "urn:com:bbva:pzic:loansagreements:canonic")
@XmlType(name = "membershipData", namespace = "urn:com:bbva:pzic:loansagreements:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class MembershipData implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Membership Data
     */
    private Membership data;

    public Membership getData() {
        return data;
    }

    public void setData(Membership data) {
        this.data = data;
    }
}