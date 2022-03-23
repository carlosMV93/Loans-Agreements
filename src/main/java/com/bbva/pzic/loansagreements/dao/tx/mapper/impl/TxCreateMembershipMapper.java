package com.bbva.pzic.loansagreements.dao.tx.mapper.impl;

import com.bbva.pzic.loansagreements.dao.tx.mapper.ITxCreateMembershipMapper;
import com.bbva.pzic.loansagreements.business.dto.DTOIntMembership;
import com.bbva.pzic.loansagreements.dao.model.ugof.FormatoUGMOFE1;
import com.bbva.pzic.loansagreements.dao.model.ugof.FormatoUGMOFS1;
import com.bbva.pzic.loansagreements.canonic.Membership;
import com.bbva.pzic.loansagreements.util.mappers.EnumMapper;
import com.bbva.pzic.loansagreements.util.mappers.Mapper;
import com.bbva.pzic.loansagreements.util.orika.impl.ConfigurableMapper;
import com.bbva.pzic.loansagreements.util.orika.MapperFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 14/12/2018.
 * 
 * @author Entelgy
 */
@Mapper
public class TxCreateMembershipMapper extends ConfigurableMapper
		implements ITxCreateMembershipMapper {

	private static final Log LOG = LogFactory.getLog(TxCreateMembershipMapper.class);

	@Autowired
	private EnumMapper enumMapper;

	@Override
	protected void configure(MapperFactory factory) {
		super.configure(factory);

		factory.classMap(DTOIntMembership.class, FormatoUGMOFE1.class)
				.field("membershipType", "tipafil")
				.field("relatedContracts[0].contractId", "cccvin")
				.field("relatedContracts[0].number", "nropro")
				.field("relatedContracts[0].numberType.id", "tipcvin")
				.field("relatedContracts[0].product.id", "idvin")
				.field("relatedContracts[0].product.productType.id", "tipvin")
				.field("relatedContracts[0].product.relationType.id", "tiprel")
				.field("deliveries[0].deliveryType", "tipoenv")
				.field("deliveries[0].documentType", "conmail")
				.field("deliveries[0].contactDetails[0].id", "idemail")
				.register();

		factory.classMap(FormatoUGMOFS1.class, Membership.class)
				.field("idafil", "id")
				.field("desafil", "description")
				.field("tipafil", "membershipType")
				.field("cccvin", "relatedContracts[0].contractId")
				.field("nropro", "relatedContracts[0].number")
				.field("tipcvin", "relatedContracts[0].numberType.id")
				.field("idvin", "relatedContracts[0].product.id")
				.field("tipvin", "relatedContracts[0].product.productType.id")
				.field("tiprel", "relatedContracts[0].product.relationType.id")
				.field("tipoenv", "deliveries[0].deliveryType")
				.field("conmail", "deliveries[0].documentType")
				.field("idemail", "deliveries[0].contactDetails[0].id")
				.field("estafil", "status")
				.register();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FormatoUGMOFE1 mapIn(final DTOIntMembership dtoIn) {
		LOG.info("... Invoking method TxCreateMembershipMapper.mapIn ...");
		return map(dtoIn, FormatoUGMOFE1.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Membership mapOut(final FormatoUGMOFS1 formatOutput) {
		LOG.info("... Invoking method TxCreateMembershipMapper.mapOut ...");
		Membership membership = map(formatOutput, Membership.class);
		membership.setMembershipType(enumMapper
				.getEnumValue("loansAgreements.membershipType", formatOutput.getTipafil()));

		if( formatOutput.getTipvin()!=null ){
			membership.getRelatedContracts().get(0).getProduct().getProductType().setId( enumMapper
				.getEnumValue("loansAgreements.product.productType.id", formatOutput.getTipvin()));
		}

		if( formatOutput.getTiprel()!=null ){
			membership.getRelatedContracts().get(0).getProduct().getRelationType().setId( enumMapper
				.getEnumValue("loansAgreements.product.relationType.id", formatOutput.getTiprel()));
		}

		if( formatOutput.getTipoenv()!=null ){
			membership.getDeliveries().get(0).setDeliveryType( enumMapper
				.getEnumValue("loansAgreements.deliveryType", formatOutput.getTipoenv()));
		}

		if( formatOutput.getConmail()!=null){
			membership.getDeliveries().get(0).setDocumentType( enumMapper
				.getEnumValue("loansAgreements.documentType", formatOutput.getConmail()));
		}

		membership.setStatus( enumMapper
			.getEnumValue("loansAgreements.status", formatOutput.getEstafil()));

		return membership;
	}

}