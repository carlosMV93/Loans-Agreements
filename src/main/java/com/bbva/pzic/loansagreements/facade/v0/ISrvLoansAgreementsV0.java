package com.bbva.pzic.loansagreements.facade.v0;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.loansagreements.canonic.Membership;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created on 14/12/2018.
 *
 * @author Entelgy
 */
public interface ISrvLoansAgreementsV0 {

    /**
     * Allows consulting the list of loan memberships of a customer.
     *
     * @param membershipType membership program type for the Loans Agreement.
     * @return {@link List<Membership>}
     */
    ServiceResponse<List<Membership>> listMemberships(String membershipType);

    /**
     * It allows to create a loan membership.
     *
     * @param membership payload
     * @return {@link Membership}
     */
    Response createMembership(Membership membership);

    /**
     * It allows modify a Loans Agreement membership for a customer.
     *
     * @param membershipId unique Loans Agreement membership identifier
     * @param membership   payload
     * @return {@link Membership}
     */
    ServiceResponse<Membership> modifyMembership(String membershipId, Membership membership);
}