package com.bbva.pzic.loansagreements.dao.impl;

import com.bbva.pzic.loansagreements.dao.ILoansAgreementsDAO;
import java.util.List;
import com.bbva.pzic.loansagreements.business.dto.InputListMemberships;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.business.dto.DTOIntMembership;
import com.bbva.pzic.loansagreements.business.dto.InputModifyMembership;
import org.springframework.stereotype.Repository;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import com.bbva.pzic.loansagreements.dao.tx.TxListMemberships;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbva.pzic.loansagreements.dao.tx.TxCreateMembership;
import com.bbva.pzic.loansagreements.dao.tx.TxModifyMembership;

/**
 * Created on 14/12/2018.
 * 
 * @author Entelgy
 */
@Repository
public class LoansAgreementsDAO implements ILoansAgreementsDAO {

	private static final Log LOG = LogFactory.getLog(LoansAgreementsDAO.class);

	@Autowired
	private TxListMemberships txListMemberships;
	@Autowired
	private TxCreateMembership txCreateMembership;
	@Autowired
	private TxModifyMembership txModifyMembership;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Membership> listMemberships(final InputListMemberships input) {
		LOG.info("... Invoking method LoansAgreementsDAO.listMemberships ...");
		return txListMemberships.perform(input);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Membership createMembership(final DTOIntMembership dtoInt) {
		LOG.info("... Invoking method LoansAgreementsDAO.createMembership ...");
		return txCreateMembership.perform(dtoInt);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Membership modifyMembership(final InputModifyMembership input) {
		LOG.info("... Invoking method LoansAgreementsDAO.modifyMembership ...");
		return txModifyMembership.perform(input);
	}
}