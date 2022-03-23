package com.bbva.pzic.loansagreements.dao.tx.mapper.impl;

import com.bbva.pzic.loansagreements.dao.tx.mapper.ITxModifyMembershipMapper;
import com.bbva.pzic.loansagreements.business.dto.InputModifyMembership;
import com.bbva.pzic.loansagreements.dao.model.ugog.FormatoUGMOGE1;
import com.bbva.pzic.loansagreements.dao.model.ugog.FormatoUGMOGS1;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.util.mappers.EnumMapper;
import com.bbva.pzic.loansagreements.util.mappers.Mapper;
import com.bbva.pzic.loansagreements.util.orika.impl.ConfigurableMapper;
import com.bbva.pzic.loansagreements.util.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 14/12/2018.
 * 
 * @author Entelgy
 */
@Mapper
public class TxModifyMembershipMapper extends ConfigurableMapper
		implements ITxModifyMembershipMapper {

	@Autowired
	private EnumMapper enumMapper;

	@Override
	protected void configure(MapperFactory factory) {
		super.configure(factory);

		factory.classMap(InputModifyMembership.class, FormatoUGMOGE1.class)
				.field("membershipId", "idafil")
				.field("membership.status", "estafil")
				.register();

		factory.classMap(FormatoUGMOGS1.class, Membership.class)
				.field("idafil", "id")
				.field("desafil", "description")
				.field("tipafil", "membershipType")
				.field("estafil", "status")
				.register();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FormatoUGMOGE1 mapIn(final InputModifyMembership dtoIn) {
		return map(dtoIn, FormatoUGMOGE1.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Membership mapOut(final FormatoUGMOGS1 formatOutput) {
		Membership membership = map(formatOutput, Membership.class);
		membership.setMembershipType( enumMapper
			.getEnumValue("loansAgreements.membershipType", formatOutput.getTipafil()));
		membership.setStatus( enumMapper
			.getEnumValue("loansAgreements.status",formatOutput.getEstafil() ));
		return membership;
	}

}