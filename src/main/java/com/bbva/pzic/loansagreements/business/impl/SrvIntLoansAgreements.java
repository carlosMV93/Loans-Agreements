package com.bbva.pzic.loansagreements.business.impl;

import com.bbva.pzic.loansagreements.business.ISrvIntLoansAgreements;
import com.bbva.pzic.loansagreements.business.dto.DTOIntMembership;
import com.bbva.pzic.loansagreements.business.dto.InputListMemberships;
import com.bbva.pzic.loansagreements.business.dto.InputModifyMembership;
import com.bbva.pzic.loansagreements.business.dto.ValidationGroup;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.dao.ILoansAgreementsDAO;
import com.bbva.pzic.routine.validator.Validator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 14/12/2018.
 *
 * @author Entelgy
 */
@Service
public class SrvIntLoansAgreements implements ISrvIntLoansAgreements {

    private static final Log LOG = LogFactory.getLog(SrvIntLoansAgreements.class);
    @Autowired
    private ILoansAgreementsDAO loansAgreementsDAO;
    @Autowired
    private Validator validator;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Membership> listMemberships(final InputListMemberships input) {
        LOG.info("... Invoking method SrvIntLoansAgreements.listMemberships ...");
        LOG.info("... Validating listMemberships input parameter ...");
        validator.validate(input, ValidationGroup.ListMemberships.class);
        return loansAgreementsDAO.listMemberships(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Membership createMembership(final DTOIntMembership dtoInt) {
        LOG.info("... Invoking method SrvIntLoansAgreements.createMembership ...");
        LOG.info("... Validating createMembership input parameter ...");
        validator.validate(dtoInt, ValidationGroup.CreateMembership.class);
        return loansAgreementsDAO.createMembership(dtoInt);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Membership modifyMembership(final InputModifyMembership input) {
        LOG.info("... Invoking method SrvIntLoansAgreements.modifyMembership ...");
        LOG.info("... Validating modifyMembership input parameter ...");
        validator.validate(input, ValidationGroup.ModifyMembership.class);
        return loansAgreementsDAO.modifyMembership(input);
    }
}