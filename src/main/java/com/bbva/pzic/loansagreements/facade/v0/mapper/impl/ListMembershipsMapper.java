package com.bbva.pzic.loansagreements.facade.v0.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.loansagreements.facade.v0.mapper.IListMembershipsMapper;
import com.bbva.pzic.loansagreements.business.dto.InputListMemberships;
import java.util.List;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.util.mappers.EnumMapper;
import com.bbva.pzic.loansagreements.util.mappers.Mapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 14/12/2018.
 * 
 * @author Entelgy
 */
@Mapper
public class ListMembershipsMapper implements IListMembershipsMapper {

	private static final Log LOG = LogFactory.getLog(ListMembershipsMapper.class);

	@Autowired
	private EnumMapper enumMapper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public InputListMemberships mapIn(final String membershipType) {
		LOG.info("... called method ListMembershipsMapper.mapIn ...");
		InputListMemberships input = new InputListMemberships();
		input.setMembershipType(enumMapper.getBackendValue("loansAgreements.membershipType", membershipType ) );
		return input;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public ServiceResponse<List<Membership>> mapOut(final List<Membership> membership) {
		LOG.info("... called method ListMembershipsMapper.mapOut ...");
		if (CollectionUtils.isEmpty(membership)) {
			return null;
		}
		return ServiceResponse.data(membership).pagination(null).build();
	}
}